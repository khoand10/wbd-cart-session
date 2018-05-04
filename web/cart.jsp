<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 04/05/2018
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Cart</title>
</head>
<body>
    <h1>Your cart</h1>
    <a href="/index">go to shop</a>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Delete</th>
    </tr>
    <form action="/removeToCart" method="post">
        <c:forEach items="${sessionScope.carts}" var="product">
            <tr>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <th><input type="text" name="amount" value="0"></th>
                <th><input type="checkbox" value="${product.getId()}" name="delete"></th>
            </tr>
        </c:forEach>
        <button>remove</button>
    </form>
</table>
</body>
</html>
