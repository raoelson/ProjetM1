$(function () {
    function initCallBack(json){
    	var v = [];
    	$.each(json.visitors,function(i,elt){
    		v.push([i,parseInt(elt)]);
    	});
    	console.log(v);
        var plot = $.plot($("#area-chart"),
               [ { data: v, label: "Total visites: "+20+" # Visite de la semaine: "+3000}],{
                   series: {
                       lines: { show: true },
                       points: { show: true }
                   },
                   
                   grid: { hoverable: true, clickable: true },
                   yaxis: { min: 0, max: 100 },
    			   //xaxis: { min: 0, max: 9 },
        	colors: ["#F90", "#222", "#666", "#BBB"]
                 });
        };
    //$.getJSON(BASE_URL + "visite/get/", initCallBack);
});