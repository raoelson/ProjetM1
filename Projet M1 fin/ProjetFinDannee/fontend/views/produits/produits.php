<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 24/12/2015
 * Time: 13:42
 */
?>
<div class="shop-grid">
    <div class="container">
        <?php
        if (isset($produits->return)) {
        	$cat_ = "";
        	if(isset($cat)) $cat_ = $cat;
            if (sizeof($produits->return) == 1) {
                ?>
                <div class="col-md-4 grid-stn simpleCart_shelfItem">
                    <!-- normal -->
                    <div class="ih-item square effect3 bottom_to_top">
                        <div class="bottom-2-top">
                            <div class="img"><img src="<?php echo base_url($produits->return->imageId->path); ?>" alt="/"
                                                  class="img-responsive gri-wid"
                                                  style="width: 300px;height: 320px;">
                            </div>
                            <div class="info">
                                <div class="pull-left styl-hdn">
                                    <h3><?php echo $produits->return->nom; ?></h3>
                                </div>
                                <?php
                                if (isset($panier[$produits->return->id])) {
                                    ?>
                                    <div class="pull-right styl-price">
                                        <p><a href="#"><span
                                                    class="glyphicon glyphicon-shopping-cart grid-cart"
                                                    aria-hidden="true"></span> <span
                                                    class=" item_price"><?php echo $produits->return->prix; ?> Ar</span></a>
                                        </p>
                                    </div>
                                    <?php
                                } else {
                                    ?>
                                    <div class="pull-right styl-price">
                                        <p><a href="<?php echo site_url('panier/ajout/' . $produits->return->id).'/'.$cat_; ?>"
                                              class="item_add"><span
                                                    class="glyphicon glyphicon-shopping-cart grid-cart"
                                                    aria-hidden="true"></span> <span
                                                    class=" item_price"><?php echo prixHTTC($produits->return->prix, $produits->return->tvaId->multiplicate); ?> Ar</span></a>
                                        </p>
                                    </div>
                                <?php } ?>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <!-- end normal -->
                    <div class="quick-view">
                        <a href="<?php echo site_url('produits/detailsProduits/' . $produits->return->id.'/'.$produits->return->categorieId->id); ?>">Plus
                            d'infos</a>
                    </div>
                </div><?php
            } else {
                foreach ($produits->return as $produits_) {
                    ?>
                    <div class="col-md-4 grid-stn simpleCart_shelfItem">
                        <!-- normal -->
                        <div class="ih-item square effect3 bottom_to_top">
                            <div class="bottom-2-top">
                                <div class="img"><img src="<?php echo base_url($produits_->imageId->path); ?>" alt="/"
                                                      class="img-responsive gri-wid"
                                                      style="width: 150px;height: 120px;">
                                </div>
                                <div class="info">
                                    <div class="pull-left styl-hdn">
                                        <h3><?php echo $produits_->nom; ?></h3>
                                    </div>
                                    <?php
                                    if (isset($panier[$produits_->id])) {
                                        ?>
                                        <div class="pull-right styl-price">
                                            <p><a href="#"><span
                                                        class="glyphicon glyphicon-shopping-cart grid-cart"
                                                        aria-hidden="true"></span> <span
                                                        class=" item_price"><?php echo $produits_->prix; ?> Ar</span></a>
                                            </p>
                                        </div>
                                        <?php
                                    } else {
                                        ?>
                                        <div class="pull-right styl-price">
                                            <p><a href="<?php echo site_url('panier/ajout/' . $produits_->id.'/'.$cat_); ?>"
                                                  class="item_add"><span
                                                        class="glyphicon glyphicon-shopping-cart grid-cart"
                                                        aria-hidden="true"></span> <span
                                                        class=" item_price"><?php echo prixHTTC($produits_->prix, $produits_->tvaId->multiplicate); ?> Ar</span></a>
                                            </p>
                                        </div>
                                    <?php } ?>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end normal -->
                        <div class="quick-view">

                            <a href="<?php echo site_url('produits/detailsProduits/' . $produits_->id .'/' . $produits_->categorieId->id); ?>">Plus
                                d'infos</a>
                        </div>
                    </div>
                    <?php
                }
            }
            ?>
            <div class="clearfix"></div>
            <?php
        } else {
            //remove_session();
            ?>
            <h1>Aucun articles</h1>
            <?php
        } ?>
    </div>
</div>
