package com.intuit.honeybadgers.boostr.db.tables;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDbUser is a Querydsl query type for DbUser
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QDbUser extends com.mysema.query.sql.RelationalPathBase<DbUser> {

    private static final long serialVersionUID = -969231860;

    public static final QDbUser dbUser = new QDbUser("db_user");

    public final StringPath uuid = createString("uuid");

    public final com.mysema.query.sql.PrimaryKey<DbUser> primary = createPrimaryKey(uuid);

    public final com.mysema.query.sql.ForeignKey<DbCategoryData> _userFk = createInvForeignKey(uuid, "user");

    public QDbUser(String variable) {
        super(DbUser.class, forVariable(variable), "null", "db_user");
    }

    @SuppressWarnings("all")
    public QDbUser(Path<? extends DbUser> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "db_user");
    }

    public QDbUser(PathMetadata<?> metadata) {
        super(DbUser.class, metadata, "null", "db_user");
    }

}

