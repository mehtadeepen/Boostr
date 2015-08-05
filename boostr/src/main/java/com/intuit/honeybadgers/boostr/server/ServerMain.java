package com.intuit.honeybadgers.boostr.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author ddubois
 */
@Path( "/" )
public class ServerMain {
    private ArticleStore articleStore = new ArticleStore();
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String basic() {
        return "Hello World";
    }

    @GET
    @Path( "articles" )
    @Produces( MediaType.APPLICATION_JSON )
    public List<Article> getArticles( @QueryParam( "uuid" ) String uuid ) {
        // Return articles for a specific user
    }

    @GET
    @Path( "articles" )
    @Produces( MediaType.APPLICATION_JSON )
    public List<Article> getArticles( @QueryParam( "category" ) Category category ) {
        // Return all articles of a given category
        return articleStore.getArticlesByCategory( category );
    }
}
