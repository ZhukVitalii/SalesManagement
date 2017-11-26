<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <script src="resources/js/main.js" type="text/javascript"></script>
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>


</head>
<body>

<div class="cart">
    <div class="container">
        <h2>Всі замовлення:</h2>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <tr>
                    <th>ID:</th>
                    <th>ID товару</th>
                    <th>Покупець</th>
                    <th>Почта покупця</th>
                    <th>Дата придбання</th>
                </tr>
                <c:forEach items="${productsInReseipts}" var="productsInReseipt">
                <tr>
                    <td>${productsInReseipt.receipt_id}</td>
                    <td>${productsInReseipt.product_id}</td>
                    <td>${productsInReseipt.name}</td>
                    <td>${productsInReseipt.email}</td>
                    <td>${productsInReseipt.data}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>