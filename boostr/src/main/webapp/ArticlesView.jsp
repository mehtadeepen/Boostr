<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Articles</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/cokies/js"></script>
    <script type="text/javascript">
function fillArticleList( data, status ) {
    var articleList = document.getElementById( "articlesList" );
    for( var article : data ) {
        var newArticleElement = document.createElement( "li" );
        
    }
}

function loadPersonalizedArticles() {
    var cookie = docCookies.getItem( "user_id" );
    $.get( "/articles?uuid=" +cookie, fillArticleList );
}
    </script>
</head>
<body onload="loadPersonalizedArticles()">
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
