<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 07/01/2016
 * Time: 20:14
 */
?>
<script src="<?php echo base_url('assets/fontend/js/jquery-1.7.2.min.js') ?>"></script>
<link href="<?php echo base_url('assets/fontend/css/bootstrap-toggle-buttons.css') ?>" rel="stylesheet" type="text/css">
<script src="<?php echo base_url('assets/fontend/js/tableExport.js') ?>"></script>
<script src="<?php echo base_url('assets/fontend/js/jquery.base64.js') ?>"></script>
<script src="<?php echo base_url('assets/fontend/js/jspdf/libs/sprintf.js') ?>"></script>
<script src="<?php echo base_url('assets/fontend/js/jspdf/jspdf.js') ?>"></script>
<script src="<?php echo base_url('assets/fontend/js/jspdf/libs/base64.js') ?>"></script>
<?php

    ?>
       <div class="alert alert-info" id="alert" style="display:none;margin-left: auto;margin-right: auto;width:680px;">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <p></p>
        </div>
    <div class="check" style="margin-right:auto;margin-left:auto;">
        <div class="container" >
        <div class="col-md-2 cart-total">
        </div>                  
            <div class="col-md-9 cart-items" >  
             <table border=0 >
                        <tr>
                        	<td>Nom : </td>
                        	<td>&nbsp;<?php echo $user;?></td>
                        </tr>
                        <tr>	
                        	<td>Adresse de livraison : </td>
                        	<td>&nbsp;<?php echo $adresse_livraison;?></td>
                        </tr>
                        <tr>
                        	<td>Adresse de facturation : </td>
                        	<td>&nbsp; <?php echo $adresse_facturation;?></td>
                        </tr>
             </table>  
             <table border=0 style="margin-rigth:auto;margin-left:auto;margin-top:-20px;">
                        <tr>
                        	<td>Date du commande : </td>
                        	<td>&nbsp;<?php echo $date;?></td>
                        </tr>
                      
             </table> 
             <br/>        
              
             <div class="panel panel-default" >
                                                                  
                        <!-- Default panel contents -->
                     
                        <div class="panel-heading">
                         <span>Détails du commande</span> 
                            <span class="span4 btn-toolbar pull-right" style="text-align: right;"> 
								<form method="post"  action="<?php echo base_url()."commandes/generar_pdf"?>" style="margin-rigth:50px;"> 
		                           <button ><i class="icon"></i>Export to PDF</button>
		                        </form>    
                        </span>
                                                                       
                        </div>                        
                        <!-- Table -->
                        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive" id="tableau">
                            <thead>
                            <tr>
                                <th >id</th>  
                                <th>Cat&eacute;gorie</th>                                                               
                                <th>Quantit&eacute;</th>
                                <th>prix</th>  
                                <th>TVA</th> 
                                <th>Prix HT</th>                                                               
                            </tr>
                            </thead>
                            <tbody>		
                              <?php
                               $total =0; 
                               $totalTTC =0; 
                            foreach ($json as $details) {
                            	$total+=($details['prix'] * $details['qte']);
                            	$tva=round((($details['prix'] * $details['qte']) / ($details['multiplicate']) - ($details['prix'] * $details['qte'])), 2);
                            	$totalTTC+=$tva; 
                                ?>
                                <tr>
                                    <td><?php echo $details['id']; ?></td>
                                    <td><?php echo $details['cat']; ?></td>
                                    <td><?php echo $details['qte']; ?></td>                                   
                                    <td><?php echo $details['prix']; ?></td>
                                     <td><?php echo $details['tva']; ?></td>
                                    <td><?php echo $details['prix'] * $details['qte']; ?></td>
                                </tr>
                                <?php
                            } ?>                		               		               
                			</tbody>                			
                			<tr>
                			<td colspan="5"><center>Total HT <br/> Total TTC</center></td>
                			<td><?php echo  $total;?> Ar<br/><?php echo  $totalTTC+ $total;?> Ar</td>
                			</tr>                			
                        </table>
                    </div>                
            </div>
            <div class="clearfix"></div>

        </div>
    </div>

<?php  ?>

