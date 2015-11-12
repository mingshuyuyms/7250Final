(function getContent($scope, $http) {
    $http.get('http://localhost:8080/finalP/CompareVectorMajor').
        success(function(data) {
            $scope.compareVectorMajor= data;
        });
    $http.get('http://localhost:8080/finalP/CompareVectorMinor').
    success(function(data) {
        $scope.compareVectorMinor= data;
    });
    $http.get('http://localhost:8080/finalP/ProspectCountTop').
    success(function(data) {
        $scope.propspectCountTop= data;
    });
    $http.get('http://localhost:8080/finalP/ZipCount').
    success(function(data) {
        $scope.zipCount= data;
    });
})();