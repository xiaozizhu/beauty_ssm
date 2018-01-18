<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人中心</title>
    <%@include file="common/head.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=path%>/resource/css/mine.css">
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>个人中心</h2>
        </div>
        <div class="logout">
                <button id="logout" >退出登录</button>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <span id="phone"></span>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>用户ID</td>
                    <td>用户名</td>
                    <td>手机号</td>
                    <td>积分</td>
                    <td>注册时间</td>
                </tr>
                </thead>
                <tbody>
                    <tr>
                    <td id="user_id"></td>
                    <td id="user_name"></td>
                    <td id="user_phone"></td>
                    <td id="user_score"></td>
                    <td id="user_create_time"></td>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/handler.js" type="text/javascript"></script>

<script type="text/javascript">

    function getQueryString() {
        var reg = new RegExp("(^|&)"+ "user_phone"+"=([^&]*)(&|$)");
//            var reg = new RegExp("(^|&)([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }


    $(function () {

        var user_phone = getQueryString()!=null ? getQueryString() : 0;

        $.ajax({
            url:"/user/mine/api",
            type:"GET",
            data:"user_phone="+user_phone,
            dataType:'json',
            success:function(result){
                if (result.code==10000){
                    $('#user_id').text(result.data.userId);
                    $('#user_name').text(result.data.userName);
                    $('#user_phone').text(result.data.userPhone);
                    $('#user_score').text(result.data.score);
                    $('#user_create_time').text(result.data.createTime);
                    
                }else{
                    alert('系统错误');
                }

            },

        });


        handler.goods.init({});
        var phone="用户电话:"+$.cookie('userPhone');
        $('#phone').text(phone);

        $("#logout").on("click",function(){
            $.cookie('userPhone', "", {expires: 0,path:'/'});
            alert("退出登录成功");
            window.location.href="/user/login";
        });


    })



</script>
</html>