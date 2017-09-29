<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 24/12/2015
 * Time: 22:03
 */

function menu($cat)
{
	$menus = load()->__soapCall("getAllCategories", array());
	
	foreach ($menus->return as $menu):
	   $param = new stdClass();		   	   
	   $param->array = $menu->id;		     
	   $sous = load()->__soapCall("SousCategoriesArray", array($param));	   
	?>
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><?php echo $menu->nom; ?><b class="caret"></b></a>
		<ul class="dropdown-menu multi-column columns-3">
		<div class="row">
		<div class="col-sm-4 menu-img-pad">
        	<?php    
        	if(isset($sous->return)){     	          
        	 if(sizeof($sous->return) ==1){        	   	        	         
        	?>        	   
                   <ul class="multi-column-dropdown">
                       <li><a href="<?php echo site_url("categories/index/" . $sous->return->id); ?>"><?php echo $sous->return->nom; ?></a></li>                      
                    </ul>
                 
        	<?php }else {
        	     foreach ($sous->return as $souscat){
        		?>
        		   
                   <ul class="multi-column-dropdown">
                       <li><a href="<?php echo site_url("categories/index/" . $souscat->id); ?>"><?php echo $souscat->nom; ?></a></li>                       
                    </ul>
                    <li class="divider"></li>  	
        	<?php }}
        	     }?>
        	</div>
        	<div class="col-sm-4 menu-img-pad">
					<a href="#"><img src="<?php echo base_url($menu->imageId->path); ?>" alt="/" class="img-rsponsive men-img-wid" /></a>
				  </div>
        </div>	
         </ul>
	</li>    
	<?php
	endforeach;
}
function remove_session(){
	$session = &get_instance();
	$session->session->unset_userdata("panier");
}
function load()
{
	$resultat = new SoapClient("http://djazzjah:8080/BackEndWs/CommandesWs?wsdl");
//	var_dump($resultat);
//	die();
	return $resultat;
}

function nombres_panier()
{
	$session = &get_instance();
	$session_ = $session->session->userdata("panier");
	if (!$session_) {
		?>
<p><a href="#" class="simpleCart_empty">Aucun article dans votre panier</a></p>
		<?php } else {
			$nbr = count($session_);
			if ($nbr == 1) {
				?>
<p><a href="<?php echo site_url("panier/panier_view") ?>"
	class="simpleCart_empty">1 article dans votre panier</a></p>
				<?php } else {
					?>
<p><a href="<?php echo site_url("panier/panier_view") ?>"
	class="simpleCart_empty"><?php echo $nbr; ?> articles dans votre panier</a></p>
					<?php }
		}
}

function nombres_panier_()
{
	$session = &get_instance();
	$session_ = $session->session->userdata("panier");
	$session_nbr = 0;
	$nbr = count($session_);
	if ($nbr == 1) {
		$session_nbr = 1;
	} else if ($nbr != 0 && $nbr != 1) {
		$session_nbr = $nbr;
	}
	return $session_nbr;
}

