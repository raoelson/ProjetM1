<%@ Page Language="C#"  AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="BackOffice.Default" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Login - Shop Admin</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"> 
    
<link href="Content/css/bootstrap.min.css" rel="stylesheet" /> 
<link href="Content/css/bootstrap-responsive.min.css" rel="stylesheet" /> 
<link href="Content/css/pages/signin.css" rel="stylesheet" /> 
<script src="<%: ResolveUrl("Scripts/jquery-1.7.2.min.js") %>"></script>
</head>

<body>
	
	<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			
			<a class="brand" href="#" target="_blank">
				Shop Admin by Dani			
			</a>			
			
			<div class="nav-collapse">
				<ul class="nav pull-right">
					
					<li class="">						
						<a href="#" class="">
							Créer un nouveau compte
						</a>
					</li>
					
					<li class="">						
						<a href="<?php echo base_url()?>" class="">
							<i class="icon-chevron-left"></i>
							Retour au page d'accueil
						</a>
						
					</li>
				</ul>
				
			</div><!--/.nav-collapse -->	
	
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->



<div class="account-container">
	
	<div class="content clearfix">
		
		<form>
		
			<h1>Authentification</h1>		
			
			<div class="login-fields">
				
				<p>Identifiez-vous avec votre compte:</p>
				
				<div class="field">
					<label for="username">Login:</label>
					<input type="text" id="login" name="login" value="" placeholder="Login" class="login username-field" required/>
				</div> <!-- /field -->
				
				<div class="field">
					<label for="password">Mot de passe :</label>
					<input type="password" id="password" name="password" value="" placeholder="Mot de passe" class="login password-field" required/>
				</div> <!-- /password -->
				<div class="field" style="text-align: center">
					<label for="to" style="display: block">Me rédiriger vers :</label>
					<select id="to" class="login">
						<option value="admin">Administration de page</option>
						<option value="price">Ajout de prix</option>
					</select>
				</div>
				
			</div> <!-- /login-fields -->
			<p class="alert alert-warning" style="display: none">
      				<i class="icon-info-sign"></i> <span></span>
    		</p>
			<div class="login-actions">
				<h3 style="font-size: 36px;float: left;margin: 15px 34px 0;display: none" id="load"><i class="icon-spinner icon-spin"></i></h3>					
				<input type="button" class="button btn btn-warning btn-large" value='Se connecter' id="connecter" onclick="verify()">
				
			</div> <!-- .actions -->
			
		</form>
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->
<div class="login-extra">
	Pas encore membre? <a href="#">Enregistrez-vous</a><br/>
<!--  	Mot de passe <a href="#">oublié?</a> -->
</div> <!-- /login-extra -->

<script src="<%: ResolveUrl("Scripts/bootstrap.js") %>"></script>
    <script>
        $(function () {

            jQuery.support.placeholder = false;
            test = document.createElement('input');
            if ('placeholder' in test)
                jQuery.support.placeholder = true;

            if (!$.support.placeholder) {

                $('.field').find('label').show();

            }
            $.fn.enterKey = function (fnc) {
                return this.each(function () {
                    $(this).keypress(function (ev) {
                        var keycode = (ev.keyCode ? ev.keyCode : ev.which);
                        if (keycode == '13') {
                            fnc.call(this, ev);
                        }
                    })
                })
            };
            $("#login").focus(function () {
                $(".alert").hide();
            });

            $("#login, #password").enterKey(function () {
                verify();
            });
        });
        verify = function () {
            var login = $("#login").val();
            var password = $("#password").val();
            if (login != "" && password != "") {
                var data = new FormData();
                //data.append("login", login);
                //data.append("password", password);
                $.ajax({
                    url: "Default.aspx/verify",
                    type: "POST",
                    data: '{login:"' + login + '",password:"' + password + '"}',
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (result) {
                        if (result.d != 0) {
                            window.location.assign("/Dashboard.aspx");
                        } else {
                            erreur("Votre login ou password invalid");
                        }
                    },
                    error: function (err) {
                        alert(err.statusText + "ok")
                    }
                });
            } else {
                erreur("Veuillez remplir les champs vides")
            }
        };
        erreur = function (message) {
            $(".alert>span").html("").append(message);
            $(".alert").fadeIn(1000);
            $(".alert").fadeOut(10000, "linear");
        }
    </script>
</body>
</html>

