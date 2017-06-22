/**var ctrl=function(JobService, $scope, $location, $rootScope)
{
$scope.message="This is the Job Controller..";
}**/




app.controller('JobController', ['JobService', '$scope', '$location', '$rootScope',
	function(JobService, $scope, $location, $rootScope) {
		console.log('JobController...');

		var self = this;
		self.job = {
			id : '', 
			companyName : '', 
			location : '', 
			description : '',
			jobDate : '', 
			status : '', 
			errorCode : '',
			errorMessage : ''
		};

		self.jobs = [];
		self.listJobs = function() {
			console.log("-->JobController : calling 'listJobs' method.");
			JobService
						.listJobs()
						.then(function(d) {
							self.jobs = d;
						},
						function(errResponse) {
							console.error("Error while getting job list.")
						});
		};		
		self.listJobs();
		self.createJob = function(job) {
			console.log("-->JobController : calling 'createJob' method.");
			JobService
						.createJob(job)
						.then(function(d) {
							self.job = d;
							alert('Job posted successfully...')
						},
						function(errResponse) {
							console.error('Error while posting new Job...');
						});
		};
}]);