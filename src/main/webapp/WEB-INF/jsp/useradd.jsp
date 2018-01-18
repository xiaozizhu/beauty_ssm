<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<!-- 上面的这个div, 有一个container的class ,想选择这个div怎么办-->
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>用户注册</h2>
			</div>

			<div class="panel-body">
				<table class="table table-hover">
					<form:form  method="post" action="" >
						<tr>
							<th>用户电话</th>
							<td><input type="text" name="userPhone"></td>
						</tr>
						<tr>
							<th>用户姓名</th>
							<td><input type="text" name="userName"></td>
						</tr>
						<tr>
							<th>用户密码</th>
							<td><input type="password" name="passwd"></td>
						</tr>
					</form:form>
				</table>
				<button class="btn btn-info" id="userAdd">提交</button>
			</div>
		</div>
	</div>


</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/handler.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
    $("#userAdd").on('click', function () {
        // 这个userAdd需要三个参数
		var userPhone = $('input[name="userPhone"]').val();
		var userName = $('input[name="userName"]').val();
		var passwd = $('input[name="passwd"]').val();
		handler.userAdd(userPhone,userName,passwd);
	});
})
</script>
</html>