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
<?php
if (isset($commandes->return)) {
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
             <div class="panel panel-default" >
                        <div class="alert alert-success" id="alert" style="display: none;">
<button type="button" class="close" data-dismiss="alert">&times;</button>
<p></p>
</div>
                        <!-- Default panel contents -->
                        <div class="panel-heading">Listes des Produits commandées</div>

                        <!-- Table -->
                        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                            <thead>
                            <tr>
                                <th>id</th>  
                                <th>Nom</th>  
                                <th>Valider</th>                              
                                <th>Réferences</th>
                                <th>Date</th>  
                                <th>Listes des commandes</th>
                                <th>actions</th>                                
                            </tr>
                            </thead>
                            <tbody>
		                <?php
		                if(isset($commandes->return)){
		                if (sizeof($commandes->return) == 1) {
		                    ?> 
		                    <tr>
                                <td>
                                    <?php echo $commandes->return->id; ?>
                                </td>
                                <td>
                                    <?php echo $commandes->return->utilisateurId->username; ?>
                                </td>
                                <td>
                                    <?php 
                                       $active = ''; 
                                       if($commandes->return->valider !=0)  
                                       $active = 'checked';                                    
                                    ?>
                                    <form id="form1"
										action="<?php echo base_url(); ?>commandes/edit/<?php echo $commandes->return->id; ?>"
										method="get">
                                    <input <?php if(isset($active)) echo $active;?> data-toggle="toggle" type="checkbox" name="valider"
                                      onchange="this.form.submit()">
                                    </form>
                                </td>
                                <td>
                                    <?php echo  $commandes->return->reference; ?>                                    
                                </td>
                                <td>
                                    <?php echo  $commandes->return->dateCommandes; ?>                                    
                                </td>
                                <td>                             
                                     <a href='<?php echo base_url()."commandes/details/".$commandes->return->id; ?>' class='label label-info' ><i class="glyphicon glyphicon-search"></i>&nbsp;voir details</a>                                 
                                </td>
                                <td>
                                     <form id="form"
										action="<?php echo base_url(); ?>commandes/delete/<?php echo $commandes->return->id; ?>"
										method="get">
	                                    <div class="toggle-button"><input type="checkbox" checked="checked"/></div> 
	                                    <button type="button" class="btn btn-warning"  onclick="this.form.submit()" >Supprimer</button>                                  
	                                 </form>                                   
                                </td>
                            </tr>                                                                      
		                    <?php
		                } else if(sizeof($commandes->return)>1) {	?>
		                 
		                   <?php 	                
		                	foreach ($commandes->return as $com) {
		                		$active = "";
		                		if($com->valider !=0) $active = 'checked';
		                    ?>   		                    
		                    <tr>
                                    <td><?php echo($com->id); ?></td>
                                    <td><?php echo $com->utilisateurId->username; ?></td>                                    
                                    <td>
                                    <form id="form1"
										action="<?php echo base_url(); ?>commandes/edit/<?php echo $com->id; ?>"
										method="get">
                                    <input <?php if(isset($active)) echo $active;?> data-toggle="toggle" type="checkbox" name="valider"
                                      onchange="this.form.submit()">
                                    </form>
                                    </td>
                                    <td><?php echo $com->reference; ?></td>
                                    <td><?php echo $com->dateCommandes; ?></td>
                                    <td>
	                                    <a href='<?php echo site_url("commandes/details/$com->id"); ?>' class='label label-info' ><i class="glyphicon glyphicon-search"></i>&nbsp;voir details</a>                                    
	                                </td>
	                                <td>
	                                <form id="form"
										action="<?php echo base_url(); ?>commandes/delete/<?php echo $com->id; ?>"
										method="get">
	                                    <div class="toggle-button"><input type="checkbox" checked="checked"/></div> 
	                                    <button type="button" class="btn btn-warning"  onclick="this.form.submit()" >Supprimer</button>                                  
	                                 </form>  
	                                </td>
                                </tr>   
                                                                                                
		                    <?php
		                }		                
		                }
		                } ?>
                </tbody>
                        </table>
                    </div>                
            </div>
            <div class="clearfix"></div>

        </div>
    </div>
<!--    <label class="checkbox-inline"> <input checked data-toggle="toggle" type="checkbox"> First </label> <label class="checkbox-inline"> <input data-toggle="toggle" type="checkbox"> Second </label> <label class="checkbox-inline"> <input data-toggle="toggle" type="checkbox"> Third </label>-->
<?php } ?>
<script
    type="text/javascript"><?php echo "var session_flash='" . $this->session->flashdata('succes') . "'"; ?></script>
<script>
    $('document').ready(function () {
        var session = session_flash;
        if (session != "") {
            $("#alert p").html(session);
            $("#alert").show();
            $("#alert").focus();
            setTimeout(function () {
                $("#alert").hide();                               
            }, 2000);
        }        
    });
</script>

