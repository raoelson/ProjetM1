<%@ Page Title="article" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="Produits.aspx.cs" Inherits="BackOffice.Produits" %>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
     <div class="main-inner">
	<div class="container">
		<div class="row">
			<div class="span12">								
				<span class="span5 btn-toolbar pull-right" style="text-align: right;">
					<a class="btn " href="#ancre" onClick="show()"><i class="icon-user"></i>
						Nouveau</a>
				</span>				
				<div class="widget widget-table action-table">
					<div class="widget-header">
						<i class="icon-th-list"></i>
                        <h3>Gestions des produits</h3>
					</div>
					<!-- /widget-header -->
					
					<div class="widget-content">
						<table class="table table-striped table-bordered" id="main-table">
							<thead>
								<tr>									
									<th>Id</th>
									<th>Categories</th>
									<th>Nom</th>
                                    <th>TVA</th>									
                                    <th>Description</th>
                                    <th>prix</th>
                                    <th>Image</th>
                                    <th>Disponible</th>
									<th class="td-actions" colspan="2">Actions</th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>

						<div class="well well-large well-transparent lead"
							id="loading-table" style="display: none">
							<i class="icon-spinner icon-spin icon-2x pull-left"></i> loading
							content...
						</div>

					</div>
					<!-- /widget-content -->
					
					<div class="pagination pull-right">
						
					</div>
					
				</div>
				<!-- /widget -->

			</div>
			<!-- /span12 -->

		</div>
		<!-- /row -->

		<div class="row" id="informations" style="display: none">
			<div class="span12">
            	<div id="ancre"></div>
				<div class="widget ">
					<div class="widget-header">
						<i class="icon-user"></i>
						<h3>Informations des produits</h3>
					</div>
					<!-- /widget-header -->

					<div class="widget-content">
						<div class="tabbable">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#profile" data-toggle="tab">produits</a>
								</li>
								<!-- <li><a href="#settings" data-toggle="tab">Settings</a> </li>-->

							</ul>
							<br>
							<div class="tab-content">
								<div class="tab-pane active" id="profile">
									<div class="alert" id="alert" style="display: none;">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<p></p>
									</div>
									<form id="form1" runat="server">
									<table align="center" style="position: relative; top: 20px; ">
                        <tr style="display:none;">
                            <td>
                                Id :
                            </td>
                            <td>
                                <asp:TextBox ID="txtId" runat="server"  Width="250px" Text=""></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Nom :
                            </td>
                            <td>
                                <asp:TextBox ID="txtNom" runat="server"  Width="250px"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Catégories:
                            </td>

                            <td>
                                <asp:DropDownList id="CatList_"
                                     Width="250px"                                   
                                    runat="server">
                                  

                               </asp:DropDownList>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Images:
                            </td>

                            <td>
                                <asp:DropDownList id="MediaList_"
                                     Width="250px"                                   
                                    runat="server">
                                  

                               </asp:DropDownList>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                TVA:
                            </td>

                            <td>
                                <asp:DropDownList id="TvaList"
                                     Width="250px"                                   
                                    runat="server">
                                  

                               </asp:DropDownList>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Description :
                            </td>
                            <td>
                                <asp:TextBox ID="TextDesc"  TextMode="multiline" Columns="50" Rows="5" runat="server"  Width="250px"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Prix :
                            </td>
                            <td>
                                <asp:TextBox ID="TextPrix" runat="server"  Width="250px"></asp:TextBox>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Disponible :
                            </td>
                            <td>
                               <input type="checkbox" id="TextBox1" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <center>
                                    <a href="#" class="btn btn-primary" id="bouton" value="" onclick="saves()">Enregistrer</a>
                                    <a href="#"  onclick="effacer()" class="btn">Effacer</a>
                                </center>                                
                            </td>
                        </tr>
                    </table>
                                        </form>
								</div>
							</div>
						</div>
					</div>
					<!-- /widget-content -->
				</div>
				<!-- /widget -->
			</div>
			<!-- /span8 -->			
			<!-- /span4 -->

		</div>
	</div>
	<!-- /container -->

</div>
    <script>
        $('document').ready(function () {
            $("#loading-table").show();
            init();
        });
        show = function () {
            $('#informations').show();
        };
        init = function () {
            $.ajax({
                type: "POST",
                url: "Produits.aspx/ListProduits",
                data: '{ }',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    $("#main-table tbody").html("");
                    var tbody = "";
                    var nbr = data.d;
                    var i = 0;
                    $.each(nbr, function (i, elt) {
                        if (elt.disponible == 1) {
                            active = "label label-info";
                            voir = "en stock";
                        }
                        else {
                            active = "label label-important";
                            voir = "\351puis\351";
                        }
                        tbody += "<tr id='tr_" + elt.id + "'>";
                        tbody += '<td>' + elt.id + '</td>';
                        tbody += '<td>' + elt.categorieId.nom + '</td>';
                        tbody += '<td>' + elt.nom + '</td>';
                        tbody += '<td>' + elt.tvaId.valeur + '</td>';
                        tbody += '<td>' + elt.disponible + '</td>';
                        tbody += '<td>' + elt.prix + '</td>';
                        tbody += '<td><img src="' + elt.imageId.path + '"  alt="' + elt.imageId.alt + '"/ class="image"></td>';
                        tbody += '<td><a href="#" class="' + active + '">' + voir + '</a></td>';
                        tbody += '<td> <a href="#" onclick=" edit(' + elt.id + ')" class="btn btn-warning"><i class="btn-icon-only icon-pencil"></i> Modifier</a></td>';
                        tbody += '<td> <a href="#" onclick=" delete_(' + elt.id + ')" class="btn btn-danger"><i class="btn-icon-only icon-remove"></i> Supprimer</a></td>';
                        tbody += '</tr>';
                        i++;
                    });
                    $("#main-table tbody").append(tbody);
                    $("#loading-table").hide();
                }
            });
        }
        edit = function (id) {
            $.ajax({
                type: "POST",
                url: "Produits.aspx/SearchProduits",
                data: '{id: "' + id + '" }',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    var active = false;
                    $('#informations').show();
                    $('#<%=txtId.ClientID %>').val(data.d.id);
                    $('#<%=txtNom.ClientID %>').val(data.d.nom);
                    $('#<%=CatList_.ClientID %>').val(data.d.categorieId.id);
                    $('#<%=MediaList_.ClientID %>').val(data.d.imageId.id);
                    $('#<%=TvaList.ClientID %>').val(data.d.tvaId.id);
                    $('#<%=TextDesc.ClientID %>').val(data.d.description);
                    $('#<%=TextPrix.ClientID %>').val(data.d.prix);
                    if (data.d.disponible == 1) {
                        active = true;
                    }
                    $('#TextBox1').attr('checked', active);

                }
            });
        }
        saves = function () {
            var id = $('#<%=txtId.ClientID %>').val();
            var nom = $('#<%=txtNom.ClientID %>').val();
            var cat = $('#<%=CatList_.ClientID %>').val();
            var media = $('#<%=MediaList_.ClientID %>').val();
            var tva = $('#<%=TvaList.ClientID %>').val();
            var desc = $('#<%=TextDesc.ClientID %>').val();
            var prix = $('#<%=TextPrix.ClientID %>').val();
            var dispo = $("#TextBox1").is(':checked') ? 1 : 0;
            if (id != "" && cat != 0 && media != 0 && tva != 0 && prix != "") {
                $.ajax({
                    type: "POST",
                    url: "Produits.aspx/UpdateProduits",
                    data: '{id: "' + id + '", nom:"' + nom + '",cat:"' + cat + '", media:"' + media + '",tva:"' + tva
                        + '", desc:"' + desc + '",prix:"' + prix + '",dispo:"' + dispo + '" }',
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                        if (data != "") {
                            effacer();
                            init();
                            $('#informations').hide();
                        }
                    }
                });
            } else if (cat != 0 && media != 0 && tva != 0 && prix != "") {
                $.ajax({
                    type: "POST",
                    url: "Produits.aspx/addProduits",
                    data: '{ nom:"' + nom + '",cat:"' + cat + '", media:"' + media + '",tva:"' + tva
                        + '", desc:"' + desc + '",prix:"' + prix + '",dispo:"' + dispo + '" }',
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                        if (data != "") {
                            effacer();
                            init();
                            $('#informations').hide();
                        }
                    }
                });
            }
        };
        effacer = function () {
            $('#<%=txtId.ClientID %>').val("");
            $('#<%=txtNom.ClientID %>').val("");
            $('#<%=CatList_.ClientID %>').val(0);
            $('#<%=MediaList_.ClientID %>').val(0);
            $('#<%=TvaList.ClientID %>').val(0);
            $('#<%=TextDesc.ClientID %>').val("");
            $('#<%=TextPrix.ClientID %>').val("");
            $('#TextBox1').attr('checked', false);
        };
        delete_ = function (id) {
            if (!confirm("Supprimez cet produit :" + id + "?"))
                return;
            $.ajax({
                type: "POST",
                url: "Produits.aspx/Deleteproduits",
                data: '{id: "' + id + '" }',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    if (data != "") {
                        $("#tr_" + data.d).remove();
                    }
                }
            });
        }
    </script>
</asp:Content>


