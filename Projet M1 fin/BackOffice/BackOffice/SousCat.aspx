<%@ Page Title="article" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="SousCat.aspx.cs" Inherits="BackOffice.SousCat" %>
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
                        <h3>Gestions des sous categories</h3>
					</div>
					<!-- /widget-header -->
					
					<div class="widget-content">
						<table class="table table-striped table-bordered" id="main-table">
							<thead>
								<tr>									
									<th>Id</th>
									<th>Categories</th>
									<th>Nom</th>									
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
						<h3>Informations des sous catégories</h3>
					</div>
					<!-- /widget-header -->

					<div class="widget-content">
						<div class="tabbable">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#profile" data-toggle="tab">catégorie</a>
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
                                <asp:DropDownList id="CatList"
                                     Width="250px"                                   
                                    runat="server">
                                  

                               </asp:DropDownList>
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
<!-- /main-inner -->

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
            url: "SousCat.aspx/Listsouscategories",
            data: '{ }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $("#main-table tbody").html("");
                var tbody = "";
                var nbr = data.d;
                var i = 0;
                $.each(nbr, function (i, elt) {
                    tbody += "<tr id='tr_" + elt.id + "'>";
                    tbody += '<td>' + elt.id + '</td>';
                    tbody += '<td>' + elt.categoriesId.nom + '</td>';
                    tbody += '<td>' + elt.nom + '</td>';
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
            url: "SousCat.aspx/Searchsouscategories",
            data: '{id: "' + id + '" }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $('#informations').show();
                $('#<%=txtId.ClientID %>').val(data.d.id);
                $('#<%=txtNom.ClientID %>').val(data.d.nom);
                $('#<%=CatList.ClientID %>').val(data.d.categoriesId.id);
            }
        });
    }
    saves = function () {
        var id = $('#<%=txtId.ClientID %>').val();
        var nom = $('#<%=txtNom.ClientID %>').val();
        var cat = $('#<%=CatList.ClientID %>').val();
        if (id != "" && cat != 0) {
            $.ajax({
                type: "POST",
                url: "SousCat.aspx/UpdatesousCategories",
                data: '{id: "' + id + '", nom:"' + nom + '",cat:"' + cat + '" }',
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
        } else if (nom != "" && cat != 0) {
            $.ajax({
                type: "POST",
                url: "SousCat.aspx/AddsousCategories",
                data: '{cat:"' + cat + '",nom:"' + nom + '" }',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    if (data != "") {
                        init();
                        effacer();
                    }
                }
            });
        }
    };
    delete_ = function (id) {
        if (!confirm("Supprimez cet sous categories :" + id + "?"))
            return;
        $.ajax({
            type: "POST",
            url: "SousCat.aspx/Deletesouscategories",
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
    effacer = function () {
        $('#<%=txtId.ClientID %>').val("");
        $('#<%=txtNom.ClientID %>').val("");
        $('#<%=CatList.ClientID %>').val(0);
    }
</script>
</asp:Content>
