<%@ page import="com.intuit.honeybadgers.boostr.models.Article" %>
<%@ page import="com.intuit.honeybadgers.boostr.models.Category" %>
<%@ page import="com.sun.jersey.api.client.Client" %>
<%@ page import="com.sun.jersey.api.client.WebResource" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: ddubois
  Date: 8/5/15
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Initialize web client -->
<%
  Client client = Client.create();
  WebResource getArticles = client.resource( "http://localhost:8080/boostr/articles" );
  // get UUID
  String uuid = null;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Articles</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js">
</head>
<body>
<!-- Some sort of header maybe -->

<div class="jumbotron">
<div class="container">
  <div class="row">
    </div>  <div class="col-md-2">
      <!-- Navigation sidebar -->
    </div>

    <div class="col-md-4" id="categoryArticles">
      <%for( Category c : Category.values() ) { %>
        <div class="row">
          <h2><% c.name(); %></h2>
          <%
      List<Article> articles = getArticles.queryParam( "category", c.name() ).get( List.class );
          %>
          <ul>
          <% for( Article a : articles ) { %>
            <li>
              <a href="<% a.getLocation(); %>"><% a.getLocation(); %></a> by <% a.getAuthor(); %>
            </li>
            <% } %>
          </ul>
        </div>
      <% } %>
    </div>

    <div class="col-md-4" id="suggestedArticles">
      <h2>Suggested for you</h2>
      <ul>
        <%
      List<Article> personalArticles = getArticles.queryParam( "uuid", uuid ).get( List.class );
      for( Article a : personalArticles ) {
        %>
        <li>
          <a href="<% a.getLocation(); %>"><% a.getLocation(); %></a> by <% a.getAuthor(); %>
        </li>
        <% } %>
      </ul>
    </div>
  </div>
</div>
</div>

</body>
</html>
