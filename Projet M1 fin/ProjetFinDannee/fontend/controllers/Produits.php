<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Produits extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -  
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in 
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see http://codeigniter.com/user_guide/general/urls.html
	 */

	private $sw;

	public function __construct()
	{
		parent::__construct();

		$this->sw = load();

	}

	public function index()
	{
		$data = array();
		if ($this->session->userdata('panier')) {
			$data['panier']= $this->session->userdata('panier');
		}else{
			$data['panier'] = false;
		}		
		$data['produits']=$this->sw->__soapCall("getAllProduits_",array());
		$title= "Produits";
		$data['cat'] = "prod";
		$this->template->write('title',"ok");
		$this->template->write_view('header', 'partials/header',"");
		$this->template->write_view('slider', 'partials/slider', $data);
		$this->template->write_view('content', 'produits/produits', $data);
		$this->template->write_view('sidebar', 'partials/sidebar', "");
		$this->template->write_view('footer','partials/footer',"");
		$this->template->render();

	}
	public function detailsProduits($id,$idcategories){
		$param = new stdClass();
		$param->id = $id;
		$data['details']=$this->sw->__soapCall("SearchProduits",array($param));
		$param_ = new stdClass();
		$param_->id = $id;
		$param_->idcategorie=$idcategories;
		if ($this->session->userdata('panier')) {
			$data['panier']= $this->session->userdata('panier');
		}else{
			$data['panier'] = false;
		}
		$data['produits_compare']=$this->sw->__soapCall("ComparaisonProduits",array($param_));
		$this->template->write_view('header', 'partials/header', "");
		$this->template->write_view('content', 'produits/detailsProduits',$data);
		$this->template->write_view('footer','partials/footer',"");
		$this->template->render();
	}
}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */