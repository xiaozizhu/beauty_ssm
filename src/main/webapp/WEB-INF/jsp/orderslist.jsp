<%--
  Created by IntelliJ IDEA.
  User: such
  Date: 2017/9/14
  Time: 下午3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<html>
<head>
    <title>订单列表</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>订单列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>订单ID</td>
                    <td>用户ID</td>
                    <td>商品ID</td>
                    <td>买卖类型</td>
                    <td>创建时间</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orders" items="${orderslist}">
                    <tr>
                        <td>${orders.orderId}</td>
                        <td>${orders.userId}</td>
                        <td>${orders.goodsId}</td>
                        <td>${orders.title}</td>
                        <td>${orders.createTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

</body>
</html>
