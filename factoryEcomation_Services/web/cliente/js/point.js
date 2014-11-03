var Point = function Point (value,date,idOutput,unit) {
    
	this.setValue = function setValue (valueIn) {
		value = valueIn;
	}; 
	this.getValue = function getValue () {
		return value;
	};
	this.setDate = function setDate (dateIn) {
		date = dateIn;
      }; 
	this.getDate = function getDate () { 
               var date2 = new Date(date);
               console.log("fecha en point ==  " + date2);
                return date2;
	};   
	this.setIdOutput = function setIdOutput (idOutputIn) {
		idOutput = idOutputIn;
	}; 
	this.getIdOutput = function getIdOutput () {
		return idOutput;
	}; 
 
};