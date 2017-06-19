app.controller('userCtrl', function($scope) {
    $scope.firstName = "Abbas";
    $scope.lastName = "MD";
    $scope.fullName = function() {
        return $scope.firstName + " " + $scope.lastName;
    };
});