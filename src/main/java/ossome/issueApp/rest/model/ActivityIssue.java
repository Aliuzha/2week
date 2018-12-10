package ossome.issueApp.rest.model;

public class ActivityIssue extends Issue {

	private String activityName;
	private String activityStatus;
	
	public ActivityIssue() {}
	
	public ActivityIssue(Long id, String issueDescription, String creationDate,
			String fixComments, String activityName, String activityStatus) {
		   this.id = id;
		   this.issueDescription = issueDescription;
		   this.creationDate = creationDate;
		   this.fixComments = fixComments;
		   this.activityName = activityName;
		   this.activityStatus = activityStatus;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	
}
