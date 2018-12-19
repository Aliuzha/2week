package ossome.issueApp.dao;

import java.util.List;

import ossome.issueApp.datasource.DBUtil;
import ossome.issueApp.rest.model.Issue;

public class IssueDao {
	
	private DBUtil dbUtil = new DBUtil();
	
	public  List<Issue> getAllIssues(){
		return dbUtil.getAllIssues();
	}
	
	public boolean createIssue(Issue issue) {
		return dbUtil.createIssue(issue);
	}
	
	public Issue getAnIssue(long id) {
		return dbUtil.getAnIssue(id);
	}
	
}
