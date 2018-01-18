<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>个人中心</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>个人中心</h2>
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
                    <td><c:if test="${mine.userId==0}">用户不存在</c:if> <c:if test="${mine.userId!=0}">${mine.userId}</c:if></td>
                    <td>${mine.userName}</td>
                    <td>${mine.userPhone}</td>
                    <td>${mine.score}</td>
                    <td><fmt:formatDate value="${mine.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>
</body>
</html>