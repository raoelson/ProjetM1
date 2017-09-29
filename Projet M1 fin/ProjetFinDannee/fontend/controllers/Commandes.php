<?php
if (!defined('BASEPATH')) exit('No direct script access allowed');

class Commandes extends CI_Controller
{

	private $sw;
	public function Commandes()
	{
		parent::__construct();
		$this->sw = load();
	}
	public function index($id){
		//		var_dump($id);
		//		die();
		//		$param = new stdClass();
		//		$param->user = $id;
		//		$data['commandes']=load()->__soapCall("RecuperationCommandes",array($param));
		//		$this->template->write_view('header', 'partials/header', "");
		//		$this->template->write_view('content', 'commandes/commandes', $data);
		//		$this->template->write_view('footer', 'partials/footer', "");
		//		$this->template->render();
		$this->details($id);
	}
	public function details($id){
        $data = $this->traitement($id);
		$this->template->write_view('header', 'partials/header', "");
		$this->template->write_view('content', 'commandes/details',$data);
		$this->template->write_view('footer', 'partials/footer', "");
		$this->template->render();
	}
	public function delete($id){
		$session = $this->session->userdata('user');
		if($id!=""){
			$param = new stdClass();
			$param->id = $id;
			$rep=$this->sw->__soapCall("deleteCommandes",array($param));
			if($rep->return==0){
				$this->session->set_flashdata('succes', '<center>Commande supprim&eacute; avec succes</center>');
			}
		}
		redirect(base_url() . 'commandes/index/' . $session['id']);
	}
	public function edit($id){
		$param = new stdClass();
		$session = $this->session->userdata('user');
		$gets = $this->input->get();
		$valider = $gets['valider'];
		$validation = false;
		if(isset($valider)) $validation = true;

		$param->id = $id;
		$param->valid = $validation;
		$rep=$this->sw->__soapCall("editCommandes",array($param));
		if($rep->return==0){
			$this->session->set_flashdata('succes', '<center>Commande modifi&eacute; avec succes</center>');
			redirect(base_url() . 'commandes/index/' . $session['id']);
		}
			
	}

	public function generar_pdf(){
	        
	 // enviamos el cabezal de la tabla
	        $arrHeading = array('Id', 'Categorie','Quantite','Prix','Tva','Total HT');          
	        $arrData    = $this->data();	     	       
	        $sTitulo    = 'Facture'; 	        
	        // generamos el pdf
	        generar_pdf($arrHeading,$arrData['dataliste'],$arrData["data"],$sTitulo);
	  }
	  public function data(){
	  	$session = $this->session->userdata('user');	  		  	
		$data = $this->traitement($session['id']);
	    $arrDatos=array();
	   $total =0; 
       $totalTTC =0; 
        foreach ($data['json']  as $row){
        	$total+=($row['prix'] * $row['qte']);
            $tva=round((($row['prix'] * $row['qte']) / ($row['multiplicate']) - ($row['prix'] * $row['qte'])), 2);
            $totalTTC+=$tva;        	        	        	
            $arrDatos[] = array(
                htmlspecialchars($row['id'],ENT_QUOTES),
                htmlspecialchars($row['cat'],ENT_QUOTES),
                htmlspecialchars($row['qte'],ENT_QUOTES),
                htmlspecialchars($row['prix'],ENT_QUOTES),
                htmlspecialchars($row['tva'],ENT_QUOTES),
                htmlspecialchars($row['prix']*$row['qte'],ENT_QUOTES),
            ); 
        }
        $data_['date'] = $data['date'];        
        $data_['totalHT'] = $total ." AR";
        $data_['totalTTC'] = $totalTTC+ $total ." AR";
        $data_['livraison'] = $data['adresse_livraison'];
        $data_['facturation'] = $data['adresse_facturation'];
        $data_['user'] = $data['user'];
         return(array('dataliste'=>$arrDatos,'data'=>$data_));
	  }
	  public function traitement($id){
	    $param = new stdClass();
		$param->id = $id;
		$rep=$this->sw->__soapCall("SearchCommandesDetails",array($param));
		$commandes = ($rep->return->commandes);
		$data['date'] = ($rep->return->dateCommandes)." ".($rep->return->timesCommandes);
		//$data['user'] = ($rep->return->utilisateurId->username);
		$data['json'] = (json_decode($commandes,true));



		///////////////////////////////////////////////////////////////////////
		$param__ = new stdClass();
		$param_ = new stdClass();
		$param___ = new stdClass();
		foreach ($data['json'] as $value){
			if(isset($value['livraison'])){
				$param_->id = $value['livraison'];
				$param___->id = $value['livraison'];
			}
			if(isset($value['facturation']))
			$param__->id = $value['facturation'];
		}

		$livraison = $this->sw->__soapCall("AdresseLivraisons", array($param_));
		$adresse = $this->sw->__soapCall("AdressesFacturations", array($param__));
		$data['adresse_livraison'] = $livraison->return->adresse." ".$livraison->return->cp." ".$livraison->return->ville." ".$livraison->return->pays;
		$data['adresse_facturation'] = $adresse->return->adresse." ".$adresse->return->cp." ".$adresse->return->ville." ".$adresse->return->pays;

		/////////////////////////////////////////////////////////////////////


		//////////////////////////////////////////////////////////////////////
			
			

		$rep_ = $this->sw->__soapCall("getNameUserAdresses", array($param___));
		$data['user'] = $rep_->return->nom." ".$rep_->return->prenom;
		//////////////////////////////////////////////////////////////////////
		return $data;
	  }
}