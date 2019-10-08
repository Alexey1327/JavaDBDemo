<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Database Demo</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Пиплы</h2>
<script type="text/javascript">
    $(function() {
        $('#datepicker').datepicker({ dateFormat: 'yy-mm-dd' });
    });
    $(document).on('submit','#people-form', function(event){
        event.preventDefault();
        var form_data = $(this).serialize();
        $.ajax({
            type: "POST",
            url: "people_save",
            data: form_data,
            success: function(result){
                $("#result").html(result);
            },
            error: function(xhr){
                $("#result").html(xhr.responseText);
            }
        });
    });
</script>

<form id="people-form" method="post">
    <label>
        <input type="text" name="first-name" placeholder="Enter your first name" required />
    </label>
    <label>
        <input type="text" name="middle-name" placeholder="Enter your middle name" required/>
    </label>
    <label>
        <input type="text" name="last-name" placeholder="Enter your last name" required/>
    </label>
    <label>
        <input id="datepicker" type="text" name="birth-date" placeholder="Enter your date of birth" required/>
    </label>
    <button type="submit">Save</button>
</form>

<div id="result"></div>

</body>
</html>
