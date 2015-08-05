<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.intuit.honeybadgers.boostr.server.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
.ui-slider { margin-top: 20px }
.pull-left {float : left !important;
             margin-left : 10px;
             margin-top: 20px;}
.pull-right {float : right !important;
             margin-right : 10px;
             margin-top: 20px;}
</style>
  <script src="js/cookies.js"></script>
<script type="text/javascript">

function setValues() {
	
	var sliderValue = $('#slider').slider('value');
	$('#val').val(sliderValue);
	
	alert($('#val').val());
	var cookie = docCookies.getItem( "user_id" );
	$('#uid').val(cookie);
	
	$('#q6').submit();
	
}

$( document ).ready(function() {
	$("#slider").slider(
			{
			            value:50,
			            min: 0,
			            max: 100,
			            step: 1,
			            slide: function( event, ui ) {
			                $( "#slider-value" ).html( ui.value );
			            }
			}
			);
	
	$( "#slider-value" ).html(  $('#slider').slider('value') );
});



</script>
</head>
<%

String answer1 = (String)request.getParameter("val");

Integer sliderValue = Integer.parseInt(answer1);

String uuid = (String) request.getParameter("uid");

System.out.println(answer1);

Util util = new Util();

util.postSlider(sliderValue, uuid);


%>
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
            <h1> Personalized Question </h1>
            
        </div>
        </div>
<div class="container">
    <div class="col-md-8 col-md-offset-2 clearfix">
        <div class="">
        <h3>
        Question 6 of 8
        </h3>
            <p class="text-justify text-center"> What are you doing in two months ?
              </p>
       
<div id="slider">
    <div class="pull-right">
        <p> Let me check my calendar </p>
    </div>
    <div class="pull-left">
        <p> I could be anywhere </p>
    </div>
    <br/>
    <div align="center">
     <span id="slider-value"></span>
    </div>
       
</div>
    </div>
    <br/>
    <form class="form" id="q6" name="q6" action="q7.jsp" method="post">
    <input type="hidden" name="uid" id="uid" value=""></input>
    <input type="hidden" name="val" id="val" value=""></input>
    <input type="hidden" name="que1" id="que1" value=""></input>
    <br>
    <input type="button" value="Next" class="btn btn-warning" onclick="setValues();"></input>
    </form>
     </div>
    </div>
</body>
</html>
