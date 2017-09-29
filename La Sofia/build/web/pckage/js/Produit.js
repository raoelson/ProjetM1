var processed_json;
var debut = 0;
var nb_pages = 10;
$(document).ready(function() {
    inites(debut,nb_pages);     
    //initescompte();
});

inites = function(debuts,fin) {
    $("#main-table tbody").html("");    
    $.getJSON("ProdsController?actions=listesproduit", {
        "debut" : debuts,
        "fin" : fin
        }, initCallBack);
};
initCallBack= function(json){
    var tbody = "";
    var nbr = json.listesprods;     
    var i=0;    
    $.each(nbr,function(i,elt){        
        tbody += "<tr id='tr_"+ elt.id+ "'>";       
        tbody += '<td>'+ elt.nomProd+'</td>';
        tbody += '<td>' + elt.prixProd + '</td>';      
        tbody += '<td> <button onclick=" edites('+ elt.id+ ')" class="btn btn-default btn-warning">Edit</button></td>';
        tbody += '<td> <a href="#" onclick=" supprimer('+ elt.id+ ')" class="btn btn-default btn-danger"> Delete</a></td>';
        tbody += '</tr>';
        i++;       
    });    
    $("#main-table tbody").append(tbody); 
};
initescompte = function() {      
    $.getJSON("ChambreController?actions=listescomptes", {
        }, initcompteCallBack);
};
initcompteCallBack= function(json){    
    var nbr = json.comptes;            
    var total;    
    total =  Math.ceil(nbr/nb_pages);
    pagination = '<ul id="pagination_ul">';
    for(j=1;j<=total;j++){
        pagination += '<li class="li_numpage" id="li_' + j
        + '"><a href="#page'+j+'"  onclick="javascript:page(' + j + ')">' + j
        + '</a></li>';
    }
    $(".pagination").html("").append(pagination);   
};
page = function(num_page){
    num_page -=1;
    next = num_page * nb_pages;     
    inites(next,nb_pages);    
};
//getOptionsFromForm = function(){
    //    var opt = {
    //        callback: pageselectCallback
    //    };
    // Collect options from the text fields - the fields are named like their option counterparts
    //    $("input:text").each(function(){
    //        opt[this.name] = this.className.match(/numeric/) ? parseInt(this.value) : this.value;
    //    });
    //    // Avoid html injections in this demo
    //    var htmlspecialchars ={
    //        "&":"&amp;", 
    //        "<":"&lt;", 
    //        ">":"&gt;", 
    //        '"':"&quot;"
    //    }
    //    $.each(htmlspecialchars, function(k,v){
    //        opt.prev_text = opt.prev_text.replace(k,v);
    //        opt.next_text = opt.next_text.replace(k,v);
    //    })
    //return opt;
//    };
//pageselectCallback = function(page_index, jq){
//    var items_per_page = $('#items_per_page').val();
//    var max_elem = Math.min((page_index+1) * items_per_page, processed_json.length);
//    var newcontent = '';     
//    // Iterate through a selection of the content and build an HTML string
//    for(var i=page_index*items_per_page;i<max_elem;i++)
//    {
//        newcontent += '<dt>' + processed_json[i][0] + '</dt>';
//        newcontent += '<dd class="state">' + processed_json[i][2] + '</dd>';
//        newcontent += '<dd class="party">' + processed_json[i][3] + '</dd>';
//    }
//
//    // Replace old content with new content
//    $('#Searchresult').html(newcontent);
//
//    // Prevent click eventpropagation
//    return false;
//};
supprimer = function(id){    
    if(!confirm("Supprimez cette chambre "))         
        return;
    $.getJSON("ChambreController?actions=delete&id="+id, supprCallBack);    
};
supprCallBack = function(json){
    var id = json.id;
    //console.log(json.id);
    $("#tr_"+id).remove();
};
show = function(){
    effacer();
    $("#insert_edit").show(); 
};
effacer=function(){
    $("#id").val("");
    $("#surface").val("");
    $("#qualite").val("");   
    $("#loyer").val("");
};
edites = function(id){
    $.getJSON("ChambreController?actions=recherches&id="+id,{        
        },editcallback);
};
editcallback=function(json){
    var chambre =  json.findchambre;    
    $("#id").val(chambre.idchambre);
    $("#surface").val(chambre.surfacechambre);
    $("#qualite").val(chambre.qualitechambre);
    $("#loyer").val(chambre.loyerchambre);
    $("#occupation").val(chambre.dispochambre);  
    $("#insert_edit").show();
};
cancel=function(){
    $("#insert_edit").hide();
};
ajouter=function(){
    var erreur = "";
    if (!$("#surface").val() || !$("#qualite").val() || !$("#loyer").val()) {
        erreur = "Vérifier bien le formulaire";
    }
    else if(erreur == "")       
        $.getJSON("ChambreController?actions=create", {
            "id" : $("#id").val(),
            "surface" : $("#surface").val(),
            "qualite" : $("#qualite").val(),
            "loyer" : $("#loyer").val(),
            "occupation" : $("#occupation").val()          
        },saveCallBack);
    if(erreur){
        $("#alert p").html(erreur);
        $("#alert").show();
        $("#alert").focus();
        setTimeout(function() {
            $("#alert").hide();
        }, 2000);
    }
};
saveCallBack=function(json){
    var success = json.success;
    console.log(success);
    if(json.success="true"){
        cancel();
        inites(); 
    }
};

