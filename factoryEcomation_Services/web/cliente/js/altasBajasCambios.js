function deleteSensor(sensor){ //delete the sensor from the data base 
  //alert("se borrara el sensor "+sensor.name);   
  requestDeleteSensor(sensor.name,sensor.options.id.slId);
}
function displayForm (serie) { 
	emptyForm();
	if (serie) {
		fillForm(serie);
 	}
}                                   
//this function fill the form from a serie
function fillForm (serie) { 
    requestSimple('entities.sensorlist/getAll','#sensorList', 'slId', 'slId',serie );      
}                                                                             
function fillFormRecivedRequest (serie) { 
    //slId = serie.options.id.slId;
	if ($("#sensorList option[id="+serie.options.id.slId+"]").length <= 0) { 
		
		$("#sensorList").append("<option value="+serie.options.id.slId+">"+
										serie.options.id.slId+"</option>").val(serie.options.id.slId); 
		$("#sensorList").val(serie.options.id.slId);
	}else{       
		$("#sensorList").val(+serie.options.id.slId);
	}          
	if (serie.options.id.tag !== null) {
		$("#sensorTag").prop('disabled', true); 
		sensorIdSelected = serie.name;
		$("#sensorTag").val(serie.name);
		if (serie.options.id.type !== null) {
			$("#measurementUnits").val(serie.options.id.type);
		}
	}else{ 
		$("#sensorTag").prop('disabled', false);
	  
	}
}

function emptyForm () {
	$("#sensorTag").val("");
	$("#sensorList option:eq(-1)");
	$("#company option:eq(-1)");
	$("#company option:eq(-1)");
	$("#sensorType option:eq(-1)");
	$("#location option:eq(-1)");
	$("#commDeviceTags option:eq(-1)");
	$("#max").val(0);
	$("#min").val(0);
	$("#measurementUnits aoption:eq(-1)");
	
}     

     
$(document).ready(function () {
  $("#submit").click(function() {
  if($("#sensorTag").val() !== ""){
	  var SensorTagForm = { 
					"sensorTag":$("#sensorTag").val(),"slId":$("#sensorList").val()
					,"company":$("#company").val(),"maxValue":$("#max").val(),"minValue":$("#min").val()
					,"active":false,"idSensorCatalog":$("#measurementUnits").val()
					,"idMeasurementUnit":$("#measurementUnits").val(),"commDeviceTag":$("#commDeviceTags").val()
					};
	   $("#form-modal").modal("hide");        
	   requestEditCreateSensor(SensorTagForm,$("#sensorTag").val(),slId);	
	}else{
		$("#sensorTagEmpty").text("sensor Tag needed");
	}    
   });
      
   
});


