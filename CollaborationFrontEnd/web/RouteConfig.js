myapp.config(function($routeProvider)
{
	$routeProvider.when("/", {templateUrl:"Template/Home.html"})
	.when("/Login", {templateUrl:"Template/Login.html"})
	.when("/Register", {templateUrl:"Template/Register.html"})
	
	.when("/Blog", {templateUrl:"C_Blog/Blog.html",controller:"BlogController"})
	.when("/Forum", {templateUrl:"Forum.html"})
	
});