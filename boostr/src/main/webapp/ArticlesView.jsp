<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
        $('#articleList').append($('<li></li>'));
        
    }
}

function loadPersonalizedArticles() {
    console.log("TEST");
    var cookie = docCookies.getItem( "user_id" );
    $.get( "server/articles?uuid=" +cookie, fillArticleList );
}

$(document).ready(loadPersonalizedArticles);
    </script>
</head>
<body >
<!-- Some sort of header maybe -->

<div class="jumbotron">
<div class="container">
  <div class="row">
    </div>
    <div class="col-md-2">
      <!-- padding -->
    </div>

    <div class="col-md-8" id="suggestedArticles">
      <h2>Suggested for you</h2>
      <ul id="articlesList">
      </ul>
    </div>
  </div>
</div>
</div>

</body>
</html>
