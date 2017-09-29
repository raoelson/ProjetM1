<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 26/12/2015
 * Time: 10:53
 */
?>
<div class="shop-grid">
    <div class="container">
        <?php
        if(isset($categories->return)){
            if(sizeof($categories->return) ==1){
               ?>
                <div class="col-md-4 grid-stn simpleCart_shelfItem">
                    <!-- normal -->
                    <div class="ih-item square effect3 bottom_to_top">
                        <div class="bottom-2-top">
                            <div class="img"><img src="<?php echo base_url($categories->return->imageId->path);?>" alt="/" class="img-responsive gri-wid" style="width: 300px;height: 320px;"></div>
                            <div class="info">
                                <div class="pull-left styl-hdn">
                                    <h3><?php echo $categories->return->nom;?></h3>
                                </div>
                                <div class="pull-right styl-price">
                                    <p><a href="#" class="item_add"><span class="glyphicon glyphicon-shopping-cart grid-cart"
                                                                          aria-hidden="true"></span> <span class=" item_price"></span></a>
                                    </p>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <!-- end normal -->
                    <div class="quick-view">
                        <a href="<?php echo site_url('produits/detailsProduits/'.$categories->return->id.'/'.$categories->return->nom);?>">Plus d'infos</a>
                    </div>
                </div>
                <?php
            }
        foreach($categories->return as $categories_){
            ?>
            <div class="col-md-4 grid-stn simpleCart_shelfItem">
                <!-- normal -->
                <div class="ih-item square effect3 bottom_to_top">
                    <div class="bottom-2-top">
                        <div class="img"><img src="<?php echo base_url($categories_->imageId->path);?>" alt="/" class="img-responsive gri-wid" style="width: 300px;height: 320px;"></div>
                        <div class="info">
                            <div class="pull-left styl-hdn">
                                <h3><?php echo $categories_->nom;?></h3>
                            </div>
                            <div class="pull-right styl-price">
                                <p><a href="#" class="item_add"><span class="glyphicon glyphicon-shopping-cart grid-cart"
                                                                      aria-hidden="true"></span> <span class=" item_price"></span></a>
                                </p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
                <!-- end normal -->
                <div class="quick-view">
                    <a href="<?php echo site_url('produits/detailsProduits/'.$categories_->id.'/'.$categories_->nom);?>">Plus d'infos</a>
                </div>
            </div>
            <?php
        }
        }else{
            remove_session();
        }
        ?>
        <div class="clearfix"></div>
    </div>
</div>
