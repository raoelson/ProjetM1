<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 30/12/2015
 * Time: 10:59
 */
?>
<div class="container">
<ol class="breadcrumb">
	<li><a href="<?php echo site_url("produits/") ?>">Accueil</a></li>
	<li><a href="products.hml">Produits</a></li>
	<li class="active">Panier</li>
</ol>
</div>
<div class="check">
<div class="container">
<div class="col-md-3 cart-total"><a class="continue"
	href="<?php echo site_url("produits/") ?>">Continuer mes achats</a> <?php if(nombres_panier_() !=0){?>
<?php prix_panier();?>
<div class="clearfix"></div>
<a class="order" href="<?php echo site_url("validation/") ?> "
	onclick="<?php 
             $session = &get_instance();
             $session_ = $session->session->userdata("url");
	            if (!$session) {
	            $this->session->set_userdata('url', array());
	        }
	        $this->session->set_userdata('url', 'validation');
	        ?>">Valider mon panier</a> <?php }?></div>

<div class="col-md-9 cart-items">

<div class="alert alert-success" id="alert" style="display: none;">
<button type="button" class="close" data-dismiss="alert">&times;</button>
<p></p>
</div>

<h1><?php nombres_panier(); ?></h1>
	        <?php
	        if (nombres_panier_() == 0) {
	        	?>
<div class="cart-header">
<div class="clearfix"></div>
</div>

	        	<?php
	        } elseif (nombres_panier_() == 1) {
	        	?>
<div class="cart-header">
<div class="close"><a
	href="<?php echo site_url('panier/supprimer/' . $produits_panier->return->id) ?>"
	title="supprimer"><span class="glyphicon glyphicon-remove"
	aria-hidden="true"></span></a></div>
<div class="cart-sec simpleCart_shelfItem">
<div class="cart-item cyc"><img
	src="<?php echo base_url($produits_panier->return->imageId->path); ?> "
	class="img-responsive" alt=""
	title="<?php echo($produits_panier->return->nom); ?>"></div>
<div class="cart-item-info">
<form
	action="<?php echo base_url(); ?>panier/ajout/<?php echo $produits_panier->return->id; ?>/panier"
	method="get">	
<ul class="qty">
	<li>	
	<p>Qty : <select name="qte" class="span1" onChange="this.form.submit()">
	<?php
	for ($i = 1; $i <= 10; $i++) {
		?>
		<option value="<?php echo $i; ?>"
		<?php if ($i == $panier[$produits_panier->return->id]) { ?>
			selected="selected" <?php } ?>><?php echo $i; ?></option>
			<?php
	} ?>
	</select>
	
	</li>
	<li>
	<p>Prix: <?php echo $produits_panier->return->prix; ?></p>
	</li>
</ul>
</form>
<div class="delivery">
<p>Prix Hors Taxes : <?php echo $produits_panier->return->prix * $panier[$produits_panier->return->id] ?></p>
<span>Delivered in 2-3 bussiness days</span>

<div class="clearfix"></div>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>

	<?php
	        } else {

	        	foreach ($produits_panier->return as $produits) {
	        		?>
<div class="cart-header">
<div class="close"><a
	href="<?php echo site_url('panier/supprimer/' . $produits->id) ?>"><span
	class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></div>
<div class="cart-sec simpleCart_shelfItem">
<div class="cart-item cyc"><img
	src="<?php echo base_url($produits->imageId->path); ?>"
	class="img-responsive"
	alt="<?php echo base_url($produits->imageId->path); ?>"
	title="<?php echo ($produits->nom); ?>"></div>
<div class="cart-item-info">
<form
	action="<?php echo base_url(); ?>panier/ajout/<?php echo $produits->id; ?>/panier"
	method="get">
<ul class="qty">
	<li>
	<p>Qty : <select name="qte" class="span1" onChange="this.form.submit()">
	<?php
	for ($i = 1; $i <= 10; $i++) {
		?>
		<option value="<?php echo $i; ?>"
		<?php if ($i == $panier[$produits->id]) { ?> selected="selected"
		<?php } ?>><?php echo $i; ?></option>
		<?php
	} ?>
	</select>
	
	</li>
	<li>
	<p>Prix: <?php echo $produits->prix; ?></p>
	</li>
</ul>
</form>
<div class="delivery">
<p>Prix Hors Taxes : <?php echo $produits->prix * $panier[$produits->id] ?></p>
<span>Delivered in 2-3 bussiness days</span>

<div class="clearfix"></div>
</div>
</div>
<div class="clearfix"></div>
</div>
</div>
	<?php
	        	}
	        } ?></div>
<div class="clearfix"></div>
</div>
</div>
<script type="text/javascript"><?php echo "var session_flash='" . $this->session->flashdata('success') . "'"; ?></script>
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
