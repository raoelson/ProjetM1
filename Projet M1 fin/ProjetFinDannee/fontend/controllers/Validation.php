<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 01/01/2016
 * Time: 09:52
 */
if (!defined('BASEPATH')) exit('No direct script access allowed');

class Validation extends CI_Controller
{
	private $sw;
	private $commande;

	public function validation()
	{
		parent::__construct();
		if (is_logged_in() == 0) {
			redirect(base_url() . "utilisateurs");
		}
		if(test_session()==0){
			redirect(base_url() . "produits");
		}
		$this->sw = load();
		//$this->commande=new Commandes();
	}

	public function index()
	{
		if(test_session()==0){
			redirect(base_url() . "produits");
		}else{
			//$this->template->write_view('header', 'partials/header', "");
			$this->template->write_view('content', 'panier/livraison', "");
			$this->template->write_view('footer', 'partials/footer', "");
			$this->template->render();
		}
	}

	public function ajout()
	{
		$posts = $this->input->post();
		if ($posts['nom'] == "" && $posts['prenom'] == "" && $posts['adresse'] == "" && $posts['cp'] == "" && $posts['pays'] == "" &&
		$posts['ville'] == ""
		) {
			$this->session->set_flashdata('error', 'Veuillez remplir les champs vide');
			redirect(base_url() . "validation");
		} else {
			if ($this->session->userdata("user")['id'] != "") {
				$param = new stdClass();
				$param->user = $this->session->userdata("user")['id'];
				$param->nom =  $posts['nom'];
				$param->prenom = $posts['prenom'];
				$param->phone = $posts['phone']; 
				$param->adresse = $posts['adresse'];
				$param->cp =  $posts['cp'];
				$param->pays = $posts['pays'];
				$param->ville =  $posts['ville']; 
				$param->complement =  $posts['complement'];				
				$reponse = $this->sw->__soapCall("addLivraisonAdresse", array($param));
				if ($reponse != 0) {
					redirect(base_url() . "validation");
				}
			} else {
				redirect(base_url() . "utilisateurs");
			}
		}
	}

	public function supprimer($id)
	{
		$param = new stdClass();
		$param->id = $id;
		$reponse = $this->sw->__soapCall("deleteAdresses", array($param));
		if ($reponse == 1) {
			redirect(base_url() . "validation");
		}
	}

	public function validations($adresse, $livraison)
	{
		$this->setLivraison($adresse, $livraison);
		$data = validation_requete();
		$this->template->write_view('header', 'partials/header', "");
		$this->template->write_view('content', 'panier/validations', $data);
		$this->template->write_view('footer', 'partials/footer', "");
		$this->template->render();
	}

	public function setLivraison($adresse, $livraison)
	{
		$session = $this->session->userdata('adresse');
		if (!$session) {
			$this->session->set_userdata('adresse', array());
		}
		$adresse_ = $this->session->userdata('adresse');
		if ($livraison != null && $adresse != null) {
			$adresse_['adresse'] = $adresse;
			$adresse_['livraison'] = $livraison;
		} else {
			redirect(base_url() . "validation");
		}
		$this->session->set_userdata('adresse', $adresse_);
	}
	public function commandes_valider(){
		//getReference()
		
		$produits =  validation_requete()['produits_panier'];
		$panier = validation_requete()['panier'];
		if(isset($produits->return)){	
			$session = $this->session->userdata('adresse');		
			$param = new stdClass();
			$param->id = $this->session->userdata("user")['id'];
			$param->valid = false;
			$param->reference = getReference();
			$array = array();
			$reponses = "[";		
			if( sizeof($produits->return) == 1){
				//array_push($array, ('{id'.":".$produits->return->id.",".'qte'.":".$panier[$produits->return->id].",".'prix'.":".$produits->return->prix."}"));                
			    //array_push($array, (json_encode(array('id'=>$produits->return->id),array('prod'=>$panier[$produits->return->id]))));
			   $reponses = $reponses . "{\"id\":\"";

                        $reponses = $reponses . $produits->return->id;
                        
                        $reponses = $reponses . "\",\"cat\":\"";

                        $reponses = $reponses . $produits->return->categorieId->nom;
                        
                        $reponses = $reponses . "\",\"livraison\":\"";

                        $reponses = $reponses . $session['livraison'];
                        
                        $reponses = $reponses . "\",\"facturation\":\"";

                        $reponses = $reponses . $session['adresse'];
                        
                        $reponses = $reponses . "\",\"tva\":\"";

                        $reponses = $reponses . $produits->return->tvaId->valeur;
                        
                        $reponses = $reponses . "\",\"multiplicate\":\"";

                        $reponses = $reponses . $produits->return->tvaId->multiplicate;

                        $reponses = $reponses . "\",\"qte\":\"";

                        $reponses = $reponses . $panier[$produits->return->id];

                        $reponses = $reponses . "\",\"prix\":\"";

                        $reponses = $reponses . $produits->return->prix
                                . "\"},";
			}else{
				       
				      $test = 0;
				       $reponses = $reponses . "{\"livraison\":\"";

                        $reponses = $reponses . $session['livraison'];
                        
                        $reponses = $reponses . "\",\"facturation\":\"";

                        $reponses = $reponses . $session['adresse'];
				foreach ($produits->return as $value=>$key){ 
					    if($test!=$value){
					    	$reponses = $reponses . "{\"id\":\"";
                            $reponses = $reponses . $key->id;
					    }else{
					    $reponses = $reponses . "\",\"id\":\"";

                        $reponses = $reponses . $key->id;
					    }
                        $reponses = $reponses . "\",\"cat\":\"";

                        $reponses = $reponses . $key->categorieId->nom;
                        
                         $reponses = $reponses . "\",\"tva\":\"";

                        $reponses = $reponses . $key->tvaId->valeur;
                        
                        $reponses = $reponses . "\",\"multiplicate\":\"";

                        $reponses = $reponses . $key->tvaId->multiplicate;

                        $reponses = $reponses . "\",\"qte\":\"";

                        $reponses = $reponses . $panier[$key->id];

                        $reponses = $reponses . "\",\"prix\":\"";

                        $reponses = $reponses . $key->prix
                                . "\"},";	
				}
			}	
			$reponses = substr($reponses, 0,strlen($reponses)-1);			
			$reponses = $reponses . "]";			 			
			$param->commandes =$reponses;
			$rep=$this->sw->__soapCall("addCommandes", array($param));            
			if(isset($rep)){
				$session_=$this->session->userdata("commandes");
				if(!$session_){
					$this->session->set_userdata('commandes', array());
				}
				$this->session->userdata("commandes");
				$this->session->set_userdata('commandes',$param);
				remove_session();
				$this->output
				->set_content_type('application/json')
				->set_output(json_encode(array('message' => 'Votre commande est validé avec succès')));
			}

		}
	}

}

