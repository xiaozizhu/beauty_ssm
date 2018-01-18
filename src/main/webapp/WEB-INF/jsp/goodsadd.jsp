<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>新增商品</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<!-- 上面的这个div, 有一个container的class ,想选择这个div怎么办-->
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>新增商品</h2>
			</div>

			<div class="panel-body">
				<table class="table table-hover">
					<form:form  method="post" action="" >
						<tr>
							<th>商品名称</th>
							<td><input type="text" name="title"></td>
						</tr>
						<tr>
							<th>商品价格</th>
							<td><input type="text" name="price"></td>
						</tr>
						<tr>
							<th>商品数量</th>
							<td><input type="text" name="number"></td>
						</tr>
					</form:form>
				</table>
				<button class="btn btn-info" id="goodsAdd">新增</button>
			</div>
		</div>
	</div>


	<%--登录弹出层 输入电话--%>
	<div id="loginModal" class="modal fade">

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"> </span>用户电话
					</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-8 col-xs-offset-2">
							<input type="text" name="userPhone" id="userPhone" placeholder="填写手机号" class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<%--验证信息--%>
					<span id="userPhoneMessage" class="glyphicon"> </span>
					<button type="button" id="loginBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span>提交
					</button>
				</div>

			</div>
		</div>

	</div>

</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/handler.js" type="text/javascript"></script>
<script type="text/javascript">
$(function () {
	//初始化业务逻辑script
    handler.goods.init({});
    // 绑定事件，用刚才看的那个on方法
    // 第一个参数，事件名
    // 第二个参数，可以省略，也可以写(不写就要省略)
    // 第三个参数，就是这个事件发生时候，要做的事情
    $("#goodsAdd").on('click', function () {
        // 这个goodsAdd需要三个参数
		var title = $('input[name="title"]').val();
		var price = $('input[name="price"]').val();
		var number = $('input[name="number"]').val();
		handler.goodsAdd(title,price,number);
	});
})
</script>
</html>