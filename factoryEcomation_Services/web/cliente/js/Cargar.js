var sensorTags={sensorTag: "name", idSensorCatalog: "-1", commDeviceTag:"-1", 
 		maxValue:"-1", minValue:"-1", 
		idMeasurementUnit:"-1", slId: "-1"};
var selectedChecked="";

/*
**************************************
funcion que se llama cuando se carga la vista
************************************
*/

$(document).ready(function () {     
	//mandar llamar servicios web
	requestSimple('entities.company','#company', 'companyName', 'idCompany' ,null);
	requestSimple('entities.location','#location', 'locationName', 'idLocation',null );
	requestSimple('entities.measurementunits','#measurementUnits', 'unitName', 'idMeasurementUnit',null );
        requestSimple('entities.sensorcatalog','#','idCompany','idSensorCatalog',null);
        requestSimple('entities.sensorlist/noreference','#sensorList', 'slId', 'slId',null );        
	
    $("#btn-form-create").click(function() {


		//ocultarlas
  		$("#div_sensorType").hide();
  		$("#div_commDeviceTags").hide();
  		$("#div_Catalog").hide();
  		$("#soloUnCheckBox").hide();

	});



});
 

/*
*********************************
Funcion de llenado de las opciones de varios servicios web 
***********************************
*/

function pushOptions(json, obj, name , idName){

    //vacias 
    $(obj).empty();

   //opcion vacia 
   $(obj).append("<option id=\"-1\"></option>");
   for (i=0;i<json.length;i++){       
      $(obj).append("<option id=\""+ json[i][idName] +"\">"+json[i][name] +"</option>");
   }
 

}

/*
******************************
//funcion que se llama cuando cambia la opcion de company y se ocultan opciones
********************************
*/

$(document).ready(function () {
  $("#company").change(function(){

    //se muestra el sensortype
    $("#div_sensorType").show();

    //se ocultan
    $("#div_Catalog").hide();
    $("#div_commDeviceTags").hide();  
  
    //lamar el servicio web y se llenan las opciones 
    fillSensorType();

   });

});


/*
***************************
Funcion de llenado de todos los SensorTypes
****************************
*/

function pushOptionsSensorType(json){
   
    //vaciar la lista
    $("#sensorType").empty();
    
    //crear una opcion vacia
    $("#sensorType").append("<option id=-1></option>");
  
   //colocar los datos del sensorType
   for (i=0;i<json.length;i++){

     $("#sensorType").append("<option id="+ json[i].idSensorType.idSensorType+">"+json[i].idSensorType.sensorType +"</option>");
      }

}


/*
*********************************************
*Funcion que se llama cuando cambia el Location 
**********************************************
*/

$(document).ready(function () {
  $("#location").change(function(){
     
    //Muestra los commDeviceTags 
     $("#div_commDeviceTags").show(); 
   
   //Manda a llamar el servicio web
   fillCommonDeviceTag();

   });

});

/*
***************************************
*Funcion que llena todas las opciones de commonDeviceTag despues de llamar el servicio web 
***********************************************
*/


function pushOptionsCommonDeviceTag(json){

    //vaciar la lista
    $("#commDeviceTags").empty();
    
    //crear una opcion vacia
    $("#commDeviceTags").append("<option id=\"-1\"></option>");
  
   //llenado de opciones
   for (i=0;i<json.length;i++)
      {
      $("#commDeviceTags").append("<option id=\""+ json[i].commDeviceTag+"\">"+json[i].commDeviceTag +"</option>");
    
      }
  

}

/*
************************************
Funcion que se manda a llamar cuando cambia de opcion sensorType
**************************************
*/

$(document).ready(function () {
  $("#sensorType").change(function(){
        
    //Manda a llamar el servicio web
	fillSeveralOptionsCatalog();

   });

});

/*
**************************
Funcion que llena las opciones cuando se llama el servicio web
****************************
*/

function pushOptionsSeveralCatalog(json){

    //vaciar la lista
   $("#datos").empty();

   if(json.length > 0){               
	//Muestra los commDeviceTags
	$(document).ready(function(){
		$("#div_Catalog").show(); 
	}); 
    
	//etiquetas del row principal
	   var row="<div class=\"row\" >";
	   var end= "</div>";
	   var col2 ="<div class=\"col-md-2\">";
	   var col3 ="<div class=\"col-md-2\">";




	   for (i=0;i<json.length;i++)
	      {
	       var input="<input type=\"checkbox\" value=\""+ json.idSensorCatalog+"\""; 
	      input =input+" onChange=\"selectedCheckBox(this.id)\" ";
	       input =input+ " id=\"check" + i+ "\">";
	       $("#datos").append(row);
	        $("#datos").append(col2 +input + end);
	         $("#datos").append(col2 + json[i].model + end);
	         $("#datos").append(col2 + json[i].reference + end);
	         $("#datos").append(col3 + json[i].idOutputFormat.outputFormat + end);
	         $("#datos").append(col2 + json[i].idOutputType.outputType + end);
	       $("#datos").append(end);

	      }
	
	}
     else {
      	$(document).ready(function(){
		$("#div_Catalog").hide(); 
	}); 
    }

}



/*
**************************
Funcion que oculta todos los checkbox excepto el del nombre
**************************
*/


function hideExcept(name){
  $(document).ready(function () {
    $("input[id!='"+name+"']").hide();
    $("#max").show();
    $("#min").show();
    $("#sensorTag").show();
    $("#submit1").show();
  });

}



/*
**************************
Funcion que muestra todos los checkbox
**************************
*/


function showAllCheckbox(){
  $(document).ready(function () {
    $("input[type='checkbox']").show();
  });

}


/*
*************************
Funcion que valida si el checkbox esta selecionado o no
********************
*/

function selectedCheckBox(id){
var value = $("#"+id).prop('checked');
  if($("#"+id).prop('checked')){
    selectedChecked=id;
    hideExcept(id);
  } else  {
    showAllCheckbox();
    selectedChecked="";
  }

}

/*
*******************************
Funcion para crear un objecto json
******************************
*/
function createJson(){

alert("entro");
sensorTags.sensorTag=$("#sensorTag").prop("value");
sensorTags.idSensorCatalog=$("#"+selectedChecked).prop("value");
sensorTags.commDeviceTag=$("#commDeviceTags").prop("value");
sensorTags.maxValue=$("#max").prop("value");
sensorTags.minValue=$("#min").prop("value");
sensorTags.idMeasurementUnit=$("#measurementUnits").prop("value");
sensorTags.idLocation=$("#location").prop("value");
sensorTags.slId=$("#sensorList").prop("value");

}
 
