<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Beauty商城</title>
    <style>
        body {
            background: #FFF;
            font-family: "Open Sans", "Arial";
        }
        main {
            background: #FFF;
            width: 95%;
            margin: 10px auto;
            padding: 5px 30px 80px;
            box-shadow: 0 3px 5px #FFF;
        }
        p {
            font-size: 13px;
        }
        input, section {
            clear: both;
            padding-top: 10px;
            display: none;
        }
        label {
            font-weight: bold;
            font-size: 14px;
            display: block;
            float: left;
            padding: 10px 30px;
            border-top: 2px solid transparent;
            border-right: 1px solid transparent;
            border-left: 1px solid transparent;
            border-bottom: 1px solid #DDD;
        }
        label:hover {
            cursor: pointer;
            text-decoration: underline;
        }
        #tab1:checked ~ #content1, #tab2:checked ~ #content2, #tab3:checked ~ #content3, #tab4:checked ~ #content4 , #tab5:checked ~ #content5{
            display: block;
        }
        input:checked + label {
            border-top-color: #FFB03D;
            border-right-color: #DDD;
            border-left-color: #DDD;
            border-bottom-color: transparent;
            text-decoration: none;
        }
    </style>

</head>

<body>

<main>
    <h2>Beauty商城首页</h2>
    <input id="tab1" type="radio" name="tabs" checked>
    <label for="tab1">Goods</label>
    <input id="tab2" type="radio" name="tabs">
    <label for="tab2">Orders</label>
    <input id="tab3" type="radio" name="tabs">
    <label for="tab3">Users</label>
    <input id="tab4" type="radio" name="tabs">
    <label for="tab4">Mine</label>
    <input id="tab5" type="radio" name="tabs">
    <label for="tab5">API</label>
    <section id="content1">
        <iframe src="/goods/list" width="100%" height="1000px" scrolling="yes" frameborder="0"></iframe>
    </section>
    <section id="content2">
        <iframe src="/orders/list" width="100%" height="1000px" scrolling="yes" frameborder="0"></iframe>
    </section>
    <section id="content3">
        <iframe src="/user/list" width="100%" height="1000px" scrolling="yes" frameborder="0"></iframe>
    </section>
    <section id="content4">
        <iframe src="/user/login" width="100%" height="1000px" scrolling="yes" frameborder="0"></iframe>
    </section>
    <section id="content5">
        <iframe src="/user/misc" width="100%" height="1000px" scrolling="yes" frameborder="0"></iframe>
    </section>
</main>

</body>

</html>