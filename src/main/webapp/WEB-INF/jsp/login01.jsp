<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户登录</title>
<%@include file="common/head.jsp"%>
<style>
	.center {
		position: fixed;
		top: 50%;
		left: 50%;
		background-color: #ffffff;
		width:50%;
		height: 50%;
		-webkit-transform: translateX(-50%) translateY(-50%);
	}
	</style>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>用户登录</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<form:form  method="post" action="" >
						<tr>
							<th>电话</th>
							<td><input type="text" placeholder="请输入用户电话" name="UserPhone"></td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input type="password" name="PassWd" placeholder="请输入密码"></td>
						</tr>

					</form:form>
				</table><jsp:text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</jsp:text>
				<button class="btn-green" id="loginBtn">登录</button>

				<td><a href="/user/add">注册</a></td>
			</div>

		</div>
	</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/handler.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
    $("#loginBtn").on('click',function () {
		var userphone=$('input[name="UserPhone"]').val();
		var passwd=$('input[name="PassWd"]').val();
        handler.userLogin(userphone,passwd);

    });

})


</script>

</html>