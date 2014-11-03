
//initial request get all the initial sensors with all their points
//var server_name="10.18.9.32";

var server_name="localhost";

function requestSensores() {
    var url = 'http://localhost:8080/factoryEcomation_Services/webresources/sensors';
    var data = {};
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: false,
        jonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
       cache:true,
        //crossDomain : true, 
        success: function(json) {
            console.log("Primer conexion: " + json);
            data = json;
            
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            //console.log(json);
        }
    });
    return data;

}

//get the lastest points of the chart
function requestNewPoints() {
    var url = 'http://localhost:8080/factoryEcomation_Services/webresources/sensors';
    
    var data = {};
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //cache:false,
        crossDomain : true, 
       success: function(json) {
                //console.log(json);
                data = json;
                console.log("Request2 : " + data);
                //console.log(json);
                graphPoints(data);
                
         },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    
   });
}

/*
var /*req = new XMLHttpRequest (); 
//get the lastest points of the chart
function requestNewPoints() {
   
    var url = 'http://'+ server_name +':8080/servicesFE_graph/webresources/entities.sensorlist';
    req.open("GET", url += (url.match(/\?/) === null ? "?" : "&") + (new Date()).getTime(), false);
    req.setRequestHeader("Content-type","application/json");
    //req.send();
  
    var data = {};
    $.support.cors = true;
    $.ajax({
        //headers: {'Access-Control-Allow-Origin: <origin> ':' http://localhost:8080/servicesFE_graph/webresources/entities.sensorlist'},
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        //contentType: "application/json",
        dataType: 'json',
        //crossDomain : true, 
        success: function(json) {
            console.log("New Request" + json);
            graphPoints(json);
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });

}

*/

   


//Carga company, location, measurement y sensorlist cuando se carga la pagina. 

function requestSimple(url, obj, name, idName, serie) {
     var url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/' + url;
    var data;
    //console.log(data["idSensor"]);
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //crossDomain : true, 
        success: function(json) {
            pushOptions(json, obj, name, idName);
            if (serie) {
                fillFormRecivedRequest(serie);
            }
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });
    return data;

}

//Filtra sensorCatalog por compañia. 

function fillSensorType() {
    var index = document.getElementById("company").selectedIndex;
    var url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/entities.sensorcatalog/company/' + index;    var data;
    //console.log(data["idSensor"]);
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //crossDomain : true, 
        success: function(json) {
            pushOptionsSensorType(json);
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });
    return data;

}



//filtra commDeviceTags por locationId  SELECT * FROM commdevicetags WHERE locationID=index

function fillCommonDeviceTag() {
    var index = document.getElementById("location").selectedIndex;
    var url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/entities.commdevicetags/location/' + index;    var data;
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //crossDomain : true, 
        success: function(json) {
            pushOptionsCommonDeviceTag(json);
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });
    return data;

}

//filtra SensorCatalog por compañia y por SensorType  SELECT * FROM sensorCatalog WHERE idCompany=id AND sensorType=idSensorType

function fillSeveralOptionsCatalog() {
    var idCompany = document.getElementById("company").selectedIndex;
    var idSensorType = document.getElementById("sensorType").selectedIndex;
    var url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/entities.sensorcatalog/company/' + idCompany + '/sensorType/' + idSensorType;
    var data;
    //console.log(data["idSensor"]);
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //crossDomain : true, 
        success: function(json) {
            pushOptionsSeveralCatalog(json);
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });
    return data;

}

function requestEditCreateSensor (json,id,slId) {
	var url;               
	var typeRequest = null;
	if (create) {    
		url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/entities.sensortags/create';  
		typeRequest = 'POST';    
	}else{             
		url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/entities.sensortags/'+id;  
		typeRequest = 'PUT';
	}   
	json = {//checar este pedo por que no jala cuando lo envio por parametro
		  "sensorTag":$("#sensorTag").val(),"slId":$("#sensorList").val()
			,"company":$("#company").val(),"maxValue":$("#max").val(),"minValue":$("#min").val()
			,"active":false,"idSensorCatalog":$("#measurementUnits").find(":selected")[0].id,"idLocation":$("#location").find(":selected")[0].id
			,"idMeasurementUnit":$("#measurementUnits").find(":selected")[0].id,"commDeviceTag":$("#commDeviceTags").val()
		 };
	$.support.cors = true;
	$.ajax({    
	    type: typeRequest,
	    url: url,
	    async: true,  
		//data : json,
		data :JSON.stringify(json),
	    jsonpCallback: 'jsonCallback',
	    contentType: "application/json; charset=UTF-8",
	    dataType: 'json',
		crossDomain : true, 
	    success: function(json) {
			//crear o editar el sensor 
			console.log(json,create,json.slId);
			if (create) {
				if(json.slId !== null){
					redraw(json.sensorTag,json.slId["slId"],create,json.idMeasurementUnit.unitName,slId);
				} 
			}else{
				if(json.slId !== null){
					redraw(id,json.slId["slId"],create,json.idMeasurementUnit.unitName,slId);
				}else{
					redrawDeleteSensorOrNoSlId(slId); 
				} 
			}
	    },
	    error: function(e) { 
	       console.log(e);
	    },
	    onload:function(json){
		console.log();
	    }
	});
}    
function requestDeleteSensor (id,slId) {
    var url = 'http://localhost:8080/factoryEcomation_Services/webresources/entities.sensortags/'+id;
	$.support.cors = true;
	$.ajax({    
	    type: 'DELETE',
	    url: url,
	    async: true,  
            data : null,
	    jsonpCallback: 'jsonCallback',
	    contentType: "application/json",
	    dataType: 'json',   
		//crossDomain : true, 
	    success: function(id) {
            console.log("succes en borrar");
            redrawDeleteSensorOrNoSlId(slId);

        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });
}

function requestDescubreSensores() {
    var url = 'http://'+ server_name +':8080/factoryEcomation_Services/webresources/';
    $.support.cors = true;
    $.ajax({
        type: 'GET',
        url: url,
        async: true,
        data: json,
        jsonpCallback: 'jsonCallback',
        contentType: "application/json",
        dataType: 'json',
        //crossDomain : true, 
        success: function(json) {
            console.log(json);
            sensorDiscovereds.push(json);
        },
        error: function(e) {
            console.log(e);
        },
        onload: function(json) {
            console.log();
        }
    });
}
