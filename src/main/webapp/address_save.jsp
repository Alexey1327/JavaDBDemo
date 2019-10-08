<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <title>Сохранение адресов</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Адреса</h2>

<script type="text/javascript">
    $(document).on('submit','#adress-form', function(event){
        event.preventDefault();
        var form_data = $(this).serialize();
        $.ajax({
            type: "POST",
            url: "address_save",
            data: form_data,
            success: function(result){
                $("#result").html(result);
                $("#input-city").val("");
                $("#input-street").val("");
                $("#input-house").val("");
                $("#input-flat").val("");
            },
            error: function(xhr){
                $("#result").html(xhr.responseText);
            }
        });
    });
</script>

<form id="adress-form" method="post">
    <p>
        <label>
            <select name="people_id">
                <c:forEach items="${peopleList}" var="people">
                    <option value="${people.getId()}">${people.getFirstName()}</option>
                </c:forEach>
            </select>
        </label>
    </p>
    <label>
        <input id="input-city" type="text" name="city" placeholder="City" required />
    </label>
    <label>
        <input id="input-street" type="text" name="street" placeholder="Street" required/>
    </label>
    <label>
        <input id="input-house" type="text" name="house" placeholder="House" required/>
    </label>
    <label>
        <input id="input-flat" type="text" name="flat" placeholder="Flat number" pattern="[0-9]{,5}"/>
    </label>
    <button type="submit">Save</button>
</form>
<div id="result"></div>

</body>
</html>
