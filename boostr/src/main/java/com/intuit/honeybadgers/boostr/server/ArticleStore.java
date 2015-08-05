package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.db.tables.QArticle;
import com.intuit.honeybadgers.boostr.models.Article;
import com.intuit.honeybadgers.boostr.models.Category;
import com.mysema.query.sql.mysql.MySQLQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddubois
 */
public class ArticleStore {
    private List<Article> allArticles;

    public List<Article> getArticlesByCategory( Category majorCategory ) {
        QArticle qarticle = new QArticle( "a" );

        MySQLQuery query = new MySQLQuery(  )

        List<Article> returnedArticles = new ArrayList<>();

        for( Article a : allArticles ) {
            if( a.getCategory() == majorCategory ) {
                returnedArticles.add( a );
            }
        }

        return returnedArticles;
    }
}
