<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/vue/vue.min.js"></script>
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/laypage/laypage.js" charset="utf-8"></script>
    <script src="js/layer/layer.js" charset="utf-8"></script>
</head>
<body>
<div id="app" class="container">
    <form class="form-inline bg-danger" role="form">
        查询条件：
        <div class="form-group">
            <label class="sr-only" for="username">用户名称</label>
            <input type="text" class="form-control" id="username" placeholder="用户名称">
        </div>
        <div class="form-group">
            <label class="sr-only" for="userage">用户年龄</label>
            <input type="text" class="form-control" id="userage" placeholder="用户年龄">
        </div>
        <button type="button" id="findUser" class="btn btn-success">查询用户</button>
        <button type="button" id="addUserBtn" class="btn btn-danger">增加用户</button>
    </form>
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr class="success">
                <td>序号</td>
                <td>用户</td>
                <td>地址</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>
            <tr class="active" v-for="(item,index) in result">
                <td>{{index+1}}</td>
                <td>{{item.username}}</td>
                <td>{{item.address}}</td>
                <td>

                    <a href="#" @click="editEvent(item.id)">编辑</a>
                    <a href="#" @click="delUsers(item.id)">删除</a>
                </td>
            </tr>
            </tbody>
        </table>
        <div id="pagenav"></div>
    </div>
</div>
<script>
    var app = new Vue({
        el:'#app',
        data:{
            result:[]
        }
    });
    var getUserPageList = function(curr){
        $.ajax({
            url:"getPage.do",
            type:"post",
            dataType:"json",
            data:{
                pageNum: curr || 1,
                pageSize:5,
                username:$("#username").val()
            },
            success:function (msg) {
                console.log(msg);
                app.result = msg.page;
                laypage({
                    cont: 'pagenav', //容器
                    pages: msg.totalPage,
                    first: '首页',
                    last: '尾页',
                    skin: '#00A0E9',
                    curr: curr || 1,
                    jump: function (obj, first) {
                        if (!first) {
                            getUserPageList(obj.curr);
                        }
                    }
                });
            }
        });/*ajax结束*/
    }
    getUserPageList();
    $("#findUser").click(function () {
        getUserPageList();
    });
</script>
</body>
</html>