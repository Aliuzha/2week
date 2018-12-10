package ossome.issueApp.rest.impl;

import java.util.List;
import java.util.stream.Collectors;

import ossome.issueApp.datasource.DummySource;
import ossome.issueApp.rest.model.ActivityIssue;

public class IssueApiImpl {
	
	private List<ActivityIssue> dataSource = DummySource.getIssueList();
	
	public String ping() {
		return "issueApp API up and running!";
	}
	
	public List<ActivityIssue> getAllIssues() {
		
		//CHANGE WITH DATASOURCE--
		return dataSource;		//
		//------------------------
	}
	
	public ActivityIssue getIssue(Long id) {
		
		//CHANGE WITH DATASOURCE----------------------
		for (ActivityIssue issue: dataSource) {		//
			if (issue.getId()==id)return issue;		//
		}
		//--------------------------------------------
		
		return null;
		
	}
	
	public ActivityIssue addActivityIssue(ActivityIssue issue){
		List<ActivityIssue> tempList = dataSource.stream().filter(activityIssue-> activityIssue.getId()==issue.getId()).collect(Collectors.toList());
		if (tempList.size()>0) return null;
		else {
			
			//CHANGE WITH DATASOURCE----
			dataSource.add(issue);	//--
			//--------------------------
			return issue;
		}		
	}
	
	public ActivityIssue updateActivityIssue(ActivityIssue issue){
		List<ActivityIssue> tempList = dataSource.stream().filter(activityIssue-> activityIssue.getId()==issue.getId()).collect(Collectors.toList());
		if (tempList.size()<1) return null;
		else {
			List<ActivityIssue> newList = dataSource.stream().filter(activity-> activity.getId()!=issue.getId()).collect(Collectors.toList());
			
			//CHANGE WITH DATASOURCE -----
			newList.add(issue); 		//
			dataSource = newList;		//
			//----------------------------
			
			return issue;				
		}
	}
	
	public ActivityIssue removeActivityIssue(Long id){
		List<ActivityIssue> tempList = dataSource.stream().filter(activityIssue-> activityIssue.getId()==id).collect(Collectors.toList());
		if (tempList.size()<1) return null;
		else {
			ActivityIssue deletedIssue = tempList.get(0);
			
			//CHANGE WITH DATASOURCE--------------------------------------------------------------------------------------------------
			List<ActivityIssue> newList = dataSource.stream().filter(activity-> activity.getId()!=id).collect(Collectors.toList());	//
			dataSource=newList;																										//
			//------------------------------------------------------------------------------------------------------------------------
			
			return deletedIssue;
		}
	}
	
	

}
