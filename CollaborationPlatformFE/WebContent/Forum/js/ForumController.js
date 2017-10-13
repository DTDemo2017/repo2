app.controller('ForumController', ['ForumService', '$scope', '$location', '$rootScope',
	function(ForumService, $scope, $location, $rootScope) {
		console.log('ForumController...');

		var self = this;
		self.forum = {
			id : '', 
			description : '', 
			postDate : '',
			userId : '',
			status : '',
			userName : '',
			errorCode : '',
			errorMessage : ''
		};
		
		self.forums = [];
		
		var self = this;
		self.forumcomment = {
			id : '', 
			forumId : '', 
			comments : '', 
			userId : '',
			commentDate : '',
			forumName : '',
			userName : '',
			errorCode : '',
			errorMessage : ''
		};

		self.forumcomments = [];
		
		self.listForums = function() {
			console.log("-->ForumController : calling 'listForums' method.");
			ForumService
						.listForums()
						.then(function(d) {
							self.forums = d;
						},
						function(errResponse) {
							console.error("Error while getting forum list.")
						});
		};		
		self.listForums();
		self.createForum = function(forum) {
			console.log("-->ForumController : calling 'createForum' method.");
			var currentUser = $rootScope.currentUser
			if (typeof currentUser == 'undefined') {
				alert("Please Login to post a Forum...")
				console.log('User not logged in , can not post a forum...');
				$location.path('/user/login');
			};
			ForumService
						.createForum(forum)
						.then(function(d) {
							self.forum = d;
							alert('Forum posted successfully...')
						},
						function(errResponse) {
							console.error('Error while posting new Forum...');
						});
		};
		
		
		
		
		
		self.getForum = function(id) {
			console.log("-->ForumController : calling 'getForum' method with id : "+id);
			ForumService
						.getForum(id)
						.then(function(d) {
							self.forum = d;
							$location.path('/view_forum/');
						},
						function(errResponse) {
							console.error('Error while fetching forum details...')
						});
		};
		
		
		self.getForum1 = function(id) {
			console.log("-->ForumController : calling 'getForum1' method with id : "+id);
			ForumService
						.getForum1(id)
						.then(function(d) {
							self.forum = d;
							$location.path('/view_forumdet/');
						},
						function(errResponse) {
							console.error('Error while fetching forum details...')
						});
		};
		
		
		self.updateForum = function(forum, id) {
			console.log("-->ForumController : calling updateForum method.");
			ForumService.updateForum(forum).then(self.listForums,
					function(errResponse) {
						console.error('Error while updating forum...')
					});
		};

		self.deleteForum = function(forum, id) {
			console.log("-->ForumController : calling deleteForum method with id : "+id);
			ForumService.deleteForum(id).then(self.listForums,
					alert('Forum deleted successfully...'),
			
					function(errResponse) {
						console.error('Error while deleting forum...')
					});
		};
		

		
		
		self.countComment = function(forum, id) {
			console.log("-->ForumController : calling countComment() method. Forum id is : "+id);
			console.log("-->ForumController", self.forum);
			ForumService.countComment(forum, id).then(
					self.listForums,
					function(errResponse) {
						console.error("Error while commenting on a forum...");
					});
		};

		
		
		self.createForumComment = function(forumcomment) {
			console.log("-->ForumController : calling 'createForumComment' method.");
			var currentUser = $rootScope.currentUser
			if (typeof currentUser == 'undefined') {
				alert("Please Login to post a ForumComment...")
				console.log('User not logged in , can not post a forumcomment...');
				$location.path('/user/login');
			};
			ForumService
						.createForumComment(forumcomment)
						.then(function(d) {
							self.forumcomment = d;
							alert('ForumComment posted successfully...')
						},
						function(errResponse) {
							console.error('Error while posting new ForumComment...');
						});
		};
		
		
		
		
		
		self.fetchAllForumComments = function(forumid) {
			console.log("-->ForumController : calling fetchAllForumComments method with forumid : "+ forumid);
			ForumService.fetchAllForumComments(forumid).then(function(d) {
				self.forumcomments = d;
				$rootScope.selectedForumComments=self.forumcomments;
				self.getForum1(forumid);		//calling getSelectedForum(id) method ...
				$location.path('/forumcomments1');
			}, function(errResponse) {
				console.error('Error while fetching ForumComments...');
			});
		};

		
		
		self.edit = function(id) {
			console.log('id to be edited', id);
			for (var i = 0; i < self.forums.length; i++) {
				if (self.forums[i].id === id) {
					self.forum = angular.copy(self.forums[i]);
					break;
				}
			}
		};
		
		self.remove = function(id) {
			console.log('id to be deleted', id);
			if (self.forum.id === id) {
				self.reset();
			}
			self.deleteForum(id);
		};

		
		
		self.submit = function() {
			{
				console.log("-->ForumController : calling 'submit()' method.", self.forumcomment);
				self.createForumComment(self.forumcomment);
				console.log('Saving new ForumComment', self.forumcomment);
			}
			self.reset();
		};
		
		
		self.reset = function() {
			console.log('submit a new forumcomment', self.forumcomment);
			self.forumcomment = {
					id : '', 
					forumId : '', 
					comments : '',
					userId : '',
					commentDate : '',
					forumName : '',
					userName : '',
					errorCode : '', 
					errorMessage : ''
			};
			$scope.myForm.$setPristine();	//reset form...
		};
		
		
		self.submit = function() {
			{
				console.log("-->ForumController : calling 'submit()' method.", self.forum);
				self.createForum(self.forum);
				console.log('Saving new Forum', self.forum);
			}
			self.reset();
		};
		
		
		self.reset = function() {
			console.log('submit a new forum', self.forum);
			self.forum = {
					id : '', 
					description : '',
					postDate : '',
					userId : '',
					status : '',
					userName : '',
					errorCode : '', 
					errorMessage : ''
			};
			$scope.myForm.$setPristine();	//reset form...
		};
		
		
		

}]);