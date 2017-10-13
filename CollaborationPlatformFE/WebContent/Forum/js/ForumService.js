app.factory('ForumService', ['$http', '$q', '$rootScope',
    function($http, $q, $rootScope) {
	console.log("ForumService...");

		var BASE_URL='http://localhost:9500/CollaborationPlatform'
			return {

			listForums : function() {
				console.log("-->ForumService : calling 'listForums' method.");
				return $http
							.get(BASE_URL+'/forums')
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.error('Error while getting Forum list...');
								return $q.reject(errResponse);
							});
			},
			
			createForum : function(forum) {
				console.log("-->ForumService : calling 'createForum' method.");
				return $http
							.post(BASE_URL+'/forum/', forum)
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.error('Error while posting new Forum...');
								return $q.reject(errResponse);
							});
			},
			
			
			
			getForum : function(id) {
				console.log("-->ForumService : calling 'getForum' method with id : "+id);
				return $http
							.get(BASE_URL+'/getForum/'+id)
							.then(function(response) {
								$rootScope.selectedForum = response.data;
								return response.data;
							},
							function(errResponse) {
								console.error('Error while getting forum details');
								return $q.reject(errResponse);
							});
			},
			
			
			getForum1 : function(id) {
				console.log("-->ForumService : calling 'getForum1' method with id : "+id);
				return $http
							.get(BASE_URL+'/getForum/'+id)
							.then(function(response) {
								$rootScope.selectedForum = response.data;
								return response.data;
							},
							function(errResponse) {
								console.error('Error while getting forum details');
								return $q.reject(errResponse);
							});
			},
			
			
			updateForum : function(forum, id) {
				console.log("-->ForumService : calling 'updateForum' method with id : "+id);
				return $http
							.put(BASE_URL+'/updateForum/'+id)
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.error('Error while updating Forum');
								return $q.reject(errResponse);
							});
			},
			
			deleteForum : function(forum, id) {
				console.log("-->ForumService : calling 'deleteForum' method with id : "+id);
				return $http
							 delete(BASE_URL+'/deleteForum/'+id)
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.log('Error while deleting Forum');
								return $q.reject(errResponse);
							});
			},

			
			
			countComment : function(forum, id) {
				console.log("-->ForumService : calling 'countComment' method : getting forum with id : " + id);
				return $http
							.put(BASE_URL+'/forum/countComment/'+id, forum)
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.log("Error while commenting on a forum...");
								return $q.reject(errResponse);
							});
			
			
		},
		
		
		
		
		

		
		fetchAllForumComments : function(forumid) {
			console.log("-->ForumService : calling 'fetchAllForumComments' method for forumid : " + forumid);
			return $http
						.get(BASE_URL + '/forumComments/'+forumid)
						.then(function(response) {
							$rootScope.selectedForumComments = response.data;
							
							return response.data;
						}, 
						function(errResponse) {
							console.error('Error while fetching ForumComments');
							return $q.reject(errResponse);
						});
		},
		

	

			
			
			
			createForumComment : function(forumcomment) {
				console.log("-->ForumService : calling 'createForumComment' method.");
				return $http
							.post(BASE_URL+'/forumcomment/', forumcomment)
							.then(function(response) {
								return response.data;
							},
							function(errResponse) {
								console.error('Error while posting new ForumComment...');
								return $q.reject(errResponse);
							});
			},
		
		};
}]);

