<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 31/12/2015
 * Time: 16:04
 */
?>
<div class="head-bread">
    <div class="container">
        <ol class="breadcrumb">
            <li><a href="<?php echo site_url("produits/") ?>">Accueil</a></li>
            <li class="active">Authentification</li>
        </ol>
    </div>
</div>
<!--signup-->
<!-- login-page -->
<!--hash('sha512', $string);-->
<div class="login">
    <div class="container">
        <div class="login-grids">
            <div class="col-md-6 log">
                <h3>Connexion</h3>

                <div class="strip"></div>
                <p>Bienvenue , s'il vous plaît entrer dans le suivant pour continuer.
                </p>

                <p>Si vous avez déjà Connectez-vous avec nous , <a href="#">Cliquez ici</a></p>

                <div class="alert alert-warning" id="alert" style="display: none;">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <p><?php echo validation_errors(); ?></p>
                </div>
                <form action="<?php echo base_url() . "utilisateurs/verify" ?>" method="post">
                    <h5>Login:</h5>
                    <input type="text" value="" name="login"/>
                    <h5>Mot de passe:</h5>
                    <input type="password" value="" name="password"/><br>
                    <input type="submit" value="Se connecter">

                </form>
                <a href="#">Forgot Password ?</a>
            </div>
            <div class="col-md-6 login-right">
                <h3>Pas encore inscrit?</h3>

                <div class="strip"></div>
                <p>En créant un compte sur notre boutique , vous serez en mesure de se déplacer à travers le processus
                    de paiement plus rapide , stocker des adresses d'expédition multiples , consulter et suivre vos
                    commandes dans votre compte et plus encore.</p>
                <a href="register.html" class="button">S'inscrire</a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //login-page -->
<!--signup-->
<script>
    $('document').ready(function () {
        var message = " <?php echo $message; ?>";

        if (message != "") {
            $("#alert p").html(message);
            $("#alert").show();
            $("#alert").focus();
            setTimeout(function () {
                $("#alert").hide();
            }, 2000);
        }
    });
</script>
