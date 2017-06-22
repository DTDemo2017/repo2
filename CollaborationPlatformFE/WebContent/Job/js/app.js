var app = angular.module('myApp', ['ngRoute']);



app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'Job/view/home.html',
    controller : 'HomeController'
   
  })

  
   .when('/job', {
    templateUrl : 'Job/view/post_job.html',
    controller : 'JobController as ctrl',
    service : 'JobService'
   
  })

  .otherwise({redirectTo: '/'});
});

