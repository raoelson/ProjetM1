<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 01/01/2016
 * Time: 10:55
 */
?>
<div class="container">
    <h1>Livraison</h1>
    <hr>
    <div class="col-md-8 grid-gallery">
        <div class="reg">
            <h4 class="m_2"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span><b>Nouvelle adresse</b>
            </h4>

            <div class="alert alert-warning" id="alert" style="display: none;margin-top: 10px;width:380px;">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <p></p>
            </div>
            <form action="<?php echo site_url("validation/ajout/") ?>" method="post">
                <ul>
                    <li class="text-info">Nom:</li>
                    <li><input type="text" value="" name="nom"></li>
                </ul>
                <ul>
                    <li class="text-info">Prenom:</li>
                    <li><input type="text" value="" name="prenom"></li>
                </ul>
                <ul>
                    <li class="text-info">Téléphone:</li>
                    <li><input type="text" value="" name="phone"></li>
                </ul>
                <ul>
                    <li class="text-info">Adresse:</li>
                    <li><input type="text" value="" name="adresse"></li>
                </ul>
                <ul>
                    <li class="text-info">Code postal:</li>
                    <li><input type="text" value="" name="cp"></li>
                </ul>
                <ul>
                    <li class="text-info">Pays:</li>
                    <li><input type="text" value="" name="pays"></li>
                </ul>
                <ul>
                    <li class="text-info">Ville:</li>
                    <li><input type="text" value="" name="ville"></li>
                </ul>
                <ul>
                    <li class="text-info">Complement:</li>
                    <li><input type="text" value="" name="complement"></li>
                </ul>
                <input type="submit" value="Ajouter">
            </form>
        </div>
        <div class="clearfix"></div>
    </div>
    <div class="col-md-5 grid-details">
        <div class="grid-addon">
            <section class="sky-form">
                <?php adresse_livraison(); ?>
            </section>
            <!---->
        </div>
        <div class="grid-addon">
            <section class="sky-form">
                <?php adresse_facturation(); ?>

        </div>
        <div class="clearfix"></div>
    </div>
</div>
<script
    type="text/javascript"><?php echo "var session_flash='" . $this->session->flashdata('error') . "'"; ?></script>
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
        $('#valider').click(function(){
            var adresse = $('input[name=adresse]:checked').val();
            var livraison = $('input[name=adresse_livraison]:checked').val();
            window.location.assign(BASE_URL+'validation/validations/'+adresse+'/'+livraison);
        });
    });
</script>

