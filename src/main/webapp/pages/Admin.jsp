<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/3
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <script src="/js/jquery-3.5.1.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<br>
<div align="center">

</div>
<div class="demoTable" align="center">

    <div class="layui-inline">
        <label class="layui-form-label">注册日期：</label>
        <div class="layui-input-inline" style="width: 200px;">
            <input type="text" class="layui-input" name="beginTime" id="beginTime" placeholder="yyyy-MM-dd">
        </div>
       至
        <div class="layui-input-inline" style="width: 200px;">
            <input type="text" class="layui-input" name="endTime" id="endTime" placeholder="yyyy-MM-dd">
        </div>
    </div>

</div>
</br>
<div class="demoTable" align="center">
    用户名：
    <div class="layui-inline">
        <input class="layui-input" name="name" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


<script src="/layui/layui.js" charset="utf-8"></script>

<script>
    var countNum;
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#beginTime' //指定元素
        });
        laydate.render({
            elem: '#endTime' //指定元素
        });
    });
    layui.use('table', function(){
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            ,url: '/backstageServlet?whatName=adminInfo'
            ,cellMinWidth:80
            ,cols: [[
                {field:'id', title: 'id',hide:true}
                ,{field:'adminName', title: '用户名'}
                ,{field:'updateTime', title: '注册时间', sort: true}
                ,{field:'experience', title: '积分', sort: true}
                ,{field:'experience', title: '上传文档数', sort: true}
                ,{field:'experience', title: '下载文档数', sort: true}
                ,{field:'state', title: '用户状态', sort: true}
                ,{field:'classify', title: '操作',toolbar: '#barDemo'}
            ]],
            done : function(res, curr, count){
                // do something...
                console.log(res)
                console.log(curr)
                console.log(count)
                countNum =count;

            }
            ,id: 'testReload'
            ,page: {
                limit:5,
                limits:[3,5,7]
            }
            ,height: 310

        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');
                var endTime =$('#endTime');
                var beginTime =$('#beginTime ');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {

                            name: demoReload.val(),
                            endTime: endTime.val(),
                            beginTime: beginTime.val()

                    }
                }, 'data');
            }

        };



        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

</script>
<script type="text/html" id="barDemo">
    {{#  if(d.state == "启用"){ }}
    <a type="button" class="layui-btn layui-btn-xs" lay-event="edit" >禁用</a>
    {{#  } else if(d.state == "禁用"){ }}
    <a type="button" class="layui-btn layui-btn-xs" lay-event="edit" >启用</a>
    {{#  } }}
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>

    layui.use('table', function(){
        var table = layui.table;
        table.on('tool(user)', function(obj){
            var data = obj.data;
            // console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    // var $ = layui.$
                    ajax(data.id,"删除");
                    obj.del();
                     layer.close(index);
                    //获取当前页
                    // var recodePage = $(".layui-laypage-skip .layui-input").val();
                    // //获取当前页条数
                    // var recodeLimit = $(".layui-laypage-limits").find("option:selected").val();

                    var $ = layui.$, active = {
                        reload: function(){
                            var demoReload = $('#demoReload');

                            //执行重载
                            table.reload('testReload', {
                                //
                                // page: {
                                //     curr: $(".layui-laypage-em").next().html() //重新从第 1 页开始
                                // }
                                // ,where: {
                                //     key: {
                                //         id: demoReload.val()
                                //     }
                                // }

                            }, 'data');
                        }

                    };
                    // countNum-=1
                    // console.log(recodePage)
                    // console.log(recodeLimit)
                    // console.log(countNum)
                    // if (countNum%recodeLimit==0){
                    //     var $ = layui.$, active = {
                    //         reload: function(){
                    //             var demoReload = $('#demoReload');
                    //
                    //             //执行重载
                    //             table.reload('testReload', {
                    //
                    //                 page: {
                    //                     curr: $(".layui-laypage-em").next().html() //重新从第 1 页开始
                    //                 }
                    //                 ,where: {
                    //                     key: {
                    //                         id: demoReload.val()
                    //                     }
                    //                 }
                    //
                    //             }, 'data');
                    //         }
                    //
                    //     };
                    // }else {
                    //     var $ = layui.$, active = {
                    //         reload: function(){
                    //             var demoReload = $('#demoReload');
                    //
                    //             //执行重载
                    //             table.reload('testReload', {
                    //                 page: {
                    //                     curr: recodePage-1 //重新从第 1 页开始
                    //                 }
                    //                 ,where: {
                    //                     key: {
                    //                         id: demoReload.val()
                    //                     }
                    //                 }
                    //             }, 'data');
                    //         }
                    //
                    //     };
                    // }





                });
            } else if(obj.event === 'edit'){
                if (data.state =='禁用'){
                    obj.tr.children().eq(7).children().eq(0).children().eq(0).html("禁用")
                    obj.update({
                        state: '启用'
                    });
                    ajax(data.id,"启用");


                }else{
                    obj.tr.children().eq(7).children().eq(0).children().eq(0).html("启用")
                    obj.update({
                        state: '禁用'
                    });
                    ajax(data.id,"禁用");
                }
                // layer.prompt({
                //     formType: 2
                //     ,value: data.state
                // }, function(value, index){
                //
                //     layer.close(index);
                // });
            }
        });
    })
function ajax(id,type) {
    var da =  {"id":id,"updateType":type};
    $.ajax({
        async:false,
        url:"/backstageServlet?whatName=updateState",
        type:"post",
        data:da,
        dataType:"text",
        beforeSend:function () {

        },

        success:function (data) {

            alert(data);

        },
        error:function () {
            alert("网络错误")
        },
        complete:function () {

            // alert("执行结束")

        }
    });
}
</script>
</body>
</html>