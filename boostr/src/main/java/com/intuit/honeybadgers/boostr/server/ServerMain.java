package com.intuit.honeybadgers.boostr.server;

import com.google.common.base.Functions;
import com.google.common.collect.Ordering;
import com.intuit.honeybadgers.boostr.models.Article;
import com.intuit.honeybadgers.boostr.models.Category;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * @author ddubois
 */
@Path( "/" )
public class ServerMain {
    private ArticleStore articleStore = new ArticleStore();
    private UserStore userStore = new UserStore();
    
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
        User user = userStore.getUserByUUID( uuid );
        Map<Category, Double> userPrefs = user.getInterests();

        List<Category> sortedPrefs = new ArrayList<>();
        sortedPrefs = Ordering.natural().onResultOf( Functions.forMap( userPrefs ) ).sortedCopy( sortedPrefs );

        List<Article> articles = new ArrayList<>();

        for( int i = 0; i < 2; i++ ) {
            articles.addAll( articleStore.getArticlesByCategory( sortedPrefs.get( i ) ) );
        }

        return articles;
    }

    @GET
    @Path( "articles" )
    @Produces( MediaType.APPLICATION_JSON )
    public List<Article> getArticles( @QueryParam( "category" ) Category category ) {
        // Return all articles of a given category
        return articleStore.getArticlesByCategory( category );
    }
}
