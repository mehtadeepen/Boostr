package com.intuit.honeybadgers.boostr.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intuit.honeybadgers.boostr.db.tables.*;
import com.intuit.honeybadgers.boostr.models.Category;
import com.intuit.honeybadgers.boostr.models.User;
import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.sql.dml.SQLUpdateClause;
import com.mysema.query.sql.mysql.MySQLQuery;

public class UserStore {
	private final String connectionLocation = "jdbc:mysql://localhost:3306/boostr";
	private final String connectionUser = "root";

	public User getUser(String uuid) throws SQLException {
		Connection connection = DriverManager.getConnection( connectionLocation, connectionUser, "" );
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			QDbCategoryData qcategorydata = new QDbCategoryData( "cd" );
			MySQLQuery query = new MySQLQuery( connection );

			List<DbCategoryData> data = query.from( qcategorydata )
							   		   		 .where( qcategorydata.user.eq( uuid ) )
							   		   		 .list( qcategorydata );

			Map<Category, Float> userData = new HashMap<>();
			for( DbCategoryData cdata : data ) {
				userData.put( Category.valueOf( cdata.getName() ), cdata.getValue() );
			}

			return new User( uuid, userData );
		} catch( ClassNotFoundException e ) {
			e.printStackTrace();
		}

		// If we're here, there's no user in the DB so we need to create one
		DbUser user = new DbUser();
		user.setUuid( uuid );

		QDbUser quser = new QDbUser( "u" );
		QDbCategoryData qcategorydata = new QDbCategoryData( "cd" );

		SQLInsertClause insert = new SQLInsertClause( connection, new MySQLTemplates(), quser );
		insert.populate( user ).execute();

		Map<Category, Float> userPrefs = new HashMap<>();

		for( Category c : Category.values() ) {
			userPrefs.put( c, 0.0f );

			DbCategoryData data = new DbCategoryData();
			data.setName( c.name() );
			data.setUser( uuid );
			data.setValue( 0.0f );

			SQLInsertClause insertData = new SQLInsertClause( connection, new MySQLTemplates(), qcategorydata );
			insertData.populate( data ).execute();
		}

		return new User( uuid, userPrefs );
	}

	public void updateUserPrefs( String uuid, Map<Category, Float> newPrefs ) {
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			QDbCategoryData qcategorydata = new QDbCategoryData( "cd" );
			Connection connection = DriverManager.getConnection( connectionLocation, connectionUser, "" );
			MySQLQuery query = new MySQLQuery( connection );

			for( Category c : newPrefs.keySet() ) {
				DbCategoryData oldPrefs = query.from( qcategorydata )
											   .where( qcategorydata.user.eq( uuid ).and( qcategorydata.name.eq( c.name() ) ) )
											   .limit( 1 )
											   .uniqueResult( qcategorydata );

				if( oldPrefs == null ) {
					SQLInsertClause insert = new SQLInsertClause( connection, new MySQLTemplates(), qcategorydata );
					insert.set( qcategorydata.value, newPrefs.get( c ) )
						  .set( qcategorydata.name, c.name() )
 						  .set( qcategorydata.user, uuid )
						  .execute();
				} else {
					SQLUpdateClause update = new SQLUpdateClause( connection, new MySQLTemplates(), qcategorydata );

					update.where( qcategorydata.user.eq( uuid ).and( qcategorydata.name.eq( c.name() ) ) )
						  .set( qcategorydata.value, oldPrefs.getValue() + newPrefs.get( c ) )
						  .execute();
				}
			}
		} catch( SQLException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
}
