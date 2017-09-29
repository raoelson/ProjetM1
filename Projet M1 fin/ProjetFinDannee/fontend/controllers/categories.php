<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Categories extends CI_Controller
{

    /**
     * Index Page for this controller.
     *
     * Maps to the following URL
     *        http://example.com/index.php/welcome
     *    - or -
     *        http://example.com/index.php/welcome/index
     *    - or -
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

    public function index($id)
    {
        $data = array();
        $param = new stdClass();
        $param->id = $id;
        $data['produits']=$this->sw->__soapCall("SearchCategories",array($param));
        $data['cat'] = $id;
        $this->template->write_view('header', 'partials/header',"");
        $this->template->write_view('slider', 'partials/slider', $data);
        $this->template->write_view('content', 'produits/produits', $data);
        $this->template->write_view('sidebar', 'partials/sidebar', "");
        $this->template->write_view('footer','partials/footer',"");
        $this->template->render();
    }
}