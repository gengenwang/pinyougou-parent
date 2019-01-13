//品牌控制器
app.controller('brandController',function ($scope,$http,brandService) {
    //查询品牌列表
    $scope.findAll=function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );

    }


    //分页控件配置。currentPage：当前页。totalItems：总记录数。itemsPerPage：每页记录数。perPageOptions：分页选项。onChange：页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
        }
    };

    //刷新列表
    $scope.reloadList=function () {
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }
    //分页
    $scope.findPage=function (page,size) {
        brandService.findPage(page,size).success(
            function (response) {
                $scope.list = response.rows;//当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }
    //保存
    $scope.save=function () {
        var object=null;
        if ($scope.entity.id!=null){
            object=brandService.update($scope.entity);
        }else {
            object=brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if(response.success){
                    $scope.reloadList();//刷新
                }else {
                    alert(response.message);
                }
            }
        );
    }
    //详情
    $scope.findOne=function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        );
    }

    //用户勾选的id集合
    $scope.selectIds=[];
    //用户勾选复选框
    $scope.updateSelection=function ($event,id) {
        if($event.target.checked){
            $scope.selectIds.push(id);//push向集合添加元素
        }else {
            var index = $scope.selectIds.indexOf(id);//查找值得位置
            $scope.selectIds.splice(index,1);//参数1：移除的位置；参数2：移除的个数
        }
    }

    //删除
    $scope.dele=function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if(response.success){
                    $scope.reloadList();
                }else {
                    alert(response.message);
                }
            }
        );
    }
    //条件查询
    $scope.searchEntity={};
    $scope.search=function (page,size) {
        brandService.search(page,size,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;//当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }


});