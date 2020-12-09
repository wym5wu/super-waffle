function login() {
    console.log("我")
    var account = $("#account").val();
    var password = $("#password").val();
    var vCode =$("#vCode").val();
    var admin =  {"account":account,"password":password,"vCode":vCode};
    $.ajax({
        url:"backstageServlet?whatName=login",
        type:"post",
        data:admin,
        dataType:"text",
        beforeSend:function () {
            if (account.length==0||password.length==0){
                return false;
            }
        },

        success:function (data) {

            alert(data);
            if (data=="登录成功"){

                location.href="pages/Backstage.jsp";
            }else{

            }

        },
        error:function () {
            alert("网络错误")
        },
        complete:function () {

            // alert("执行结束")

        }
    });
    
}
function isAccount() {
    var userName = $("#userName").val();
    var rsAccount = $("#rsAccount").val();
    var vCode =$("#vCode").val();
    var admin =  {"userName":userName,"rsAccount":rsAccount};
    $.ajax({
        async:false,
        url:"backstageServlet?whatName=isAccountUserName",
        type:"post",
        data:admin,
        dataType:"text",
        beforeSend:function () {

        },

        success:function (data) {

            alert(data);
            if (data=="存在"){


            }else{

            }

        },
        error:function () {
            alert("网络错误")
        },
        complete:function () {

            // alert("执行结束")

        }
    });
}
