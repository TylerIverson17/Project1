package Well;

import java.sql.*;
import java.util.*;

public class Meta {

	
	
	static Connection connection = null;
	static DatabaseMetaData metadata = null;
	
	// Static block for initialization
	public Meta() {
	connection = DBconnection.newConnection();
	
	try {
		metadata = connection.getMetaData();
	} catch (SQLException e) {
		System.err.println("There was an error getting the meta data: " + e.getMessage());
	}
	}

	
	public void printGeneralMetadata() throws SQLException {
		
		System.out.println("Database Product Name: "
				+ metadata.getDatabaseProductName());
		System.out.println("Logged User: "
				+ metadata.getUserName());
		System.out.println("JDBC Driver: " 
				+ metadata.getDriverName());
		System.out.println("\n");
		
	}
	
	public  ArrayList<String> getTableMetadata() throws SQLException  {
		String table[] = {"TABLE"};
		ResultSet rs = null;
		ArrayList<String> tables = null;
		// recieve the Type of the object in a String array.
		rs = metadata.getTables(null, null, "%", table);
		tables = 
		new ArrayList<String>();
		while (rs.next()) {
			tables.add(rs.getString("TABLE_NAME"));
			System.out.println(rs.getString("TABLE_NAME"));
			System.out.println(rs.getMetaData());
		}
		return tables;
	}
	
	
	/*
	 * returns arraylist with the table's name
	 */
	
	
	
	
	
}
