<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">

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
<body>
<div class="container">
    <div class="col-md-8 col-md-offset-2 clearfix">
        <div class="well">
        <h3>
        Question 1 of 8
        </h3>
            <p class="text-justify text-center"> You're going out to
             dinner with friend. 
             Do you ... ? </p>
        </div>
<div id="slider">
    <div class="pull-right">
        <p> I feel lost </p>
    </div>
    <div class="pull-left">
        <p> I feel horrible </p>
    </div>
    <br/>
    <div align="center">
     <span id="slider-value"></span>
    </div>
       
</div>
    </div>
    </div>
</body>
</html>