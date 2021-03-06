package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.db.tables.DbArticle;
import com.intuit.honeybadgers.boostr.db.tables.QDbArticle;
import com.intuit.honeybadgers.boostr.models.Article;
import com.intuit.honeybadgers.boostr.models.Category;
import com.mysema.query.sql.mysql.MySQLQuery;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ddubois
 */

public class ArticleStore {
    private final String connectionLocation = "jdbc:mysql://localhost:3306/boostr";
    private final String connectionUser = "root";

    private List<Article> allArticles;

    public List<Article> getArticlesByCategory( Category majorCategory ) {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            MySQLQuery query = new MySQLQuery( DriverManager.getConnection( connectionLocation, connectionUser, "" ) );
            QDbArticle qarticle = new QDbArticle( "a" );

            List<DbArticle> dbArticles = query.from( qarticle )
                                              .where( qarticle.category.eq( majorCategory.name() ) )
                                              .list( qarticle );

            List<Article> returnedArticles = new ArrayList<>();

            for( DbArticle a : dbArticles ) {
                returnedArticles.add( new Article( new URI( a.getUrl() ), a.getAuthor(), Category.valueOf( a.getCategory() ), a.getTitle() ) );
            }

            return returnedArticles;
        } catch( SQLException | URISyntaxException | ClassNotFoundException e ) {
            e.printStackTrace();
        }

        return null;
    }
}
