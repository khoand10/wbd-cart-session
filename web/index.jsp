<%--
  Created by IntelliJ IDEA.
  User: dangkhoa
  Date: 04/05/2018
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop O</title>
</head>
<body>
<a href="cart.jsp">Your Cart</a>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Buy</th>
    </tr>
    <form action="/addToCart" method="post">
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <th><input type="text" name="amount" value="0"></th>
                <th><input type="checkbox" value="${product.getId()}" name="buy"></th>
            </tr>
        </c:forEach>
        <button>Add to Cart</button>
    </form>
</table>
</body>
</html>
