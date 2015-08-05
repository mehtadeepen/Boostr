<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='/boostr/css/bootstrap.min.css'>
<link rel='stylesheet' href='/boostr/css/bootstrap-theme.min.css'>

<script src='/boostr/js/jquery.js'></script>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src='/boostr/js/bootstrap.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Boostr</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" style="
    height: 30px;
    width: 30px;
" src="/boostr/img/logo.png">
      </a>
      <a class="navbar-brand" href="#">
       Boostr
      </a>
    </div>
  </div>
</nav>

    <div class='container' style="padding: 50px ;">
        <div class='text-center row'>
            <h1> Boostr </h1>
            
        </div>
         <div class='text-center row'>
            <p>Welcome to Boostr! 
            Boostr is a new mobile-friendly website that 
            provides the younger generation of adults a place to find personalized 
            information on finances. We get to know you through our 
            initial financial-personality quiz and the goals you set. 
            Based on your personality, interests, and goals, 
            Boostr gives you a personalized list of articles 
            written by experts. Have fun learning, achieving your goals, and making money!
            </p>
        </div>
        <div class='text-center row'>
           <img src='/boostr/img/logo.png'/>
        </div>
        <div class='text-center row'>
<<<<<<< Updated upstream
            <a class='btn btn-default' href='/boostr/q1.jsp' role='button' id='start_btn'> Get Started </a>
=======
            <a class='btn btn-default' href='q1.jsp' role='button' id='start_btn'> Get Started </a>
>>>>>>> Stashed changes
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
