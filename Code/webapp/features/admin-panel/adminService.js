(function() {
    angular.module('admin')
        .factory('adminService', adminService);

    function adminService($http, LocationService) {
        // create a new object
        var adminFactory = {};

        adminFactory.loadAllUsers = function () {
            return $http.get('/api/getallusers/').then(function (data) {
                return data.data;
            });
        };
        adminFactory.impersonate = function(user) {
            return $http.post(LocationService.vipApiUrls.login, { email: user.email }).then(function (response) {
                return response.data;
            }, function(response) {
                return response.data;
            });
        };

        return adminFactory;
    }
}());