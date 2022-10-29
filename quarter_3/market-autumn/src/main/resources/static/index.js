var app = angular.module('app',[]);


app.controller('productsController', function ($scope, $http) {
    const contextPath = "/app";


    $scope.loadProducts = function () {
        $http.get(contextPath + "/product/all")
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

    $scope.deleteProduct = function (productId) {
        $http({
            url: contextPath + '/product/delete',
            method: 'DELETE',
            params: {
                id: productId
            }
            }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addProduct = function () {
        $http({
            url: contextPath + '/product/add',
            method: 'GET',
            params: {
                title: $scope.p_title,
                price: $scope.p_price
            }
        }).then(function (response) {
            $scope.loadProducts();
        }).then(function (){
            $scope.p_title = "";
            $scope.p_price = "";
        })
    };

    $scope.setProductToCustomers = function (productId) {
        $http({
            url: contextPath + '/product/customerList',
            method: 'POST',
            params: {
                id: productId
            }
        });
    };

    $scope.loadProducts();

})

app.controller('customersController', function ($scope, $http) {
    const contextPath = "/app";


    $scope.loadCustomers = function () {
        $http.get(contextPath + "/customer/all")
            .then(function (response) {
                $scope.customerList = response.data;
            });
    };

    $scope.setCustomerToProducts = function (customerId) {
        $http({
            url: contextPath + '/customer/order',
            method: 'POST',
            params: {
                id: customerId
            }
        });
    };

    $scope.loadCustomers();
})

app.controller('orderController', function ($scope, $http) {
    const contextPath = "/app";

    $scope.getCustomerToProducts = function () {
        $http({
            url: contextPath + '/customer/order',
            method: 'GET'
        }).then(function (response) {
            $scope.customerToProducts = response.data;
        });
    };

    $scope.getCustomer = function () {
        $http({
            url: contextPath + '/customer/current',
            method: 'GET'
        }).then(function (response) {
            $scope.currentCustomer = response.data;
        });
    };

    $scope.getCustomer();
    $scope.getCustomerToProducts();
})

app.controller('productsForOrderCtrl', function ($scope, $http) {
    const contextPath = "/app";

    $scope.getProductToCustomers = function () {
        $http({
            url: contextPath + '/product/customerList',
            method: 'GET'
        }).then(function (response) {
            $scope.productToCustomers = response.data;
        });
    };

    $scope.getProduct = function () {
        $http({
            url: contextPath + '/product/current',
            method: 'GET'
        }).then(function (response) {
            $scope.currentProduct = response.data;
        });
    };

    $scope.getProduct();
    $scope.getProductToCustomers()
});

