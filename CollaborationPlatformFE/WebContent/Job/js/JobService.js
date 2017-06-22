

app.factory('JobService', ['$http', '$q', '$rootScope',
    function($http, $q, $rootScope) {
	console.log("JobService...");

		var BASE_URL='http://localhost:9500/CollaborationPlatform'
			return {

			listJobs : function() {
				console.log("-->JobService : calling 'listJobs' method.");
				return $http
							.get(BASE_URL+'/jobs')
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.error('Error while getting Job list...');
								return $q.reject(errResponse);
							});
			},
			
			createJob : function(job) {
				console.log("-->JobService : calling 'createJob' method.");
				return $http
							.post(BASE_URL+'/job/', job)
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.error('Error while posting new Job...');
								return $q.reject(errResponse);
							});
			},
			
			
		
		};
}]);


			
			
			

			

			

			
			
			

			