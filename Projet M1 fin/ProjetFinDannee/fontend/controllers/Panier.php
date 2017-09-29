<?php if (!defined('BASEPATH')) exit('No direct script access allowed');

class Panier extends CI_Controller
{
	private $sw;

	public function __construct()
	{
		parent::__construct();
		$this->sw = load();
	}

	public function ajout($id, $cat = null, $details = null)
	{						
		$gets = $this->input->get();
		$qte = $gets['qte'];

		$session = $this->session->userdata('panier');
		if (!$session) {
			$this->session->set_userdata('panier', array());
		}
		$panier = $this->session->userdata('panier');
		if (array_key_exists($id, $panier)) {
			if ($qte != null) $panier[$id] = $qte;
			$this->session->set_flashdata('success', 'Quantité modifié avec succès');
		} else {
			if ($qte != null) $panier[$id] = $qte;
			else
			$panier[$id] = 1;
		}
		$this->session->set_userdata('panier', $panier);

		if ($details == "details") {
			redirect(base_url() . 'produits/detailsProduits/' . $id . "/".$cat."/details");
		}else{	
				
			if($cat == 'panier'){			 
				redirect(base_url() . 'panier/panier_view');	
			}else if($cat =='prod'){				
				redirect(base_url() . 'produits');
			}else {				
				redirect(base_url() . 'categories/index/'.$cat);
				
			}	
		}
	}

	public function panier_view()
	{
//		if(test_session()==0){
//			redirect(base_url() . "produits");
//		}else{
			$param_ = new stdClass();

			$session = $this->session->userdata('panier');
			if (!$session) {
				$this->session->set_userdata('panier', array());
			}
			$param_->array = array_keys($this->session->userdata('panier'));
			$data['produits_panier'] = $this->sw->__soapCall("ProduitsArray", array($param_));
			$data['panier'] = $this->session->userdata('panier');
			$this->template->write_view('header', 'partials/header', "");
			$this->template->write_view('content', 'panier/panier', $data);
			$this->template->write_view('footer', 'partials/footer', "");
			$this->template->render();
//		}
	}

	public function supprimer($id)
	{
		$panier = $this->session->userdata("panier");

		if (array_key_exists($id, $panier)) {
			unset($panier[$id]);
			$this->session->set_userdata('panier', $panier);
			$this->session->set_flashdata('success', 'Article supprimé avec succès');
		}
		redirect(base_url() . "panier/panier_view");

	}
}