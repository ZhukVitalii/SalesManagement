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
        <div class="col-md-8">
            <c:forEach items="${products}" var="product">
                    <div class="cart-info">
                        <div class="cart-image">
                            <img src="${product.image}"/>
                        </div>
                        <div class="cart-item-info">
                            <h3>${product.name}</h3>
                            <p><label>id = </label>${product.id}</p>
                            <p>${product.price}<label>грн</label></p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
            </c:forEach>
    </div>
    <div class="col-md-4">
        <form role="form"
              action="/getReceipt"
              method="post">
            <div class="user" novalidate>
                <div class="user-input">
                    <h3> Введіть прізвище та ім'я:</h3>
                    <input class="input-box"
                           id="username"
                           type="text"
                           name="name"
                           placeholder="ПІБ"
                           required/>
                    <br>
                </div>
                <div class="user-input">
                    <h3>Ваш E-mail:</h3>
                    <input class="input-box"
                           id="email"
                           type="email"
                           name="email"
                           placeholder="Е-mail"
                           required/>
                    <br>
                </div>
                    <div class="account">
                        <div class="btn_form">
                            <button type="submit"
                                    name="confirm"
                                    value="Confirm"
                                    >Оформити замовлення
                            </button>
                        </div>
                    </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
