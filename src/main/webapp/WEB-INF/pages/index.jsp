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
    <div class="container">
        <div class="col-md-9">
                <c:forEach items="${products}" var="product">
                        <div class="product-info">
                            <div class="product-image">
                                <img src="${product.image}"/>
                            </div>
                            <div class="product-item-info">
                                        <h3>${product.name}</h3>
                                <p><label>id = </label>${product.id}</p>
                                <p>${product.price}<label>грн</label></p>
                                <div class="btn_form">
                                    <button type="button" onclick="addToCart(${product.id}) " >Додати до корзини</button>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                </c:forEach>
        </div>
        <div class="col-md-3">
            <div class="btn_form btn-to-cart">
                <button type="button" onclick="goToCart()">Перейти до корзини</button>
            </div>
        </div>
    </div>
</body>
</html>