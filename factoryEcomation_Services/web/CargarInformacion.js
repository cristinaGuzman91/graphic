
function onLoad(){
   loadXMLDoc('entities.company','company', 'companyName', 'idCompany' );
   loadXMLDoc('entities.location','location', 'locationName', 'idLocation' );
   loadXMLDoc('entities.sensorcatalog','sensorcatalog', 'model', 'idSensorCatalog' );
   loadXMLDoc('entities.measurementunits','measurementUnits', 'unitName', 'idMeasurementUnit' );
   loadXMLDoc('entities.sensorlist','sensorList', 'slId', 'slId');
}

/*************************************
//Funcion para cargar cuando se inicio
***************************************/


function loadXMLDoc(url,obj, name, idName)
{
    
var xmlhttp;
var txt,x,i;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState===4 && xmlhttp.status===200);
    {
 
    xmlDoc=xmlhttp.responseXML;
    
    //cargar el select
    var select = document.getElementById(obj);
    
    //remover todos los nodos
    select.innerHTML='';
    
    //boton de vacio
      var option = document.createElement("option");
      option.text ="";
      option.value = -1;
      select.add(option);
      
      x=xmlDoc.getElementsByTagName(obj);

    
    for (i=0;i<x.length;i++)
      {
      temp_name= x[i].getElementsByTagName(name)[0].childNodes[0].nodeValue;
      temp_idName= x[i].getElementsByTagName(idName)[0].childNodes[0].nodeValue;
     
   
      var option = document.createElement("option");
      option.text =temp_name;
      option.value = temp_idName;
  
      select.add(option);
      }
 


    }
  };
xmlhttp.open("GET","webresources/" + url,true);
xmlhttp.setRequestHeader("Content-type","application/xml");
xmlhttp.send();
}



/********************************************
 * Funcion para cargar los SensorCatalog
 ******************************************/
function loadXMLSensorCatalog()
{
var xmlhttp;
var txt,x,i;

var index = document.getElementById("company").selectedIndex;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState===4 && xmlhttp.status===200)
    {
        
    xmlDoc=xmlhttp.responseXML;
    
    var select = document.getElementById("sensorType");
    
    //remover todos los nodos
    select.innerHTML='';
    
    //opccion en vacio
    var option = document.createElement("option");
    option.text ="";
    option.value = -1;
    select.add(option);
    
    x=xmlDoc.getElementsByTagName("sensorCatalog");
    
    for (i=0;i<x.length;i++)
      {
          
      temp_name= x[i].getElementsByTagName("idSensorType")[0].getElementsByTagName("sensorType")[0].childNodes[0].nodeValue;
      temp_idName= x[i].getElementsByTagName("idSensorType")[0].getElementsByTagName("idSensorType")[0].childNodes[0].nodeValue;
     
     
      var option = document.createElement("option");
      option.text =temp_name;
      option.value = temp_idName;
      select.add(option);
      }


    }
  };
xmlhttp.open("GET","webresources/entities.sensorcatalog/company/"+index,true);
xmlhttp.setRequestHeader("Content-type","application/xml");
xmlhttp.send();
}

/************************************
 * Funcion para cargar CommonDeviceTags
 *****************************/
function loadXMLCommonDeviceTag()
{
var xmlhttp;
var txt,x,i;

var index = document.getElementById("location").selectedIndex;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState===4 && xmlhttp.status===200);
    {
    
    var select = document.getElementById("commDeviceTags");
    
    //remover todos los nodos
    select.innerHTML='';
    
    //opccion en vacio
    var option = document.createElement("option");
    option.text ="";
    option.value = -1;
    select.add(option);
    
        
    xmlDoc=xmlhttp.responseXML;
    x=xmlDoc.getElementsByTagName("commDeviceTags");
     
  alert("hello"+ index);  
    for (i=0;i<x.length;i++)
      {
          
      temp_name= x[i].getElementsByTagName("commDeviceTag")[0].childNodes[0].nodeValue;
      console.log("Name" + temp_name);
      temp_idName= x[i].getElementsByTagName("commDeviceTag")[0].childNodes[0].nodeValue;
      console.log("idName" + temp_idName);
   
     
      var option = document.createElement("option");
      option.text =temp_name;
      option.value = temp_idName;
      select.add(option);
      }


    }
  };
  

xmlhttp.open("GET","webresources/entities.commdevicetags/location/"+index,true);
xmlhttp.setRequestHeader("Content-type","application/xml");
xmlhttp.send();
}



/*function loadXMLSensorList()
{
var xmlhttp;

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState===4 && xmlhttp.status===200);
    {
    
        xmlDoc=xmlhttp.responseXML;
   
    }
  };*/
  
