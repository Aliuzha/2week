package ossome.issueApp.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ossome.issueApp.rest.model.Issue;


public class DBUtil {

	public DBUtil() {}

	public List<Issue> getAllIssues() {

		Context ctx = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Issue> issues = new ArrayList<Issue>();

		try {
			ctx = new InitialContext();

			DataSource ds = (DataSource)  ctx.lookup("SmallCellApplicationDataSource");

			conn = ds.getConnection();
			
			String sqlString = "SELECT * FROM ISSUE_ISSUEAP";
			
			PreparedStatement stmt =   conn.prepareStatement(sqlString);
			
			rs =stmt.executeQuery();
			
			String test = conn.getSchema();
			boolean isClose = conn.isClosed();
			
			while(rs.next()) {
				Issue tempIssue = new Issue();
				tempIssue.setId(rs.getLong("ID"));
				//tempIssue.setCreationDate(rs.getString("CREATION_DATE"));
				tempIssue.setIssueDescription(rs.getString("DESCRIPTION"));
				tempIssue.setResolutionComments(rs.getString("RESOLUTION_COMMENTS"));
				tempIssue.setProjectType(rs.getString("PROJECT_TYPE"));
				tempIssue.setActivityName(rs.getString("ACTIVITY_NAME"));
				tempIssue.setSystemName(rs.getString("SYSTEM_NAME"));
				tempIssue.setAuthor(rs.getString("AUTHOR"));
				tempIssue.setActivityStatus(rs.getString("ACTIVITY_STATUS"));
				tempIssue.setIssueType(rs.getString("ISSUE_TYPE"));
				issues.add(tempIssue);
			}
		
		}

		catch (NamingException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
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
		
		return issues;
	}	
	
	public boolean createIssue(Issue newIssue) {

		Context ctx = null;
		Connection conn = null;
		ResultSet rs = null;
		boolean created = false;

		try {
			ctx = new InitialContext();

			DataSource ds = (DataSource)  ctx.lookup("SmallCellApplicationDataSource");

			conn = ds.getConnection();
			
			
			
			String id = String.valueOf(newIssue.getId());
			//date
			String description = newIssue.getIssueDescription();
			String resolutionComments = newIssue.getResolutionComments();
			String projectType = newIssue.getProjectType();
			String activityName = newIssue.getActivityName();
			String systemName = newIssue.getSystemName();
			String author = newIssue.getAuthor();
			String activityStatus = newIssue.getActivityStatus();
			String issueType = newIssue.getIssueType();
			
			
			
			String sqlString = "Insert into issue_issueap values ("+id+",Current_date,?,?,?,?,?,?,?,?)";
			
			PreparedStatement validationStmt =   conn.prepareStatement(sqlString);
			
			validationStmt.setString(1, description);
			validationStmt.setString(2, resolutionComments);
			validationStmt.setString(3, projectType);
			validationStmt.setString(4, activityName);
			validationStmt.setString(5, systemName);
			validationStmt.setString(6, author);
			validationStmt.setString(7, activityStatus);
			validationStmt.setString(8, issueType);
			
			rs =validationStmt.executeQuery();
			created=true;
		
		}

		catch (NamingException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
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
		
		return created;
	}

	public Issue getAnIssue(long id) {

		Context ctx = null;
		Connection conn = null;
		ResultSet rs = null;
		Issue tempIssue = null;

		try {
			ctx = new InitialContext();

			DataSource ds = (DataSource)  ctx.lookup("SmallCellApplicationDataSource");

			conn = ds.getConnection();
			
			String sqlString = "SELECT * FROM ISSUE_ISSUEAP WHERE ID="+id;
			
			PreparedStatement validationStmt =   conn.prepareStatement(sqlString);
			
			rs =validationStmt.executeQuery();
			
			if (rs.next()) {
				tempIssue = new Issue();
				tempIssue.setId(rs.getLong("ID"));
				//tempIssue.setCreationDate(rs.getString("CREATION_DATE"));
				tempIssue.setIssueDescription(rs.getString("DESCRIPTION"));
				tempIssue.setResolutionComments(rs.getString("RESOLUTION_COMMENTS"));
				tempIssue.setProjectType(rs.getString("PROJECT_TYPE"));
				tempIssue.setActivityName(rs.getString("ACTIVITY_NAME"));
				tempIssue.setSystemName(rs.getString("SYSTEM_NAME"));
				tempIssue.setAuthor(rs.getString("AUTHOR"));
				tempIssue.setActivityStatus(rs.getString("ACTIVITY_STATUS"));
				tempIssue.setIssueType(rs.getString("ISSUE_TYPE"));
			}
		
		}

		catch (NamingException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
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
		
		return tempIssue;
	}
	
}
