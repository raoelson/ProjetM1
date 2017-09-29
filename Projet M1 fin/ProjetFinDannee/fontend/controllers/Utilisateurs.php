<?php if (!defined('BASEPATH')) exit('No direct script access allowed');

class Utilisateurs extends CI_Controller
{
    private $sw;

    public function __construct()
    {
        parent::__construct();
        $this->sw = load();
    }

    public function index()
    {
        $data = array();
        $this->template->write_view('header', 'partials/header', "");
        $this->template->write_view('content', 'login/login', "");
        $this->template->write_view('footer', 'partials/footer', "");
        $this->template->render();
    }

    public function verify()
    {
        $posts = $this->input->post();
        if ($posts['login'] == "" && $posts['password']=="") {
            $data['message'] = "veuillez remplir les champs vides";
            $partials = "login/login";
        } else {
            $param = new stdClass();            
            $param->login = $posts['login'];
//            $param->password = hash('sha512', $posts['password']); 
			$param->password =  $posts['password'];                    
            $reponses = $this->sw->__soapCall("verificationUser", array($param, $param));
            if (isset($reponses->return->username)) {
                $array = array('login'=>$reponses->return->username,"id"=>$reponses->return->id);
                $this->session->set_userdata('user',$array);
                $url = $this->session->userdata('url');
                if($url!=false){                 
                 $this->session->unset_userdata("url");                              
                 redirect(base_url().'validation');
                }else{                	
                	redirect(base_url().'produits');
                	
                }                               
            } else {
                $data['message'] = "Login ou mot de passe incorrect";
                $partials = "login/login";
            }
        }
        $this->template->write_view('header', 'partials/header', "");
        $this->template->write_view('content', $partials, $data);
        $this->template->write_view('footer', 'partials/footer', "");
        $this->template->render();
    }

    public function deconnexion()
    {
       logout();
        redirect(base_url()."utilisateurs");
    }
}