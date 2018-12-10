package ossome.issueApp.rest.model;

public class Issue {

   protected Long id;

   protected String issueDescription;

   protected String creationDate;

   protected String fixComments;

   public Issue() {
   }
   
   public Issue(Long id, String issueDescription, String creationDate,String fixComments) {
	   this.id = id;
	   this.creationDate = creationDate;
	   this.issueDescription = issueDescription;
	   this.fixComments = fixComments;
	   
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

   public String getCreationDate() {
      return this.creationDate;
   }

   public void setCreationDate(String value) {
      this.creationDate = value;
   }

   public String getFixComments() {
      return this.fixComments;
   }

   public void setFixComments(String value) {
      this.fixComments = value;
   }
}