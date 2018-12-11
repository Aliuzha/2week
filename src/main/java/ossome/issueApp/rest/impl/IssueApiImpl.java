package ossome.issueApp.rest.impl;

import java.util.List;
import java.util.stream.Collectors;

import ossome.issueApp.datasource.DummySource;
import ossome.issueApp.rest.model.Issue;

public class IssueApiImpl {
	
	private List<Issue> dataSource = DummySource.getIssueList();
	
	public String ping() {
		return "issueApp API up and running!";
	}
	
	public List<Issue> getAllIssues() {
		
		//CHANGE WITH DATASOURCE--
		return dataSource;		//
		//------------------------
	}
	
	public Issue getIssue(Long id) {
		
		//CHANGE WITH DATASOURCE----------------------
		for (Issue issue: dataSource) {		//
			if (issue.getId()==id)return issue;		//
		}
		//--------------------------------------------
		
		return null;
		
	}
	
	public Issue addIssue(Issue issue){
		List<Issue> tempList = dataSource.stream().filter(Issue-> Issue.getId()==issue.getId()).collect(Collectors.toList());
		if (tempList.size()>0) return null;
		else {
			
			//CHANGE WITH DATASOURCE----
			dataSource.add(issue);	//--
			//--------------------------
			return issue;
		}		
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
