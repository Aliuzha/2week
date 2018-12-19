package ossome.issueApp.rest.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ossome.issueApp.dao.IssueDao;
import ossome.issueApp.datasource.DBUtil;
import ossome.issueApp.datasource.DummySource;
import ossome.issueApp.datasource.JdbcQuery;
import ossome.issueApp.rest.model.Issue;

public class IssueApiImpl {
	
	private List<Issue> dataSource = DummySource.getIssueList();
	private IssueDao dao = new IssueDao();
	
	public String ping() {
		return "issueApp API up and running!";
	}
	
	public List<Issue> getAllIssues() {
		
		List<Issue> issues = dao.getAllIssues();
		
		return issues;
	}
	
	public Issue getIssue(Long id) {
		
		return dao.getAnIssue(id);
				
	}
	
	public Issue addIssue(Issue issue){
		
		boolean created = dao.createIssue(issue);
		if (created)return issue;
		else return null;
		
	}
	
	public Issue updateIssue(Issue issue){
		List<Issue> tempList = dataSource.stream().filter(Issue-> Issue.getId()==issue.getId()).collect(Collectors.toList());
		if (tempList.size()<1) return null;
		else {
			List<Issue> newList = dataSource.stream().filter(activity-> activity.getId()!=issue.getId()).collect(Collectors.toList());
			
			//CHANGE WITH DATASOURCE -----
			newList.add(issue); 		//
			dataSource = newList;		//
			//----------------------------
			
			return issue;				
		}
	}
	
	public Issue removeIssue(Long id){
		List<Issue> tempList = dataSource.stream().filter(Issue-> Issue.getId()==id).collect(Collectors.toList());
		if (tempList.size()<1) return null;
		else {
			Issue deletedIssue = tempList.get(0);
			
			//CHANGE WITH DATASOURCE--------------------------------------------------------------------------------------------------
			List<Issue> newList = dataSource.stream().filter(activity-> activity.getId()!=id).collect(Collectors.toList());	//
			dataSource=newList;																										//
			//------------------------------------------------------------------------------------------------------------------------
			
			return deletedIssue;
		}
	}
	
	

}
