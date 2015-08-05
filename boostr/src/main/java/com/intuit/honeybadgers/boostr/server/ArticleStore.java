package com.intuit.honeybadgers.boostr.server;

import java.util.ArrayList;

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
