myapp.controller("BlogController", function($scope, $http) 
{
	$scope.blog={blogid:1006,blogname:"",blogcontent:""};
		
	$http.get('http://localhost:9500/Collaboration/getBlogs')
		.then(function(response)
		{
			$scope.blogdata=response.data;
		});
	$scope.saveBlogPost=function()
	{
		$http.post('http://localhost:9500/Collaboration/insertBlog',$scope.data)
		.then(function(response)
				{
			     $scope.message="Successfully Added Blog";
				}
	);
	
	}

});