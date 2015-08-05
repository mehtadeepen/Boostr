<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='/boostr/css/bootstrap.min.css'>
<link rel='stylesheet' href='/boostr/css/bootstrap-theme.min.css'>
<script src='/boostr/js/bootstrap.min.js'></script>
<script src='/boostr/js/jquery.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Boostr</title>
</head>
<body>
    <div class='container'>
        <div class='text-center row'>
            <h1> Boostr </h1>
        </div>
        <div class='text-center row'>
           <img src='/boostr/img/logo.png'/>
        </div>
        <div class='text-center row'>
            <a class='btn btn-default' href='/boostr/q1.jsp' role='button' id='start_btn'> Get Started </a>
        </div>
    </div>
    <script type='text/javascript'>
        $('#start_btn').click(function() {
            uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
                var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
                return v.toString(16);
            });
            document.cookie = 'user_id=' + uuid;
        });
    </script>
</body>
</html>
