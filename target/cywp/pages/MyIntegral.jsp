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
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<br>
<div align="center">

</div>
<div class="demoTable" align="center">

    <div class="layui-inline">
        当前积分：1000
    </div>

</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


<script src="/layui/layui.js" charset="utf-8"></script>
<script>
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
            ,url: '/demo/table/user/'
            ,cellMinWidth:80
            ,cols: [[
                {field:'username', title: '发生时间'}
                ,{field:'updateTime', title: '发生用户', sort: true}
                ,{field:'experience', title: '增加/扣除', sort: true}
                ,{field:'experience', title: '积分数', sort: true}
            ]]
            ,id: 'testReload'
            ,page: true
            ,height: 310
        });

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            id: demoReload.val()
                        }
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
    <a class="layui-btn layui-btn-xs" lay-event="edit">禁用</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">启用</a>
</script>
</body>
</html>