<%@ Page Title="commandes" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="Factures.aspx.cs" Inherits="BackOffice.Factures" %>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <div class="main-inner">
	<div class="container">
		<div class="row">
			<div class="span12">																
				<div class="widget widget-table action-table">
                    
					<div class="widget-header">
						<i class="icon-th-list"></i>
                        <h3>Détails des commandes</h3>
                                                 
					</div>
					<!-- /widget-header -->
					
					<div class="widget-content">
						
                            <asp:Label ID="labelMessage" runat="server" />
                             <form runat="server" id="forw">
                                 
                                 <asp:GridView ID="listFact" runat="server" CssClass="table table-striped table-bordered" ShowFooter="true"
                                      >                                                                                              
                                 </asp:GridView>
						      </form>
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
</asp:Content>

