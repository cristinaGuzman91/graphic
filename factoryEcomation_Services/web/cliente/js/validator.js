var validator = function validator () {
	this.isNameValid = function  (name) {
		var re = / [ -~]/;
	    return re.test(name);
  	}
}
