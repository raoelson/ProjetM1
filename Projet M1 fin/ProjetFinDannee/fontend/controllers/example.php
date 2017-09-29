<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Index_c extends CI_Controller {

  public function __construct(){
        parent::__construct();
        $this->load->model('index_m','modelo');
  }
  
  function index(){
        $this->load->view('index_v');
  }
  
  public function generar_pdf(){
        
 // enviamos el cabezal de la tabla
        $arrHeading = array('Id', 'Campo');

 // obtenemos los datos resultantes de la consulta
        $arrData    = $this->modelo->get_data_pdf();

  // enviaremos el titulo
        $sTitulo    = 'Ejemplo PDF Export en CodeIgniter'; 
        
        // generamos el pdf
        generar_pdf($arrHeading,$arrData,$sTitulo);
  }
}