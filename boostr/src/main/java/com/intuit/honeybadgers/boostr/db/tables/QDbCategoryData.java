package com.intuit.honeybadgers.boostr.db.tables;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDbCategoryData is a Querydsl query type for DbCategoryData
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QDbCategoryData extends com.mysema.query.sql.RelationalPathBase<DbCategoryData> {

    private static final long serialVersionUID = -1080137975;

    public static final QDbCategoryData dbCategoryData = new QDbCategoryData("db_category_data");

    public final StringPath name = createString("name");

    public final StringPath user = createString("user");

    public final NumberPath<Float> value = createNumber("value", Float.class);

    public final com.mysema.query.sql.PrimaryKey<DbCategoryData> primary = createPrimaryKey(name, user);

    public final com.mysema.query.sql.ForeignKey<DbUser> userFk = createForeignKey(user, "uuid");

    public QDbCategoryData(String variable) {
        super(DbCategoryData.class, forVariable(variable), "null", "db_category_data");
    }

    @SuppressWarnings("all")
    public QDbCategoryData(Path<? extends DbCategoryData> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "db_category_data");
    }

    public QDbCategoryData(PathMetadata<?> metadata) {
        super(DbCategoryData.class, metadata, "null", "db_category_data");
    }

}

