<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         <%@ page import="com.intuit.honeybadgers.boostr.server.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Articles</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/cookies.js"></script>
    <script type="text/javascript">
function fillArticleList( data, status ) {
    console.log(data)
    var articleList = document.getElementById( "articlesList" );
    for( var i=0; i < data.length; i++ ) {
        article = $('<div class="row"> <a href=' + data[i].location + '>' + data[i].title + '</a><br>' +
                    'by: <i>' + data[i].author + '</div>');
        $('#articlesList').append(article);
    }
}

function loadPersonalizedArticles() {
    var cookie = docCookies.getItem( "user_id" );
    $.get( "server/articles?uuid=" +cookie, fillArticleList );
}

$(document).ready(loadPersonalizedArticles);
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
<body >
<!-- Some sort of header maybe -->

<div class="jumbotron">
    <div class='row'>
    <div class="col-md-2">
      <!-- padding -->
    </div>

    <div class="col-md-8" id="suggestedArticles">
      <h2>Suggested for you</h2>
    </div>
    </div>
</div>
<div class="container">
  <div class="row">
    <div id="articlesList"></div>
    <div class='row text-center'>
        <a class='btn btn-default' id='swith_btn' href='/boostr/CategoryList'> Browse by Category </a>
    </div>    
  </div>
</div>
</div>

</body>
</html>
