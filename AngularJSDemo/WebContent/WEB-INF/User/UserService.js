app.service("UserService", function() {

	console.log("In User Service")

	this.validate = function(id,password) {

        if(id == "niit" && password == "niit")	
    {
	
	alert("Valid")
	}
else
	{
	alert("Invalid")
	}
}
	
	this.register = function(user) {
		console.log("successfully registered")
		
		return "successfully registered"
	}

})