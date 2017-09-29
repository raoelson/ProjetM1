<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Index_m extends CI_Model {
    
  public function __construct(){
        parent::__construct();   
  }
  
  function get_data_pdf(){

        $result = $this->db
    ->query('SELECT idtabla1, campo1 FROM tabla1');

 // recuerda que puiedes hacer cualquier filtro usando SQL
 // como limitar el numero de registros, mostrar todo en mayúscula, etc..

        $arrDatos=array();
        foreach ($result->result_array() as $row){
            $arrDatos[] = array(
                htmlspecialchars($row['idtabla1'],ENT_QUOTES),
                htmlspecialchars($row['campo1'],ENT_QUOTES),
            ); 
        }
        $result->free_result();
        $this->db->close();

        return($arrDatos);
  }
}