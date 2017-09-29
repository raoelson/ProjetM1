<%@ Page Title="commandes" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="Commandes.aspx.cs" Inherits="BackOffice.Commandes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="FeaturedContent" runat="server">
    
    <div class="main-inner">
	<div class="container">
		<div class="row">
			<div class="span12">																
				<div class="widget widget-table action-table">
					<div class="widget-header">
						<i class="icon-th-list"></i>
                        <h3>Gestions des commandes</h3>
					</div>
					<!-- /widget-header -->
					
					<div class="widget-content">
						<table class="table table-striped table-bordered" id="main-table">
							<thead>
								<tr>									
									<th>Id</th>
									<th>Date</th>
									<th>Référence</th>
                                    <th >Client</th>                                    																		
									<th class="td-actions">Voir</th>
                                    <th class="td-actions">Livré</th>                                    
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
        </div>
	<!-- /container -->

</div>
<script>
    $('document').ready(function () {        
        $("#loading-table").show();
        init();
    });
    init = function () {
        $.ajax({
            type: "POST",
            url: "Commandes.aspx/ListCommandes",
            data: '{ }',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $("#main-table tbody").html("");
                var tbody = "";
                var nbr = data.d;
                var i = 0;
                $.each(nbr, function (i, elt) {
                    active = "";
                    if (elt.valider == true) {
                        active = "checked";
                    }
                    tbody += "<tr id='tr_" + elt.id + "'>";
                    tbody += '<td>' + elt.id + '</td>';
                    tbody += '<td>' + (elt.dateCommandes) + ' ' + elt.timesCommandes + '</td>';
                    tbody += '<td>' + elt.reference + '</td>';
                    tbody += '<td>' + elt.utilisateurId.username + '</td>';
                    tbody += '<td> <a href="/Factures.aspx/?id=' + elt.id + '"  class="label-success label label-default"><i class="btn-icon-only icon-list"></i> d\351tails</a></td>';
                    tbody += '<td><div class="toggle-button"><input type="checkbox" '
								+ active + ' onchange="activate(this,' + elt.id + ')" id="checkbox_'+ elt.id
								+ '"></div></td>';
                    tbody += '</tr>';
                    i++;
                });
                $("#main-table tbody").append(tbody);
                $('.toggle-button').toggleButtons();
                $("#loading-table").hide();
            }
        });

    };
    activate = function (obj,id) {
        var id_ = id;                         
        $.ajax({
            type: "POST",
            url: "Commandes.aspx/Updatecommandes",
            data: '{id: "' + id_ + '", valid:"' + obj.checked + '"}',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                if (data != "") {
                    init();
                }
            }
        });
    }
    </script>
</asp:Content>

