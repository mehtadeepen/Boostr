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
var Cats = ['Loans', 'Interest', 'Savings', 'CreditCards', 'Retirement'];

function fillArticleList( data, elem ) {
    console.log(data)
    var articleList = document.getElementById( "articlesList" );
    for( var i=0; i < data.length; i++ ) {
        article = $('<div class="row"> <a href=' + data[i].location + '>' + data[i].title + '</a><br>' +
                    'by: <i>' + data[i].author + '</div>');
        elem.append(article);
    }
}

function loadArticles(cat) {
    $.get( "server/articles?category=" + cat, function(data) {
        fillArticleList(data, $('#'+cat));
    });
}

$(document).ready(function() {
    for (var i = 0; i < Cats.length; i++) {
        $('#articlesList').append($('<div id="' + Cats[i] + '" class="row"><h3>' + Cats[i] + '</h3></div>'));
    }
    for (var i = 0; i < Cats.length; i++) {
        loadArticles(Cats[i]);
    }
});
    </script>
</head>
<body >
<!-- Some sort of header maybe -->

<div class="jumbotron">
    <div class='row'>
    <div class="col-md-2">
      <!-- padding -->
    </div>

    <div class="col-md-8" id="Categories">
      <h2>Categories</h2>
    </div>
    </div>
</div>
<div class="container">
  <div class="row">
    <div id="articlesList"></div>
    <div class='row text-center'>
        <a class='btn btn-default' id='swith_btn' href='/boostr/ArticlesView'> Browse by Category </a>
    </div>    
  </div>
</div>
</div>

</body>
</html>
