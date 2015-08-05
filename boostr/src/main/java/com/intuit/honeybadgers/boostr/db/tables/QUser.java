package com.intuit.honeybadgers.boostr.db.tables;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QUser extends com.mysema.query.sql.RelationalPathBase<User> {

    private static final long serialVersionUID = -1055232722;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> uuid = createNumber("uuid", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<User> primary = createPrimaryKey(uuid);

    public final com.mysema.query.sql.ForeignKey<Category> _userFk = createInvForeignKey(uuid, "id");

    public QUser(String variable) {
        super(User.class, forVariable(variable), "null", "user");
    }

    @SuppressWarnings("all")
    public QUser(Path<? extends User> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "user");
    }

    public QUser(PathMetadata<?> metadata) {
        super(User.class, metadata, "null", "user");
    }

}

