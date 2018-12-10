package ossome.issueApp.rest.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ossome.issueApp.rest.impl.IssueApiImpl;
import ossome.issueApp.rest.model.ActivityIssue;

@Path("issueRecords")
public class IssueApi {

	
	IssueApiImpl issueApiImpl = new IssueApiImpl();
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ping")
    public String ping() {
        return issueApiImpl.ping();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActivityIssue> getAllIssueRecords() {
    	return issueApiImpl.getAllIssues();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{issueId}")
    public ActivityIssue getIssueRecord(@PathParam("issueId")String issueId) {
    	return issueApiImpl.getIssue(Long.valueOf(issueId));
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActivityIssue addIssueRecord(ActivityIssue issue) {
    	return issueApiImpl.addActivityIssue(issue);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActivityIssue updateIssueRecord(@PathParam("issueId")String issueId, ActivityIssue issue) {
    	issue.setId(Long.valueOf(issueId));
    	return issueApiImpl.updateActivityIssue(issue);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{issueId}")
    public ActivityIssue deleteIssueRecord(@PathParam("issueId")String issueId) {
    	return issueApiImpl.removeActivityIssue(Long.valueOf(issueId));
    }
}