function prix_panier()
{
	$param_ = new stdClass();
	$session = &get_instance();
	$session_ = $session->session->userdata("panier");
	$data = array();
	$data__['total'] = 0;
	if ($session_ != "") {
		$param_->array = array_keys($session_);
		$produits_panier = load()->__soapCall("ProduitsArray", array($param_));
		if(isset($produits_panier->return)){
			$nbr = count($session_);
			if ($nbr == 1) {
				$qte_montant = ($produits_panier->return->prix * $session_[$produits_panier->return->id]);
				$data__['total'] += $qte_montant;
				$data['tva'] = $produits_panier->return->tvaId->nom;
				$data['tva_montant'] = round((($qte_montant) / ($produits_panier->return->tvaId->multiplicate) - ($qte_montant)), 2);
				$data['totalttc'] = $data__['total'] + $data['tva_montant'];
				?>
<div class="price-details">
<h3 id="titre_">Prix ​​Détails</h3>
<span>Total HT</span> <span class="total1"><?php echo $data__['total']; ?></span>
<span><?php echo $data['tva']; ?> </span> <span class="total1"><?php echo $data['tva_montant']; ?></span>

<div class="clearfix"></div>
</div>
<hr class="featurette-divider">
<ul class="total_price">
	<li class="last_price">
	<h4>TOTAL TTC</h4>
	</li>
	<li class="last_price"><span><?php echo $data['totalttc']; ?></span></li>
	<div class="clearfix"></div>
</ul>
				<?php
			} else if ($nbr != 0 && $nbr != 1) {

				$trouve = 0;
				$data_['tva_montant'] = 0;
				$calculTTC = 0;
				foreach ($produits_panier->return as $produits) {
					$data__['total'] += ($produits->prix * $session_[$produits->id]);
					$data_['tva'] = $produits->tvaId->nom;
					$data_['tva_montant'] = round((($produits->prix * $session_[$produits->id]) / ($produits->tvaId->multiplicate) - ($produits->prix * $session_[$produits->id])), 2);
					$calculTTC += $data_['tva_montant'];
					array_push($data, $data_);
				}

				?>
<div class="price-details">
<h3 id="titre_">Prix ​​Détails</h3>
<span>Total HT</span> <span class="total1"><?php echo $data__['total']; ?></span>
				<?php

				foreach ($data as $value) {

					?> <span><?php echo $value['tva']; ?></span> <span class="total1"><?php echo($value['tva_montant']); ?></span>
					<?php
				}
				?>
<div class="clearfix"></div>
</div>
<hr class="featurette-divider">
<ul class="total_price">
	<li class="last_price">
	<h4>TOTAL TTC</h4>
	</li>
	<li class="last_price"><span><?php echo $calculTTC + $data__['total']; ?></span></li>
	<div class="clearfix"></div>
</ul>
				<?php
			}
		}else{
			remove_session();
		}
	}
}

function prixHTTC($prixHT, $prix)
{
	return round((($prixHT) + ($prixHT / $prix) - $prixHT), 2);
}

function user_session()
{
	$session = &get_instance();
	$session_ = $session->session->userdata("user");	
	if ($session_ != "") {
		$data['titre'] = "Déconnexion";
		$data['href'] = base_url() . "utilisateurs/deconnexion";
		$data['profil'] = $session_['login'];
		$data['href_profil'] = base_url() . "utilisateurs/user_view/" . $session_['id'];
		$param = new stdClass();
		$param->user = 	$session_['id'];
		$rep = load()->__soapCall("RecuperationCommandes", array($param));		
		if(isset($rep->return)){
			if(sizeof($rep->return)!=0){
			   $data['titre_commandes'] = "Facturation";
			   $data['href_commandes'] = base_url() . "commandes/index/" . $session_['id'];	
			}
		}	
	} else {		
		$data['titre'] = "Se connecter";
		$data['href'] = base_url() . "utilisateurs";
		$data['profil'] = "S'inscrire";
		$data['href_profil'] = base_url() . "utilisateurs/signup";		
	}
	
	return ($data);
}

function is_logged_in()
{
	header("cache-Control: no-store, no-cache, must-revalidate");
	header("cache-Control: post-check=0, pre-check=0", false);
	header("Pragma: no-cache");
	$session = &get_instance();
	$user = $session->session->userdata("user");
	$retour = 0;
	if ($user != "") {
		$retour = 1;
	}
	return $retour;
}

function logout()
{
	$session = &get_instance();
	$session->session->unset_userdata("user");
}

