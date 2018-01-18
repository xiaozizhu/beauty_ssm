<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="shortcut icon" type="image/x-icon" href="<%=path%>/resource/image/logo.png"
          media="screen">
    <link rel="apple-touch-icon-precomposed" href="<%=path%>/resource/image/logo.png">
    <title>beauty登录中心</title>
    <!-- 当前页面css -->
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/base.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/mine.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/index.css">
    <script src="<%=path%>/resource/script/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<div class="box-position">

    <div class="login-system">
        <div class="top">
            <h1>beauty登录中心</h1>
        </div>
        <ul class="flexbox">
            <li class="flexcon"><span class="suffix">手机号</span></li>
            <li class="flexcon">
                <div class="borderbox">
                    <input type="text" class="ipt" placeholder="请输入用户名" id="UserName" name="UserPhone">
                </div>
            </li>
        </ul>
        <ul class="flexbox">
            <li class="flexcon"><span class="suffix">密码</span></li>
            <li class="flexcon">
                <div class="borderbox">
                    <input type="password" placeholder="请输入密码" class="ipt" id="Password" name="PassWd">
                </div>
            </li>
        </ul>

        <div class="ll">
            <button id="loginBtn" class="login" >登录</button>
            <jsp:text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</jsp:text>
            <button id="loginAdd" class="login" >注册</button>
        </div>


    </div>
    <div class="logo-bottom"></div>

</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/handler.js" type="text/javascript"></script>
<script type="text/javascript">
    function getCookie() {
        var phone = $.cookie('userPhone');
        if (phone){
            window.location.href = '/user/mineapi?user_phone='+phone;

        }
    }
    
    
    $(function(){
        getCookie();

        $("#loginBtn").on('click',function () {
            var userphone=$('input[name="UserPhone"]').val();
            var passwd=$('input[name="PassWd"]').val();
            handler.userLogin(userphone,passwd);

        });

        $("#loginAdd").on('click',function () {
            window.location.href=handler.URL.userAdd();
        });


    });

</script>


</html>
