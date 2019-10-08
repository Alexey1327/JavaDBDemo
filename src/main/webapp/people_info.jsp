<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>People Info</title>
    <style type="text/css">
        td {
            vertical-align: top;
        }
    </style>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Инфо</h2>
<table border="1px">
    <tr>
        <td>Пипл</td>
        <td>Квартиры</td>
    </tr>
    <c:forEach items="${peopleList}" var="people">
        <tr>
            <td>${people.toString()}</td>
            <td>${people.getAddressesAsString()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
