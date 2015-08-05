package com.intuit.honeybadgers.boostr.server;

import com.google.common.base.Functions;
import com.google.common.collect.Ordering;
import com.intuit.honeybadgers.boostr.models.Article;
import com.intuit.honeybadgers.boostr.models.Category;
import com.intuit.honeybadgers.boostr.models.User;
import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.*;
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
    public Viewable getArticles( @QueryParam( "uuid" ) String uuid ) {
        Map<String, Object> model = new HashMap<>();
        Map<String, List<Article>> allArticles = new HashMap<>();

        if( uuid == null ) {
            // Return all articles of all categories

            for( Category c : Category.values() ) {
                allArticles.put( c.name(), articleStore.getArticlesByCategory( c ) );
            }

        } else {
            // Return articles for a specific user
            User user = userStore.getUser( uuid );
            Map<Category, Float> userPrefs = user.getInterests();

            List<Category> sortedPrefs = new ArrayList<>();
            sortedPrefs = Ordering.natural().onResultOf( Functions.forMap( userPrefs ) ).sortedCopy( sortedPrefs );

            List<Article> articles = new ArrayList<>();

            for( int i = 0; i < 2; i++ ) {
                articles.addAll( articleStore.getArticlesByCategory( sortedPrefs.get( i ) ) );
            }

            allArticles.put( "Just for You", articles );
        }

        model.put( "articles", allArticles );
        return new Viewable( "/ArticlesView", model );
    }

    @POST
    @Path( "answer" )
    @Consumes( MediaType.APPLICATION_JSON )
    public void setAnswers( @QueryParam( "uuid" ) String uuid, Map<Category, Float> responses ) {
        userStore.updateUserPrefs( uuid, responses );
    }
}
