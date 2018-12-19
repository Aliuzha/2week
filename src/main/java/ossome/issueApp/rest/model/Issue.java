package ossome.issueApp.rest.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Issue {

   private Long id;

   private String issueDescription;

   private LocalDate creationDate;

   private String resolutionComments;
   
   private String author;
 
   private String issueType;
   
   private String projectType;
   
   private String activityName;
   
   private String activityStatus;
   
   private String systemName;
   
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
   
   public Issue() {
   }
   
   public Issue(Long id, String issueDescription, String creationDate,String resolutionComments, String issueType, String projectType, String activityName, String systemName, String author, String activityStatus) {
	   this.id = id;
	   this.creationDate = LocalDate.parse(creationDate,formatter);
	   this.issueDescription = issueDescription;
	   this.resolutionComments = resolutionComments;
	   this.issueType = issueType;
	   this.projectType = projectType;
	   this.activityName = activityName;
	   this.systemName = systemName;
	   this.author = author;
	   this.activityStatus = activityStatus;
	   
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long value) {
      this.id = value;
   }

   public String getIssueDescription() {
      return this.issueDescription;
   }

   public void setIssueDescription(String value) {
      this.issueDescription = value;
   }

   public LocalDate getCreationDate() {
      return this.creationDate;
   }

   public void setCreationDate(String value) {
      this.creationDate = LocalDate.parse(value,formatter);
   }

   public String getFixComments() {
      return this.resolutionComments;
   }

   public void setFixComments(String value) {
      this.resolutionComments = value;
   }
   
   public String getResolutionComments() {
	return resolutionComments;
   }

	public void setResolutionComments(String resolutionComments) {
		this.resolutionComments = resolutionComments;
	}
	
	public String getIssueType() {
		return issueType;
	}
	
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	public String getProjectType() {
		return projectType;
	}
	
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public String getSystemName() {
		return systemName;
	}
	
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	   
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	
	

}