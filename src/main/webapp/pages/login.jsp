<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/1
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <script src="js/jquery-3.5.1.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="layui/layui.all.js"></script>
    <script src="js/Login.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form class="layui-form" action="" method="post">
    <div class="container">
        <button class="close" title="关闭">X</button>
        <div class="layui-form-mid layui-word-aux">
            <img id="logoid" src="img/01.png" height="35">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" id="account" name="account" required lay-verify="required" placeholder="请输入用户名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密 &nbsp;&nbsp;码</label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
            <!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
        </div>
        <%--        <div class="layui-form-item">--%>
        <%--            <label class="layui-form-label">验证码</label>--%>
        <%--            <div class="layui-input-inline">--%>
        <%--                <input id="vCode" type="text" name="title" required  lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input verity">--%>
        <%--            </div>--%>
        <%--         <div class="layui-form-mid layui-word-aux">xxxx</div>--%>

        <%--        </div>--%>
        <!-- 			  <div class="layui-form-item">
                            <label class="layui-form-label">记住密码</label>
                            <div class="layui-input-block">
                              <input type="checkbox" name="close" lay-skin="switch" lay-text="ON|OFF">
                            </div>
                      </div> -->

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit lay-filter="formDemo" onclick="login()">登陆</button>
            </div>
        </div>
        <a href="" class="font-set">忘记密码?</a> <a id="butt" class="font-set">立即注册</a>
    </div>
</form>


<%--注册页面--%>
<div style="display: none;" id="gb">
    <form class="layui-form" action="backstageServlet?whatName=register" onsubmit="return isAccount()" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="userName" id="userName" required lay-verify="required" placeholder="请输入账号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户账号</label>
            <div class="layui-input-inline">
                <input type="text" name="account" id="rsAccount" required lay-verify="required" placeholder="请输入账号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="pwd" placeholder="请输入密码" autocomplete="off"
                       class="layui-input" id="pass1">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input type="password" name="passwords" required lay-verify="pwd" placeholder="请再次输入密码"
                       autocomplete="off" class="layui-input" id="pass2">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="email" name="email" required lay-verify="emails" placeholder="请输入邮箱" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" required lay-verify="phones" placeholder="请输入手机号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked>
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">学历</label>
                <div class="layui-input-inline">
                    <select name="type" lay-verify="required" lay-filter="type">
                        <option value=""></option>
                        <option value="本科以上">本科以上</option>
                        <option value="本科">本科</option>
                        <option value="专科">专科</option>
                        <option value="专科以下">专科以下</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo2">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" style="width: 80px">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="layui/layui.js"></script>
<script>
    //注册按钮
    $(function () {
        layui.use(['form', 'layedit', 'laydate'], function () {
            var form = layui.form
                , layer = layui.layer
                , layedit = layui.layedit
                , laydate = layui.laydate;

            //日期
            /* laydate.render({
               elem: '#date'
             });
             laydate.render({
               elem: '#date1'
             });

             //创建一个编辑器
             var editIndex = layedit.build('LAY_demo_editor');

             //自定义验证规则
             form.verify({
               title: function(value){
                 if(value.length < 5){
                   return '标题至少得5个字符啊';
                 }
               }
               ,pass: [
                 /^[\S]{6,12}$/
                 ,'密码必须6到12位，且不能出现空格'
               ]
               ,content: function(value){
                 layedit.sync(editIndex);
               }
             });

             //监听指定开关
             form.on('switch(switchTest)', function(data){
               layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                 offset: '6px'
               });
               layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
             });*/

            //监听提交
            // form.on('submit(formDemo)', function(data){
            //     layer.alert(JSON.stringify(data.field), {
            //         title: '最终的提交信息'
            //     });
            //     // return false;
            // });

            //表单初始赋值
            /* form.val('example', {
               "username": "贤心" // "name": "value"
               ,"password": "123456"
               ,"interest": 1
               ,"like[write]": true //复选框选中状态
               ,"close": true //开关状态
               ,"sex": "女"
               ,"desc": "我爱 layui"
             })*/
            $("#butt").click(function () {
                layer.open({
                    type: 1,
                    title: "注册页面",
                    area: ['600px', '500px'],
                    offset: '20px',
                    content: $("#gb"),
                    cancel: function () {
                        // 你点击右上角 X 取消后要做什么
                        // setTimeout('window.location.reload()', 1);


                        $(this).css("display", "none")

                    },
                    success: function () {
                        form.on('submit(formDemo2)', function (data) {
                        });
                    }
                })
                form.render();
            })

            //验证输入的密码是否相同；
            $("#pass2").blur(function () {
                var pass1 = $("#pass1").val();
                var pass2 = $("#pass2").val();
                if (pass1 != pass2) {
                    layer.msg("两次输入的密码不一致", {
                        "icon": 2,
                        "time": 2000
                    });
                    $("#pass2").val("");
                    return false;
                }
                return true;
            });

            //创建一个编辑器
            var editIndex = layedit.build('LAY_demo_editor');
            //自定义验证规则
            form.verify({
                title: function (value) {
                    if (value.length < 5) {
                        return '标题至少得5个字符啊';
                    }
                },
                pwd: [
                    /^(\w){6,20}$/, '只能输入6-20个字母、数字、下划线'
                ],
                emails: [
                    /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, '请输入正确的邮箱格式：<br>如：xxx@qq.com<br>xxx@163.com等格式'
                ],
                phones: [
                    /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, '您的输入有误，请重新输入(中国11位手机号)'
                ],
                truename: [
                    /^[\u4e00-\u9fa5]{2,4}$/, '您的输入有误，请输入2-4位中文'
                ],
                cardId: [
                    /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/, '请输入正确的身份证号'
                ],
                content: function (value) {
                    layedit.sync(editIndex);
                }
            });
        });

    });
</script>
</body>
</html>
