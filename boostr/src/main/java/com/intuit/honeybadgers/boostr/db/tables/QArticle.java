package com.intuit.honeybadgers.boostr.db.tables;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QArticle extends com.mysema.query.sql.RelationalPathBase<Article> {

    private static final long serialVersionUID = 2137435315;

    public static final QArticle article = new QArticle("article");

    public final StringPath category = createString("category");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath url = createString("url");

    public final com.mysema.query.sql.PrimaryKey<Article> primary = createPrimaryKey(id);

    public QArticle(String variable) {
        super(Article.class, forVariable(variable), "null", "article");
    }

    @SuppressWarnings("all")
    public QArticle(Path<? extends Article> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "article");
    }

    public QArticle(PathMetadata<?> metadata) {
        super(Article.class, metadata, "null", "article");
    }

}

