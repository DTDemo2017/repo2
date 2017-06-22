app.controller("UserController", ["$scope", function($scope ){
	console.log("UserController")
	$scope.validate= function()
		{
		
		console.log("ID :" +$scope.id)
		console.log("Password :" +$scope.password)
		UserService.validate($scope.id, $scope.password)
	    }
	
	$scope.user =
		{
			"id" : "",
			"name" : "",
			"password" : ""
		}
	
	$scope.register= function(){
		console.log("ID : " + $scope.user.id)
		console.log("Password : " + $scope.user.password)
		console.log("Name : " + $scope.user.name)
		
		var msg =UserService.register($scope.user)
		console.log(msg)
	}
	
}]);
	
	
	
	
	
	
	
