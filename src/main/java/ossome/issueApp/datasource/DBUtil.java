package ossome.issueApp.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	
	public DBUtil() {}
	
	 public List<String> testDB() {
		 
		 List<String> myList = new ArrayList<String>();
		 
		   Context ctx = null;
		   Connection conn = null;
		   ResultSet rs = null;
		 
		   try {
		     ctx = new InitialContext();
		     
		     DataSource ds = (DataSource)  ctx.lookup("SmallCellApplicationDataSource");
		     
		     conn = ds.getConnection();
		     
		     PreparedStatement stmt =   conn.prepareStatement("select message from test_table");
		     
		     rs =stmt.executeQuery();
		     
		     while(rs.next())
		     
		     	myList.add(rs.getString("country_name"));
		   }
		   
		                  catch (NamingException e) {
		     e.printStackTrace();
		   }
		 
		                  catch (SQLException e) {
		 e.printStackTrace();
		   }
		 
		   finally {
		 
		     try {
		     	conn.close();
		     	rs.close();
		     	ctx.close();
		     }
		     catch (Exception e) {
		     	e.printStackTrace();
		     }
		 
		   }
		   
		   return myList;
		 }
}
