/* 
 * Javascript functions for calling services
 */

document.observe("dom:loaded", function(){
    
/*INSERT OPERATION*/
    $('submit').observe('click', function(event) {
        
        alert("INSERTO");
        //var input = "{\"idCompany\":0,\"companyName\":\""+ $('companyName').value +"\",\"active\":true,\"lastUpdateDate\":\"2013-12-20\"}";\                                                                                                      "idCompany\":0
        var input = "{\"sensorTag\":\"" + $('#sensorTag').value +"\",\"sensorId\":\"" + $('#sensorList').value +"\",\"company\":\"" + $('#company').value +"\",\"maxValue\":\"" + $('#max').value +"\",\"minValue\":\"" + $('#min').value +"\",\"active\":true,\"idSensorCatalog\":NULL,\"idMeasurementUnit\":\"" + $('#measurementUnits').value + "\",\"commDeviceTag\":\"" + $('#commDeviceTags').value + "\"}";
         
          var sensorTag = $('#sensorTag').value;
          alert("sensorTag" + sensorTag);
          
          var sensorId = $('#sensorList').value;
          alert("sensorLis" + sensorId);
          
          var company = $('#company').value;
          alert("Company" + company);
          
       /*  var max = $("#max").val();
          alert("max" + max);
          
          var min=$("#min").val();
          alert("min" + min);   
          
          var active=$("#company").val();
          alert("active" + active);
          
          var idSensorCatalog=$("#company").val();
          alert("idSensorCatalog" + idSensorCatalog);
          
          var measu = $("#measurementUnits").val();
          alert("measu" + measu);
          
          var comDevTag=$("#commDeviceTags").val();
          alert("comDevTag" + comDevTag);*/
        
                
       //alert(input);
        executeService(
            "insertService",
            /*"insertResult",*/
            "http://localhost:8080/factoryEcomation_Services/webresources/entities.sensortags/create/" + input,
            "POST",
            "application/json",
            input);
             
    });   
});

function onSuccessExecution(element, transport){
    
    var currentdate = new Date();
   
    alert(transport);
    var response = transport.responseText || "no response text";
    
    alert(response);
    alert("element" + element);
    
    if (element === "updateResult"){
        var data = response.evalJSON();
        alert("lo busqué" + data);
              $('updateServiceName').value = data.serviceName;
              $('updateResourceService').value = data.resource;
              $('updateDescriptionService').value = data.description;
              $('updateUrl').value = data.url;
              $('updateRestMethod').value = data.restMethod;
              $('updateInputParam').value = data.inputParam;
              $('updateOutput').value = data.output;
              $('updateOutputFormat').value = data.outputFormat;
              $('updateExample').value = data.example;
        
        $('updateResult').update("<div class='time'>" + currentdate + "</div>");
        //$('uptateResult').update(response + " <div class='time'>" + currentdate + "</div>");
   
    }else{
    $(element).update(response + " <div class='time'>" + currentdate + "</div>");
 }
}


function onFailureExecution(element){
    $(element).update('The proxy is not available...');
}

/*FUNCTION THAT CALLS THE PROXY*/
function executeService(element, service_url, service_method, service_accept, param_array){
    new Ajax.Request('../Proxy',
    {
        method: "GET",
        parameters: {url: service_url, method: service_method, accept: service_accept, param: param_array},
        onSuccess: function(transport){
             onSuccessExecution(element, transport);
             
        },
        onFailure: function(){
            onFailureExecution(element);
        }
    });
    
}