angular.module('app',[]).controller('productsController', function ($scope, $http) {
    const contextPath = "/app";
    const form = document.getElementById('add_form');


    $scope.loadProducts = function () {
        $http.get(contextPath + "/products/all")
            .then(function (response) {
                $scope.productsList = response.data;
            });
    };


    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/product/change_price',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.loadProducts();

});