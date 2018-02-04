var app = angular.module("noticiApi", ['ngCookies']);

app.value('urlBase', 'http://localhost:8080/NoticiaApi/rest/');

app.controller("noticiApiCtl", function ($scope, $window, $http, urlBase, $cookies) {
    $scope.cad = {id:"", data: "", cargo: "Visitante", titulo: "", conteudo: ""};
    $scope.token = {idTok:"", token: "tøĸ€¢", site:"", tokenSite: "tøĸ€¢"};
    $scope.tokenCre = "";
    $scope.site = "";
    $scope.listUses = [];
    $scope.ComoboBox = [
        {id: '1', name: "Admiinitrador"}, 
        {id: '2', name: "Visitante"},
        {id: '3', name: "Funcionario"}
    ];
    $scope.listStatus = [{ADM: "Admiinitrador", VIS: "Visitante", FUN: "Funcionario"}];

    $scope.enviadados = function (cad, token) {
        var status;
        cad.data = $scope.time();
        
        $http({method: 'POST',
            url: urlBase + "noticias/cadastro",
            data: {cad, token}
        }).then(function (response) {
            status = response.data;

            console.log(status);
            if (status === "A") {
                $window.window.alert("Noticia Cadastrada com sucesso");
                $scope.cancelar();
                $scope.exibir();
            } else if (status === "invalido") {
                $window.window.alert("Token Expirado");
            }
        });

    };
    
    $scope.exibir = function () {
        
        $http({method: 'GET',
            url: urlBase + "noticias/exibicao/" + $scope.token.token
        }).then(function (response) {

            if ((response.data.length === 0)) {
                $window.window.alert("Nenhuma noticia encontrda");
            } else {
                $scope.listUses = response.data;   
            }
        });
    };
    
    $scope.gerarToken = function(token) {
        
        $http({method: 'POST',
            url: urlBase + "noticias/gerarToken",
            data: token
        }).then(function (response) {
            status = response.data;
            console.log(status);
            $scope.token.token = status;
            $scope.tokenCre = status;
        });
    };
    
    $scope.ativarToken = function(token) {
        console.log(token);
        $http({method: 'POST',
            url: urlBase + "noticias/cadastroToken",
            data: token
        }).then(function (response) {
            status = response.data;
            console.log(status);
            $scope.tokenCre = status;
        });
    };
    
    $scope.cancelar = function () {
        $scope.cad = {data: "", cargo: "Visitante", titulo: "", conteudo: ""};
    };
    
    //Pega a data do dia.
    $scope.time = function () {
        var date = new Date();
        var dia = date.getDate();
        var mes = date.getMonth() + 1;
        var ano = date.getFullYear();

        if (dia < 10) {
            dia = "0" + dia;
        }

        if (mes < 10) {
            mes = "0" + mes;
        }

        return "" + ano + "-" + mes + "-" + dia;
        //return "2017-06-26";
    };
});


