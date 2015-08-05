package com.intuit.honeybadgers.boostr.db.tables;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDbArticle is a Querydsl query type for DbArticle
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QDbArticle extends com.mysema.query.sql.RelationalPathBase<DbArticle> {

    private static final long serialVersionUID = 93639445;

    public static final QDbArticle dbArticle = new QDbArticle("db_article");

    public final StringPath author = createString("author");

    public final StringPath category = createString("category");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath url = createString("url");

    public final com.mysema.query.sql.PrimaryKey<DbArticle> primary = createPrimaryKey(id);

    public QDbArticle(String variable) {
        super(DbArticle.class, forVariable(variable), "null", "db_article");
    }

    @SuppressWarnings("all")
    public QDbArticle(Path<? extends DbArticle> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "db_article");
    }

    public QDbArticle(PathMetadata<?> metadata) {
        super(DbArticle.class, metadata, "null", "db_article");
    }

}

