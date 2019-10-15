<%--
  Created by IntelliJ IDEA.
  User: duongnam
  Date: 15/10/2019
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Products</title>
</head>
<body>
<%--<div>${productList[1].name}</div>--%>
<table border="1" cellpadding="5" cellspacing="5" >
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.productID}</td>
            <td>${product.name}</td>
            <td>${product.quantity}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td>
        <a href="product.do?page=${currentPage - 1}">Previous</a>
    </td>
</c:if>

<%-- For displaying Page numbers. The when condition does not display a link for the current page --%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="product.do?page=${i}">${i}</a> </td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<%-- For displaying Page numbers. The when condition does not display a link for the current page --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="product.do?page=${currentPage + 1}">Next</a> </td>
</c:if>
</body>
</html>