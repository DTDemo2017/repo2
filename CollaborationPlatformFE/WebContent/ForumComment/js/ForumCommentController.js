app.controller('ForumCommentController', ['ForumCommentService', '$scope', '$location', '$rootScope',
	function(ForumCommentService, $scope, $location, $rootScope) {
		console.log('ForumCommentController...');

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
		self.listForumComments = function() {
			console.log("-->ForumCommentController : calling 'listForumComments' method.");
			ForumCommentService
						.listForumComments()
						.then(function(d) {
							self.forumcomments = d;
						},
						function(errResponse) {
							console.error("Error while getting forumcomment list.")
						});
		};		
		self.listForumComments();
		
		self.getForumComment = function(id) {
			console.log("-->ForumCommentController : calling 'getForumComment' method with id : "+id);
			ForumCommentService
						.getForumComment(id)
						.then(function(d) {
							self.forumcomment = d;
							$location.path('/view_forumcomment/');
						},
						function(errResponse) {
							console.error('Error while fetching forumcomment details...')
						});
		};
		
		
}]);