package ossome.issueApp.datasource;

import java.util.ArrayList;
import java.util.List;

import ossome.issueApp.rest.model.ActivityIssue;

public class DummySource {
	
	private static List<ActivityIssue> issueList = new ArrayList<ActivityIssue>();
	
	public static List<ActivityIssue> getIssueList(){
		return issueList;
	}
}
