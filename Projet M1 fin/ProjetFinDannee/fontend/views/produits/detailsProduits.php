<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 24/12/2015
 * Time: 21:48
 */
?>

<div class="head-bread">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="<?php echo site_url("produits/") ?>">Accueil</a></li>
            <li>
                <a href="<?php echo site_url("categories/index/" . $details->return->categorieId->id); ?>"><?php echo $details->return->categorieId->nom; ?></a>
            </li>
            <li class="active"><?php echo $details->return->nom; ?></li>

        </ol>
    </div>
</div>
<div class="showcase-grid">
    <div class="container">
        <div class="col-md-8 showcase">
            <div class="flexslider">
                <ul class="slides">
                    <li data-thumb="<?php echo base_url($details->return->imageId->path); ?>">
                        <div class="thumb-image"><img src="<?php echo base_url($details->return->imageId->path); ?>"
                                                      data-imagezoom="true" class="img-responsive"></div>
                    </li>
                    <li data-thumb="<?php echo base_url($details->return->imageId->path); ?>">
                        <div class="thumb-image"><img src="<?php echo base_url($details->return->imageId->path); ?>"
                                                      data-imagezoom="true" class="img-responsive"></div>
                    </li>
                    <li data-thumb="<?php echo base_url($details->return->imageId->path); ?>">
                        <div class="thumb-image"><img src="<?php echo base_url($details->return->imageId->path); ?>"
                                                      data-imagezoom="true" class="img-responsive"></div>
                    </li>
                    <li data-thumb="<?php echo base_url($details->return->imageId->path); ?>">
                        <div class="thumb-image"><img src="<?php echo base_url($details->return->imageId->path); ?>"
                                                      data-imagezoom="true" class="img-responsive"></div>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="col-md-4 showcase">
            <div class="showcase-rt-top">
                <div class="pull-left shoe-name">
                    <h3><?php echo $details->return->nom; ?></h3>

                    <p><?php echo $details->return->categorieId->nom; ?></p>
                    <h4>Ar
                        &nbsp;<?php echo prixHTTC($details->return->prix, $details->return->tvaId->multiplicate); ?></h4>
                </div>
                <div class="pull-left rating-stars">
                    <ul>
                        <li><a href="#" class="active"><span class="glyphicon glyphicon-star star-stn"
                                                             aria-hidden="true"></span></a></li>
                        <li><a href="#" class="active"><span class="glyphicon glyphicon-star star-stn"
                                                             aria-hidden="true"></span></a></li>
                        <li><a href="#" class="active"><span class="glyphicon glyphicon-star star-stn"
                                                             aria-hidden="true"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a>
                        </li>
                        <li><a href="#"><span class="glyphicon glyphicon-star star-stn" aria-hidden="true"></span></a>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
            <hr class="featurette-divider">
            <div class="shocase-rt-bot">

                <?php if (isset($panier[$details->return->id])) {
                    ?>
                    <ul>
                        <li class="ad-2-crt simpleCart_shelfItem">
                            <a class="btn " href="<?php echo site_url("panier/panier_view") ?>" role="button">Le produit
                                est déjà dans votre panier</a>
                            <!--<a class="btn" href="#" role="button">Buy Now</a>-->
                        </li>
                    </ul>
                    <?php
                } else { ?>
                    <form action="<?php echo base_url(); ?>panier/ajout/<?php echo $details->return->id; ?>/<?php echo $details->return->categorieId->id; ?>/details"
                          method="get">
                        <div class="float-qty-chart">
                            <ul>
                                <li class="qty">
                                    <h4>QTY</h4>
                                    <select class="form-control qnty-chrt" name="qte">
                                        <?php
                                        for ($i = 1; $i <= 10; $i++) {
                                            ?>
                                            <option value="<?php echo $i; ?>"><?php echo $i; ?></option>
                                            <?php
                                        } ?>
                                    </select>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <ul>
                            <li class="ad-2-crt simpleCart_shelfItem">
                                <button class="btn item_add" style=" width: 100%;
                                    background: #100b0b;
                                    color: #fff;
                                    font-family: 'Pathway Gothic One';
                                    font-size: 18px;
                                    border: none;
                                    border-radius: 0;"
                                        role="button">Ajouter au panier
                                </button>
                                <!--<a class="btn" href="#" role="button">Buy Now</a>-->
                            </li>
                        </ul>
                    </form>
                <?php } ?>


            </div>
            <div class="showcase-last">
                <h3>product details</h3>
                <ul>
                    <li><?php echo $details->return->description; ?></li>

                </ul>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<div class="specifications">
    <div class="container">
        <div class="detai-tabs">
            <!-- Nav tabs -->
            <ul class="nav nav-pills tab-nike" role="tablist">
                <li role="presentation" class="active"><a href="#profile" aria-controls="profile" role="tab"
                                                          data-toggle="tab">Description</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <p><?php echo $details->return->description; ?></p>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="you-might-like">
    <div class="container">
        <h3 class="you-might">Produits Associés</h3>
        <?php
        if (isset($produits_compare->return)) {
            if (sizeof($produits_compare->return) == 1) {
                ?>
                <div class="col-md-4 grid-stn simpleCart_shelfItem">
                    <!-- normal -->
                    <div class="ih-item square effect3 bottom_to_top">
                        <div class="bottom-2-top">
                            <div class="img"><img style="width: 300px;height: 320px;"
                                                  src="<?php echo base_url($produits_compare->return->imageId->path); ?>"
                                                  alt="/"
                                                  class="img-responsive gri-wid"></div>
                            <div class="info">
                                <div class="pull-left styl-hdn">
                                    <h3><?php echo $produits_compare->return->nom; ?></h3>
                                </div>
                                <?php
                                if (isset($panier[$produits_compare->return->id])) {
                                    ?>
                                    <div class="pull-right styl-price">
                                        <p><a href="#"><span
                                                    class="glyphicon glyphicon-shopping-cart grid-cart"
                                                    aria-hidden="true"></span> <span
                                                    class=" item_price"><?php echo prixHTTC($produits_compare->return->prix, $produits_compare->return->tvaId->multiplicate); ?> Ar</span></a>
                                        </p>
                                    </div>
                                    <?php
                                } else {
                                    ?>
                                    <div class="pull-right styl-price">
                                        <p><a href="<?php echo site_url('panier/ajout/' . $produits_compare->return->id); ?>"
                                              class="item_add"><span
                                                    class="glyphicon glyphicon-shopping-cart grid-cart"
                                                    aria-hidden="true"></span> <span
                                                    class=" item_price"><?php echo $produits_compare->return->prix; ?> Ar</span></a>
                                        </p>
                                    </div>
                                <?php } ?>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <!-- end normal -->
                    <div class="quick-view">
                        <div class="quick-view">
                            <a href="<?php echo site_url('produits/detailsProduits/' . $produits_compare->return->id.'/'. $produits_compare->return->categorieId->id); ?>">Plus
                                d'infos</a>
                        </div>
                    </div>
                </div>
                <?php
            } else {
                foreach ($produits_compare->return as $produits_) {
                    ?>
                    <div class="col-md-4 grid-stn simpleCart_shelfItem">
                        <!-- normal -->
                        <div class="ih-item square effect3 bottom_to_top">
                            <div class="bottom-2-top">
                                <div class="img"><img style="width: 300px;height: 320px;"
                                                      src="<?php echo base_url($produits_->imageId->path); ?>" alt="/"
                                                      class="img-responsive gri-wid"></div>
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
                                                        class=" item_price"><?php echo prixHTTC($produits_->prix, $produits_->tvaId->multiplicate); ?> Ar</span></a>
                                            </p>
                                        </div>
                                        <?php
                                    } else {
                                        ?>
                                        <div class="pull-right styl-price">
                                            <p><a href="<?php echo site_url('panier/ajout/' . $produits_->id); ?>"
                                                  class="item_add"><span
                                                        class="glyphicon glyphicon-shopping-cart grid-cart"
                                                        aria-hidden="true"></span> <span
                                                        class=" item_price"><?php echo $produits_->prix; ?> Ar</span></a>
                                            </p>
                                        </div>
                                    <?php } ?>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                        <!-- end normal -->
                        <div class="quick-view">
                            <div class="quick-view">
                                <a href="<?php echo site_url('produits/detailsProduits/' . $produits_->id.'/'. $produits_->categorieId->id); ?>">Plus
                                    d'infos</a>
                            </div>
                        </div>
                    </div>
                    <?php
                }
            }
        }else{
            remove_session();
        }
        ?>
    </div>
    <div class="clearfix"></div>
</div>
</div>
