<%@ Page Title="home" Language="C#" MasterPageFile="~/Template.Master" AutoEventWireup="true" CodeBehind="Dashboard.aspx.cs" Inherits="BackOffice.Dashboard" %>
<asp:Content ID="Content2" ContentPlaceHolderID="FeaturedContent" runat="server">
    <script src="<%: ResolveUrl("~/Scripts/sites/dashboard.js") %>"></script>
    <script src="<%: ResolveUrl("~/Scripts/jquery.flot.js") %>"></script>
    <script src="<%: ResolveUrl("~/Scripts/jquery.flot.pie.js") %>"></script>
    <script src="<%: ResolveUrl("~/Scripts/jquery.flot.orderBars.js") %>"></script>
    <script src="<%: ResolveUrl("~/Scripts/jquery.flot.resize.js") %>"></script>
    <script src="<%: ResolveUrl("~/Scripts/excanvas.min.js") %>"></script>    				
    <script src="<%: ResolveUrl("~/Scripts/charts/area.js") %>"></script>  
    <script src="<%: ResolveUrl("~/Scripts/charts/donut.js") %>"></script> 
    <script src="<%: ResolveUrl("~/Scripts/lib/highcharts/js/highcharts.js") %>"></script>  
    <script src="<%: ResolveUrl("~/Scripts/lib/highcharts/js/modules/exporting.js") %>"></script>  
   
     
    <div class="main-inner">

<div class="main-inner">
<div class="container">
<div class="row">
<div class="span4">
<div class="widget">
<div class="widget-header"><i class="icon-star"></i>
<h3>Stats rapides</h3>
</div>
<!-- /widget-header -->

<div class="widget-content">
<div class="stats">
<div class="stat"><span class="stat-value"><%: Session["valid"] %></span>
Commandes livrées</div>

<!-- /stat -->

<div class="stat"><span class="stat-value"><%: Session["nonvalid"] %></span>
Commandes non livrées</div>
<!-- /stat -->

<div class="stat"><span class="stat-value"><%: Session["ut"] %></span>
Utilisateurs</div>
<!-- /stat --></div>
<!-- /stats -->

<div id="chart-stats" class="stats">
<div class="stat stat-chart">
<div id="donut-chart" class="chart-holder"></div>
<!-- #donut --></div>
<!-- /substat -->

<div class="stat stat-time"><span class="stat-value"><% int calc1 = Convert.ToInt32(Session["valid"]);
                                                        int calc2 = Convert.ToInt32(Session["nonvalid"]);
                                                        %><%:(calc1+calc2) %></span>
Commandes reçues</div>
<!-- /substat --></div>
<!-- /substats --></div>
<!-- /widget-content --></div>
<!-- /widget -->

<!-- /widget --></div>
<!-- /span6 -->

<div class="span8">
<div class="widget">
<div class="widget-header"><i class="icon-signal"></i>
<h3>Chart</h3>
</div>
<!-- /widget-header -->

<div class="widget-content">
<div id="area-chart" class="chart-holder"></div>
</div>
<!-- /widget-content --></div>
<!-- /widget -->


<!-- /widget-content --></div>
<!-- /widget --></div>
<!-- /span6 --></div>
<!-- /row --></div>
<!-- /container --></div>
<!-- /main-inner -->

    <script>
        $(function () {
            inites();
        });
        inites = function () {
            $.ajax({
                type: "POST",
                url: "Dashboard.aspx/ListCharts",
                data: '{ }',
                contentType: "application/json; charset=utf-8",                
                success: function (data_) {
                    initCallBack(data_);
                }
            });
        };
        initCallBack = function (json) {
            //console.log(json);
            var processed_json = new Array();
            var json_ = JSON.parse(json.d);
            $.each(json_, function (i, elt) {
                console.log(elt.value);
                processed_json.push([parseInt(elt.value)]);
            });
            console.log(processed_json);
            var chart;
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'area-chart',
                    type: 'line',
                    marginRight: 130,
                    marginBottom: 25
                },
                title: {
                    text: 'Stat & Graphe',
                    x: -20 //center
                },
                subtitle: {
                    text: 'Source: Statistiques de nbr commandes pour jours',
                    x: -20
                },
                xAxis: {
                    categories: ['00', '01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11',
                    '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', ]
                },
                yAxis: {
                    title: {
                        text: 'Nbrs du Commandes'
                    },
                    plotLines: [{
                        value: 0,
                        width: 1,
                        color: '#808080'
                    }]
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + 'Nombre ' + '</b><br/>' +
                        this.x + ': ' + this.y + ' Nbrs';
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -10,
                    y: 100,
                    borderWidth: 0
                },
                series: [{ data: processed_json }]
            });
        };
    </script>
</asp:Content>

