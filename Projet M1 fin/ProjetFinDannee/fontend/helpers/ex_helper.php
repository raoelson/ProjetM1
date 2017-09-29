<?php  if ( ! defined('BASEPATH')) exit('No direct script access allowed');

if ( ! function_exists('generar_pdf'))
{
   function generar_pdf($arrHeading,$arrData,$info,$sTitulo){
       
        //  validamos los priemros dos parametros
        if(!is_array($arrHeading) or !is_array($arrData)){
         return 0;
        }
        // seteamos el titulo, si es necesario
        $sTitulo = empty($sTitulo) ? 'NO SE HA DEFINIDO EL TITULO..' : $sTitulo;
       
        //instanciamos al objeto codeigniter
        $CI =& get_instance();
        $CI->load->library('table');

        
 $tmpl = array('table_open' => '<table border="0" cellpadding="2" cellspacing="1">');
 $CI->table->set_template($tmpl); 
 $CI->table->set_heading($arrHeading);

 // iniciamos el HTML que enviaremos para generar el PDF
 $html1 = "<table border=0 >
                        <tr>
                        	<td>Nom : </td>
                        	<td>&nbsp;$info[user]</td>
                        </tr>
                        <tr>	
                        	<td>Adresse de livraison : </td>
                        	<td>&nbsp;$info[livraison]</td>
                        </tr>
                        <tr>
                        	<td>Adresse de facturation : </td>
                        	<td>&nbsp; $info[facturation]</td>
                        </tr>
             </table>  
             <table border=0>
                        <tr>
                        	<td>Date du commande : </td>
                        	<td>&nbsp;$info[date]</td>
                        </tr>
                      
             </table>
        ";
        $html1 .= '</body></html>';        
        
     $tmpl = array('table_open' => '<table border="0" cellpadding="2" cellspacing="1">');
	 $CI->table->set_template($tmpl); 
	 $CI->table->set_heading($arrHeading);
     $htm3 = "<table border=0 >
                        <tr>
                        	<td>Total HT  </td>
                        	<td>&nbsp;$info[totalHT]</td>
                        </tr>
                        <tr>	
                        	<td>Total TTC : </td>
                        	<td>&nbsp;$info[totalTTC]</td>
                        </tr>                        
             </table> ";
      $htm3 .= '</body></html>'; 
        
        
        
        
        
  // configuraciones de la tabla
 $tmpl = array('table_open' => '<table border="0" cellpadding="2" cellspacing="1">');
 $CI->table->set_template($tmpl); 
 $CI->table->set_heading($arrHeading);

 // iniciamos el HTML que enviaremos para generar el PDF
 $html = "<html><head>
        <style>
            h1{
                font-family: times new roman;
                font-size: 14px;
                text-align:center;
            }
            table {
                color: #fff;
  font-weight: bold;
                font-family: Arial Black;
                font-size: 12px;
                background-color: #B10020;
                border: red 0px solid;
            }
            table td {
  font-weight: none;
                color: #000;
                background-color: #FAFAFA;
                font-size: 12px;
                font-family: times new roman;
            }
        </style>
        </head><body><h1>$sTitulo</h1>";

 $html .= $CI->table->generate($arrData); 
        $html .= '</body></html>';

 // para evitar errores, limpiamos, 
 // deshabilitamos los búferes de salida
 if(ob_get_contents()){
  ob_end_clean();
 }

 // incluimos el plugin
        
 require_once(APPPATH.'helpers/tcpdf/tcpdf.php');
 
 // estas son las configuraciones para la generacion del PDF
 // los detalles los encuentras en la pagina oficial
 $pdf = new TCPDF(PDF_PAGE_ORIENTATION,PDF_UNIT,PDF_PAGE_FORMAT,true,'UTF-8',false);
 $pdf->SetCreator("Shopping by L\'AMI INFO");
 $pdf->SetAuthor('Djazz Jah');
 $pdf->SetTitle($sTitulo);
 $pdf->SetHeaderData(PDF_HEADER_LOGO, PDF_HEADER_LOGO_WIDTH, "Shopping by L'AMI INFO");
 $pdf->setHeaderFont(Array(PDF_FONT_NAME_MAIN, '', PDF_FONT_SIZE_MAIN));
 $pdf->setFooterFont(Array(PDF_FONT_NAME_DATA, '', PDF_FONT_SIZE_DATA));
 $pdf->SetDefaultMonospacedFont(PDF_FONT_MONOSPACED);
 $pdf->SetMargins(PDF_MARGIN_LEFT, PDF_MARGIN_TOP, PDF_MARGIN_RIGHT);
 $pdf->SetHeaderMargin(PDF_MARGIN_HEADER);
 $pdf->SetFooterMargin(PDF_MARGIN_FOOTER);
 $pdf->SetAutoPageBreak(TRUE, PDF_MARGIN_BOTTOM);
 $pdf->setImageScale(PDF_IMAGE_SCALE_RATIO);
 //$pdf->setLanguageArray($l);
 $pdf->setFontSubsetting(true);
 $pdf->SetFont('times', '', 12, '', true);
 $pdf->AddPage();
 $pdf->writeHTML($html1, true, false, true, false, '');
 $pdf->writeHTML($html, true, false, true, false, '');
 $pdf->writeHTML($htm3, true, false, true, false, '');
 $pdf->Output('','D');
  }  
}

# END Mod Ppal Class
/* End of file mod_ppal_helper.php */
/* Location: ./system/libraries/Mod_ppal.php */