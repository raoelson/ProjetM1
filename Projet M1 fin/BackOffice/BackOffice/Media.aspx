<%@ Page Title="article" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="Media.aspx.cs" Inherits="BackOffice.Media" %>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <div class="main-inner">
	<div class="container">
		<div class="row">
			<div class="span12">								
				<span class="span5 btn-toolbar pull-right" style="text-align: right;">
					<a class="btn " href="#ancre" onClick="show()"><i class="icon-picture"></i> Ajouter des images</a>
				</span>				
				<div class="widget widget-table action-table">
					<div class="widget-header">
						<i class="icon-th-list"></i>
                        <h3>Média</h3>
					</div>
					<!-- /widget-header -->
					
					<div class="widget-content">
						<table class="table table-striped table-bordered" id="tabMedia">
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
						<h3>Ajout d'images aux biblioth&eacute;ques</h3>
					</div>
					<!-- /widget-header -->

					<div class="widget-content">
						<div class="tabbable">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#profile" data-toggle="tab">Média</a>
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
                             <td>Image :</td>
                             <td><input id="fuImage" type="file" /></td>
                         </tr>
                         <tr >
                            <td>
                                Alt :
                            </td>
                            <td>
                                <asp:TextBox ID="TextAlt" runat="server"  Width="250px" Text=""></asp:TextBox>
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
    $('document').ready(function () {
        $("#loading-table").show();
        init();
    });
    show = function () {
        $('#informations').show();
    };
    saves = function () {
        var nom = $("#<%=TextAlt.ClientID %>").val();
        if (nom != "") {
            var fileUpload = $("#fuImage").get(0);
            var files = fileUpload.files;

            var data = new FormData();
            for (var i = 0; i < files.length; i++) {
                data.append("file", files[i]);
            }
            data.append("alt", nom);
            $.ajax({
                url: "GenericHandler.ashx",
                type: "POST",
                data: data,
                contentType: false,
                processData: false,
                success: function (result) {
                    if (result != "") {
                        init();
                        effacer();
                    }
                },
                error: function (err) {
                    alert(err.statusText)
                }
            });
        }
    };
    init = function () {
        $.ajax({
            type: "POST",
            url: "Media.aspx/ListeMedia",
            data: '{ }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $("#tabMedia tbody").html("");
                var tbody = "";
                var nbr = data.d;
                var i = 0;
                $.each(nbr, function (i, elt) {
                    tbody += "<tr id='tr_" + elt.id + "'>";
                    tbody += '<td>' + elt.id + '</td>';
                    tbody += '<td>' + elt.alt + '</td>';
                    tbody += '<td><img src="' + elt.path + '"  alt="' + elt.alt + '"/ class="image"></td>';
                    tbody += '<td> <a href="#" onclick=" edit(' + elt.id + ')" class="btn btn-warning"><i class="btn-icon-only icon-pencil"></i> Modifier</a></td>';
                    tbody += '<td> <a href="#" onclick=" delete_(' + elt.id + ",'" + elt.path + "'" + ')" class="btn btn-danger"><i class="btn-icon-only icon-remove"></i> Supprimer</a></td>';
                    tbody += '</tr>';
                    i++;
                });
                $("#tabMedia tbody").append(tbody);
                $("#loading-table").hide();
            }
        });
    }

    edit = function (id) {
        $.ajax({
            type: "POST",
            url: "Media.aspx/SearchMedia",
            data: '{id: "' + id + '" }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $('#informations').show();
                console.log(data);
                $('#fuImage').val(data.d.path);
            }
        });
    }
    effacer = function () {
        $('#<%=txtId.ClientID %>').val("");
        $('#<%=TextAlt.ClientID %>').val("");
        $('#fuImage').val("");
    }

    delete_ = function (id, path) {
        if (!confirm("Supprimez cet media :" + id + "?"))
            return;
        var data = new FormData();
        data.append("id", id);
        data.append("path", path);
        $.ajax({
            url: "GenericHandler.ashx",
            type: "POST",
            data: data,
            contentType: false,
            processData: false,
            success: function (result) {
                if (result != "") {
                    $("#tr_" + result).remove();
                }
            },
            error: function (err) {
                alert(err.statusText)
            }
        });
    }

</script>
</asp:Content>

