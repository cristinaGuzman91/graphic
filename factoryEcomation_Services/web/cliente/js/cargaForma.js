var forma = ''+	
'<div class="container">'+
	'<form role="form">'+  
		'<div class="form-group">'+
			'<label id="sensorTagEmpty"></label>'+
		'</div>'+
		'<div class="form-group">'+
    			'<label>SensorTag</label>'+
    			'<input class="form-control" placeholder="Enter Name" id="sensorTag"></input>'+
  		'</div>'+
		'<div class="form-group">'+
			'<label>Sensor ID</label>'+
			'<select class="form-control" id="sensorList"></select>'+
		'</div>'+
  		'<div class="form-group">'+
   			'<label>Company</label>'+
			'<select class="form-control" id="company"></select>'+
		'</div>'+
		'<div class="form-group" id="div_sensorType" style="display: block;">'+
			'<label id="">Sensor Type</label>'+
			'<select class="form-control" id="sensorType"></select>'+
		'</div>'+
		'<div class="form-group" id="div_Catalog">'+
		    '<p>Catalog</p>'+ 
			'<div class="row" id="titulos">'+
				'<div class="col-md-2">checkbox</div>'+
				'<div class="col-md-2">model</div>'+
				'<div class="col-md-2">reference</div>'+
				'<div class="col-md-2">output format</div>'+
				'<div class="col-md-2">output Type</div>'+      
			'</div>'+
		'<div id="datos" class="row"></div>'+  
		'</div>'+        
		'<div class="form-group">'+
			'<label>Location</label>'+
			'<select class="form-control" id="location"></select>'+
		'</div>'+
		'<div class="form-group" id="div_commDeviceTags" style="display: block;">'+
   			'<label>Common device Tag</label>'+
   			'<select class="form-control" id="commDeviceTags"></select>'+
		'</div>'+
		'<div class="form-group">'+
    			'<label>Max Value</label>'+
    			'<input type="number" class="form-control" placeholder="Enter Max" id="max">'+
		'</div>'+
		'<div class="form-group">'+
    			'<label>Min Value</label>'+
			'<input type="number" class="form-control" placeholder="Enter Min" id="min">'+
  		'</div>'+
		'<div class="form-group">'+
   			'<label>Unit Name</label>'+
			'<select class="form-control" id="measurementUnits"></select>'+
		'</div>'+
	'</form>'+
'</div>';     

