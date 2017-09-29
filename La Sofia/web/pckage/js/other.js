$(document).ready(function() {
   inites();
});
inites = function() {
    $("#main-table tbody").html("");       
    $.getJSON("AdminController?actions=erreur", {       
    },initCallBack);
};
initCallBack= function(json){
    document.location='/GestionHotelEJB/';
    $("#alert p").html(json.message);
    $("#alert").show();
    $("#alert").focus();
    setTimeout(function() {
        $("#alert").hide();
    }, 2000);
};