function adresse_livraison()
{
	$option = array('trace' => 1);
	$session = &get_instance();
	$session_current = $session->session->userdata("user");
	$param_ = new stdClass();
	$param_->id = $session_current['id'];
	$adresse = load()->__soapCall("AdresseLivraison", array($param_), $option);

	if (isset($adresse->return)) {
		?>
<div class="product_right">
<h4 class="m_2"><span class="glyphicon glyphicon-minus"
	aria-hidden="true"></span>Adresse de livraison</h4>
<div class="tab1">
<ul class="place">
<?php
if (sizeof($adresse->return) == 1) {
	?>
	<li class="sort"><input type="radio" name="adresse" checked="true"
		id="adresse_active" value="<?php echo $adresse->return->id;?>"><?php echo $adresse->return->adresse;
		echo ",";
		echo $adresse->return->cp;
		echo ",";
		echo $adresse->return->ville . "-" . $adresse->return->pays; ?>&nbsp;&nbsp;
	<a
		href="<?php echo site_url('validation/supprimer/' . $adresse->return->id); ?>"
		title="supprimer"><span class="glyphicon glyphicon-remove"
		aria-hidden="true"></span> </a></li>
		<?php
} else {
	foreach ($adresse->return as $value => $adresse_) {
		?>
	<li class="sort"><input type="radio" name="adresse" checked="true"
		id="adresse_active" value="<?php echo $adresse_->id;?>"><?php echo $adresse_->adresse;
		echo ",";
		echo $adresse_->cp;
		echo ",";
		echo $adresse_->ville . "-" . $adresse_->pays; ?> &nbsp;&nbsp; <a
		href="<?php echo site_url('validation/supprimer/' . $adresse_->id); ?>"
		title="supprimer"><span class="glyphicon glyphicon-remove"
		aria-hidden="true"></span> </a></li>
		<?php
	}
}

?>
	<div class="clearfix"></div>
</ul>
</div>
<?php
	}
}

function adresse_facturation()
{
	$session = &get_instance();
	$session_current = $session->session->userdata("user");
	$param_ = new stdClass();
	$param_->id = $session_current['id'];
	$adresse = load()->__soapCall("AdresseLivraison", array($param_));
	if (isset($adresse->return)) {
		?>
<div class="product_right">
<h4 class="m_2"><span class="glyphicon glyphicon-minus"
	aria-hidden="true"></span>Adresse de Facturation</h4>

<div class="tab1">
<ul class="place">
<?php
if (sizeof($adresse->return) == 1) {
	?>
	<li class="sort"><input type="radio" name="adresse_livraison"
		checked="true" value="<?php echo $adresse->return->id ?>"
		id="adresse_livraison_active"><?php echo $adresse->return->adresse;
		echo ",";
		echo $adresse->return->cp;
		echo ",";
		echo $adresse->return->ville . "-" . $adresse->return->pays; ?></li>
		<?php
} else {
	foreach ($adresse->return as $value => $adresse_) {
		?>
	<li class="sort"><input type="radio" name="adresse_livraison"
		checked="true" id="adresse_livraison_active"
		value="<?php echo $adresse_->id ?>"><?php echo $adresse_->adresse;
		echo ",";
		echo $adresse_->cp;
		echo ",";
		echo $adresse_->ville . "-" . $adresse_->pays; ?></li>
		<?php
	}
}

?>
	<div class="clearfix"></div>
</ul>
</div>
</section> <!----></div>
<div class="grid-addon"><section class="sky-form">
<div class="product_right">
<button class="btn item_add"
	style="width: 100%; background: #100b0b; color: #fff; font-family: 'Pathway Gothic One'; font-size: 18px; border: none; border-radius: 0;"
	role="button" id="valider">Valider mon adresse de livraison</button>
</section> <!----></div>
<?php
	}
}
function getReference(){
	$reponse = load()->__soapCall("commandesValider", array());
	if(isset($reponse->return)){
		if(sizeof($reponse->return) ==1){
			return (count($reponse->return)+1);
		}else{
			return (count($reponse->return)+1);
		}
	}else{
		return 1;
	}

}
function validation_requete(){
	$session_ = &get_instance();
	$session = $session_->session->userdata("adresse");
	$param_ = new stdClass();
	$param_adresse = new stdClass();
	$param_livraison = new stdClass();
	$param_adresse->id =$session['adresse'];
	$param_livraison->id =$session['livraison'];
	$param_->array = array_keys($session_->session->userdata('panier'));
	$data['produits_panier'] = load()->__soapCall("ProduitsArray", array($param_));
	$data['adresse'] = load()->__soapCall("SearchAdresseLivraison", array($param_adresse));
	$data['livraison'] = load()->__soapCall("SearchAdresseLivraison", array($param_livraison));
	$data['panier'] = $session_->session->userdata('panier');
	return $data;
}
function test_session(){
	$session = &get_instance();
	$session_ = $session->session->userdata("panier");	
	if($session_!=false){
		return 1;
	}else{
		return 0;
	}
}



