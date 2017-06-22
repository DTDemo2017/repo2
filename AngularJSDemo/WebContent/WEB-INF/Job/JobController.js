app.controller("JobController", ["$scope", function($scope){
$scope.message="Job Details"
$scope.job=
	{
		"id" : "JOB_001",
		"title" : "Technical Lead",
		"qualification" : "B.Tech"
	}

$scope.jobsdetails="List of jobs "
	$scope.jobs=
		[
		 
			 {"id" : "JOB_001", "title" : "Technical Lead", "qualification" : "B. Tech"},
			 {"id" : "JOB_002", "title" : "Technical Architect", "qualification" : "M. Tech"},
			 {"id" : "JOB_003", "title" : "Project Manager", "qualification" : "M.B.A."}
		 
		]
}])