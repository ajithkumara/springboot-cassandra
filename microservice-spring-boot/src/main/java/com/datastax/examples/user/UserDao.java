package com.datastax.examples.user;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;

public class UserDao {
	
	 private PreparedStatement insertUser;
	 private CqlSession session;
	 
	 private static final String usersTableName = "users";
	 
	 public UserDao(CqlSession session, String keyspace, String localDataCenter, String isAstra) {
		 this.session = session;
		 maybeCreateUsersSchema(keyspace, localDataCenter, isAstra);
		 this.insertUser = session.prepare(getInsertUserStmt(keyspace));
		 
		 
	 }
	 
	 private void maybeCreateUsersSchema(String keyspace, String localDataCenter, String isAstra) {
	        if (isAstra.equals("none")){
	            session.execute(String.format("" +
	                    "CREATE KEYSPACE IF NOT EXISTS %s WITH REPLICATION = {'class': 'NetworkTopologyStrategy', '%s': 1};",
	                    keyspace, localDataCenter));
	        }
	        session.execute(String.format("CREATE TABLE IF NOT EXISTS %s.%s (username text, nic uuid , "+
	                "  PRIMARY KEY ((username), nic));", keyspace, usersTableName));
	    
		 
	 }
	 
	 private String getInsertUserStmt(String keyspace){
	        return String.format("" +
	                "INSERT INTO %s.%s (username, nic) " +
	                "VALUES (?,?);", keyspace, usersTableName);
	 }
	 public void addUser(User user) {
		 session.execute(insertUser.bind(user.getUsername(), user.getNic()));
	 }

}
