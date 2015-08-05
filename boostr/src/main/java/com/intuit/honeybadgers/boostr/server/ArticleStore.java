package com.intuit.honeybadgers.boostr.server;

import com.intuit.honeybadgers.boostr.models.Article;
import com.intuit.honeybadgers.boostr.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ddubois
 */
public class ArticleStore {
    private List<Article> allArticles;

    public List<Article> getArticlesByCategory( Category majorCategory ) {
        List<Article> returnedArticles = new ArrayList<>();

        for( Article a : allArticles ) {
            if( a.getCategory() == majorCategory ) {
                returnedArticles.add( a );
            }
        }

        return returnedArticles;
    }
}
