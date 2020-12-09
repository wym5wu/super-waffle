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

    <div class="demoTable" align="center">
       文档标题：
        <div class="layui-inline">
            <input class="layui-input" name="docTitle" id="docTitle" autocomplete="off">
        </div>
        上传人：
        <div class="layui-inline">
            <input class="layui-input" name="adminName" id="adminName"  autocomplete="off">
        </div>
        文档类型：
        <div class="layui-inline">
            <div class="layui-form" lay-filter="myDiv">
                <select name="type" id="type" lay-filter="mySelect">
                    <option value="">请选择</option>
                    <option value="txt">txt</option>
                    <option value="doc">doc</option>
                    <option value="PPT">PPT</option>
                </select>
            </div>
        </div>

    </div>
    <br>
    <div class="layui-inline">
        <label class="layui-form-label">上传日期：</label>
        <div class="layui-input-inline" style="width: 200px;">
            <input type="text" class="layui-input" id="beginTime" name="beginTime" placeholder="yyyy-MM-dd">
        </div>
        至
        <div class="layui-input-inline" style="width: 200px;">
            <input type="text" class="layui-input" id="endTime" name="endTime" placeholder="yyyy-MM-dd">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
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
            ,url: '/backstageServlet?whatName=docInfo'
            ,cellMinWidth:50
            ,cols: [[

        //
        // String docTittle;//文档标题
        // String adminName;//上传人
        //
        // int dowNum;//下载积分
        // String docState;//文档状态
        // String updateTime;//上传时间
        // String type;//类型
                {field:'id', title: 'id',hide:true}
                , {field:'docTittle', title: '文档标题'}
                ,{field:'adminName', title: '上传人'}
                ,{field:'updateTime', title: '上传时间', sort: true}
                ,{field:'dowNum', title: '下载积分', sort: true}
                  ,{field:'type', title: '文档类型', sort: true}
                ,{field:'docState', title: '文档状态',hide:true}
                ,{field:'classify', title: '操作',toolbar: '#barDemo'}
            ]]
            ,id: 'testReload'
            ,page:{
                limit:5,
                limits:[3,5,7]
            }
            ,height: 310
        });

        var $ = layui.$, active = {
            reload: function(){
                var endTime = $('#endTime');
                var beginTime = $('#beginTime');
                var docTitle = $('#docTitle');
                var adminName = $('#adminName');
                var type=$('#type');
                    //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        beginTime:beginTime.val(),
                        endTime:endTime.val(),
                        docTitle:docTitle.val(),
                        adminName:adminName.val(),
                        type:type.val()
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
    {{#  if(d.docState == "待审核"){ }}
    <a type="button" class="layui-btn layui-btn-xs" lay-event="edit" >下载</a>
    <a type="button" class="layui-btn layui-btn-xs" lay-event="edit" >审核通过</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">审核不通过</a>
    {{#  } }}
</script>
</body>
</html>