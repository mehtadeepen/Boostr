package com.intuit.honeybadgers.boostr.db.tables;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QCategory extends com.mysema.query.sql.RelationalPathBase<Category> {

    private static final long serialVersionUID = -1179593503;

    public static final QCategory category = new QCategory("category");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> user = createNumber("user", Integer.class);

    public final NumberPath<Long> value = createNumber("value", Long.class);

    public final com.mysema.query.sql.PrimaryKey<Category> primary = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<User> userFk = createForeignKey(id, "uuid");

    public QCategory(String variable) {
        super(Category.class, forVariable(variable), "null", "category");
    }

    @SuppressWarnings("all")
    public QCategory(Path<? extends Category> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "category");
    }

    public QCategory(PathMetadata<?> metadata) {
        super(Category.class, metadata, "null", "category");
    }

}

