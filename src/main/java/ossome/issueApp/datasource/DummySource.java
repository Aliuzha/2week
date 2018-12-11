package ossome.issueApp.datasource;

import java.util.ArrayList;
import java.util.List;

import ossome.issueApp.rest.model.Issue;

public class DummySource {
	
	private static List<Issue> issueList = new ArrayList<Issue>();
	
	public static List<Issue> getIssueList(){
		return issueList;
	}
}
