<%@ Page Title="article" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="Categories.aspx.cs" Inherits="BackOffice.Categories" %>
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
                        <h3>Gestions des categories</h3>
					</div>
					<!-- /widget-header -->
					
					<div class="widget-content">
						<table class="table table-striped table-bordered" id="tabCat">
                            <thead>
                            <tr>
                                <th>id</th>  
                                <th>Nom</th>  
                                <th>Images</th>                                                              
                                <th colspan="2" class="td-actions">actions</th>                                
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
						<i class="icon-th-list"></i>
						<h3>Informations Categories</h3>
					</div>
					<!-- /widget-header -->

					<div class="widget-content">
						<div class="tabbable">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#profile" data-toggle="tab">Catégories</a>
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
                                Image:
                            </td>

                            <td>
                                <asp:DropDownList id="MediaList"
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
		</div>
	</div>
	<!-- /container -->

</div>
<!-- /main-inner -->

<script>
    var current_id;
    var current_page = 1;
    $('document').ready(function () {
        init();
    });
    show = function () {
        $('#informations').show();
    };
    edit = function (id) {
        $.ajax({
            type: "POST",
            url: "Categories.aspx/searchEdit",
            data: '{id: "' + id + '" }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $('#informations').show();
                $('#<%=txtId.ClientID %>').val(data.d.id);
                $('#<%=txtNom.ClientID %>').val(data.d.nom);
                $('#<%=MediaList.ClientID %>').val(data.d.imageId.id);
            }
        });
    }

    init = function () {
        $("#pagination_ul > li:eq(1)").addClass("disabled");
        $("#tabCat").tablesorter(
                {
                    headers: {
                        0: {
                            // disable it by setting the property sorter to false 
                            sorter: false
                        }
                    }
                });
        var total_page = 0;
        $.ajax({
            type: "POST",
            url: "Categories.aspx/Listcategories",
            data: '{debut:"' + 0 + '" }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                console.log(data.d);
                $("#tabCat tbody").html("");
                var tbody = "";
                var nbr = data.d;
                var i = 0;
                $.each(nbr, function (i, elt) {
                    tbody += "<tr id='tr_" + elt.id + "'>";
                    tbody += '<td>' + elt.id + '</td>';
                    tbody += '<td>' + elt.nom + '</td>';
                    tbody += '<td><img src="' + elt.imageId.path + '"  alt="' + elt.nom + '"/ class="image"></td>';
                    tbody += '<td> <a href="#" onclick=" edit(' + elt.id + ')" class="btn btn-warning"><i class="btn-icon-only icon-pencil"></i> Modifier</a></td>';
                    tbody += '<td> <a href="#" onclick=" delete_(' + elt.id + ')" class="btn btn-danger"><i class="btn-icon-only icon-remove"></i> Supprimer</a></td>';
                    tbody += '</tr>';
                    i++;
                    total_page = (i++);
                });
                /**PAGINATION **/
                pagination = '<ul id="pagination_ul">';
                pagination += '<li class="li_numpage disabled" id="li_0"><a href="javascript: actualite.page(current_page - 1 )">Prec.</a></li>';
                for (i = 1; i <= total_page; i++) {
                    pagination += '<li class="li_numpage" id="li_' + i + '"><a href="javascript: actualite.page(' + i + ')">' + i + '</a></li>';
                }
                pagination += '<li class="li_numpage" id="li_' + (10 + 1) + '"><a href="javascript: actualite.page(current_page +1 )">Suiv.</a></li>';
                pagination += '</ul>';
                $(".pagination").html("").append(pagination);
                $(".li_numpage").removeClass("disabled");
                if (current_page == 1) $("#pagination_ul > li:eq(0)").addClass("disabled");
                if (current_page == total_page) $("#pagination_ul > li:eq(" + (current_page + 1) + ")").addClass("disabled");
                $("#pagination_ul > li:eq(" + current_page + ")").addClass("disabled");
                $("#tabCat tbody").append(tbody);
                $("#tabCat").trigger("update");
                $('.toggle-button').toggleButtons();


                $(".tool").tooltip();
            }
        });
    }
    saves = function () {
        var id = $('#<%=txtId.ClientID %>').val();
        var nom = $('#<%=txtNom.ClientID %>').val();
        var image = $('#<%=MediaList.ClientID %>').val();
        if (id != "" && image != 0) {
            $.ajax({
                type: "POST",
                url: "Categories.aspx/Updatecategories",
                data: '{id: "' + id + '", image:"' + image + '",nom:"' + nom + '" }',
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
        } else if (nom != "" && image != 0) {
            $.ajax({
                type: "POST",
                url: "Categories.aspx/Addcategories",
                data: '{image:"' + image + '",nom:"' + nom + '" }',
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
    effacer = function () {
        $('#<%=txtId.ClientID %>').val("");
            $('#<%=txtNom.ClientID %>').val("");
            $('#<%=MediaList.ClientID %>').val(0);

        };

        delete_ = function (id) {
            if (!confirm("Supprimez cet categories :" + id + "?"))
                return;
            $.ajax({
                type: "POST",
                url: "Categories.aspx/Deletecategories",
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
