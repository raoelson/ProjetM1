<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 17/12/2015
 * Time: 14:33
 */
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Commandes en lignes</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="N-Air Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        } </script>
    <meta charset utf="8">
    <!--fonts-->
    <link href='//fonts.googleapis.com/css?family=Fredoka+One' rel='stylesheet' type='text/css'>

    <!--fonts-->
    <!--bootstrap-->
    <link href="<?php echo base_url('assets/fontend/css/bootstrap.min.css') ?>" rel="stylesheet" type="text/css">
    <!--coustom css-->          
    <link href="<?php echo base_url('assets/fontend/css/style.css') ?>" rel="stylesheet" type="text/css"/>
    <!--shop-kart-js-->
    <script src="<?php echo base_url('assets/fontend/js/simpleCart.min.js') ?>"></script>
    <!--default-js-->
    
    <script src="<?php echo base_url('assets/fontend/js/jquery-2.1.4.min.js') ?>"></script>
    <script src="<?php echo base_url('assets/fontend/js/jquery-ui-1.10.0.custom.min.js') ?>"></script>
    <!--bootstrap-js-->
    <script src="<?php echo base_url('assets/fontend/js/bootstrap.min.js') ?>"></script>
    <!--script-->
    <script src="<?php echo base_url('assets/fontend/js/imagezoom.js') ?>"></script>
    <script src="<?php echo base_url('assets/fontend/js/jquery.flexslider.js') ?>"></script>
    <link rel="stylesheet" href="<?php echo base_url('assets/fontend/css/flexslider.css') ?>" type="text/css"
          media="screen"/>
          <link href="<?php echo base_url('assets/fontend/css/bootstrap-toggle.css') ?>" rel="stylesheet" type="text/css">
     <script src="<?php echo base_url('assets/fontend/css/bootstrap-toggle.js') ?>"></script>     
    <script>
        // Can also be used with $(document).ready()
        $(window).load(function () {
            $('.flexslider').flexslider({
                animation: "slide",
                controlNav: "thumbnails"
            });
        });
    </script>
    <script type="text/javascript">
        var BASE_URL = "<?php echo base_url()?>";
    </script>

</head>
<body>
<div class="header" id="header">
    <div class="container">
        <div class="header-top">
            <div class="logo">
                <a href="<?php echo site_url("produits/")?>">SHOPPING EN LIGNE</a>
            </div>
            <div class="login-bars"> 
            <?php 
            		if(isset(user_session()['href_commandes'])){
            ?>
            <a class="btn btn-default log-bar" href="<?php echo user_session()['href_commandes'];?>" role="button"> <?php  echo user_session()['titre_commandes'];?></a>
            <?php }?>                               
                <a class="btn btn-default log-bar" href="<?php echo user_session()['href_profil'];?>" role="button"> <?php  echo user_session()['profil'];?></a>
                <a class="btn btn-default log-bar" href="<?php echo user_session()['href'];?>" role="button"><?php echo user_session()['titre'];?></a>                
                
                <div class="cart box_1">
                    <?php nombres_panier(); ?>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!---menu-----bar--->
        <div class="header-botom">
            <!----------------------------MENU--------------------------------------->
            <?php echo $header ?>
            <!----------------------------FIN--------------------------------------->
            <!--/.content--->
        </div>
        <!--header-bottom-->
    </div>
</div>
<div class="header-end">
    <div class="container">
        <!----------------------------CAROSSEL--------------------------------------->
        <?php echo $slider ?>
        <!----------------------------FIN--------------------------------------->
        <div class="clearfix"></div>
    </div>
</div>

<!----------------------------PUBLICITE--------------------------------------->

<!-- -->
<!----------------------------FIN--------------------------------------->
<!-------------------------CONTENT------------------------------------->
<div class="feel-fall">
    <?php echo $content ?>
</div>

<!-------------------------FIN------------------------------------->


<!----------------------------FOOTER--------------------------------------->
<?php echo $footer ?>
<!----------------------------FIN--------------------------------------->
</body>


</html>
