<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 07/01/2016
 * Time: 20:14
 */
?>
<?php
if (isset($produits_panier->return)) {
    ?>
       <div class="alert alert-info" id="alert" style="display:none;margin-left: auto;margin-right: auto;width:680px;">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <p></p>
        </div>
    <div class="check">
        <div class="container">
            <div class="col-md-3 cart-total">
                <a class="continue" href="<?php echo site_url("validation/") ?>">Retour</a>

                <div class="price-details">
                    <?php
                    if (isset($adresse->return)) {
                        ?>
                        <h3>Adresse de livraison</h3>
                        <span style="width: 350px;">
                        <?php echo $adresse->return->nom;
                        echo " ";
                        echo $adresse->return->prenom ?>
                        <br/>
                        <?php echo $adresse->return->adresse;
                        echo "-";
                        echo $adresse->return->cp;
                        echo "-";
                        echo $adresse->return->ville; ?>
                        <?php echo $adresse->return->pays; ?>
                         </span>
                        <div class="clearfix"></div><br/><br/>
                    <?php } ?>
                    <?php
                    if (isset($livraison->return)) {
                    ?>
                        <h3>Adresse de facturation</h3>
                        <span style="width: 350px;">
                        <?php echo $livraison->return->nom;
                        echo " ";
                        echo $livraison->return->prenom ?>
                            <br/>
                            <?php echo $livraison->return->adresse;
                            echo "-";
                            echo $livraison->return->cp;
                            echo "-";
                            echo $livraison->return->ville; ?>
                            <?php echo $livraison->return->pays; ?>
                         </span>
                    <?php } ?>
                </div>

                <div class="clearfix"></div>
                <a class="order" href="#" id="payer" onclick='payer_commande()'>Payer</a>
            </div>

            <div class="col-md-9 cart-items">
                <?php
                if (sizeof($produits_panier->return) == 1) {
                    ?>
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Valider mon panier</div>

                        <!-- Table -->
                        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                            <thead>
                            <tr>
                                <th>Réferences</th>
                                <th>Quantité</th>
                                <th>Prix unitaire</th>
                                <th>Total HT</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <?php echo $produits_panier->return->nom; ?>
                                </td>
                                <td>
                                    <?php echo $panier[$produits_panier->return->id]; ?>
                                </td>
                                <td>
                                    <?php echo $produits_panier->return->prix; ?>
                                </td>
                                <td>
                                    <?php echo($produits_panier->return->prix * $panier[$produits_panier->return->id]); ?>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>


                    <?php
                } else {
                    ?>
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">Valider mon panier</div>

                        <!-- Table -->
                        <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
                            <thead>
                            <tr>
                                <th>Réferences</th>
                                <th>Quantité</th>
                                <th>Prix unitaire</th>
                                <th>Total HT</th>
                            </tr>
                            </thead>
                            <tbody>
                            <?php
                            foreach ($produits_panier->return as $produits) {
                                ?>
                                <tr>
                                    <td><?php echo($produits->nom); ?></td>
                                    <td><?php echo $panier[$produits->id]; ?></td>
                                    <td><?php echo $produits->prix; ?></td>
                                    <td><?php echo($panier[$produits->id] * $produits->prix); ?></td>
                                </tr>
                                <?php
                            } ?>
                            </tbody>
                        </table>
                    </div>

                    <?php
                } ?>
                <div style="width: 200px; margin-left: auto;margin-right: auto;">
                    <?php prix_panier(); ?>
                </div>
            </div>
            <div class="clearfix"></div>

        </div>
    </div>

<?php } ?>
<script>
    $('document').ready(function () {
        $("#titre_").hide(true);             
    });
    payer_commande = function(){
    	  $.getJSON(BASE_URL + "Validation/commandes_valider", {
        }, initCallBack);
   };
   initCallBack = function(json){
	   if (json.message != "") {
           $("#alert p").html(json.message);
           $("#alert").show();
           $("#alert").focus();
           setTimeout(function () {
               $("#alert").hide();
               $('#header').load();
           }, 2000);
       }
   };
</script>
