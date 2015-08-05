package com.intuit.honeybadgers.boostr.server;

import com.google.common.base.Functions;
import com.google.common.collect.Ordering;
import com.intuit.honeybadgers.boostr.models.Article;
import com.intuit.honeybadgers.boostr.models.Category;
import com.intuit.honeybadgers.boostr.models.User;
import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
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
    public List<Article> getArticles( @QueryParam( "uuid" ) String uuid, @QueryParam( "category" ) Category category ) {
        if( category != null ) {
            // Return all articles of the specified category

            return articleStore.getArticlesByCategory( category );
        } else {
            // Return articles for a specific user
            User user = null;
            try {
                user = userStore.getUser( uuid );
                Map<Category, Float> userPrefs = user.getInterests();

                List<Category> sortedPrefs = new ArrayList<>();
                sortedPrefs = Ordering.natural().onResultOf( Functions.forMap( userPrefs ) ).sortedCopy( sortedPrefs );

                List<Article> articles = new ArrayList<>();

                for( int i = 0; i < Math.min( 3, sortedPrefs.size() ); i++ ) {
                    articles.addAll( articleStore.getArticlesByCategory( sortedPrefs.get( i ) ) );
                }

                if( articles.size() == 0 ) {
                    articles.addAll( articleStore.getArticlesByCategory( Category.Interest ) );
                }

                return articles;
            } catch( SQLException e ) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @POST
    @Path( "answer" )
    @Consumes( MediaType.APPLICATION_JSON )
    public void setAnswers( @QueryParam( "uuid" ) String uuid, AnswerRequest responses ) {
        userStore.updateUserPrefs( uuid, responses.getData() );
    }
}
