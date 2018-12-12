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

import ossome.issueApp.datasource.DBUtil;
import ossome.issueApp.rest.impl.IssueApiImpl;
import ossome.issueApp.rest.model.Issue;

@Path("issueRecords")
public class IssueApi {

	
	IssueApiImpl issueApiImpl = new IssueApiImpl();
	DBUtil db = new DBUtil();
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ping")
    public String ping() {
    	List<String> testList = db.testDB();
    	if (testList.size()>0) return issueApiImpl.ping()+db.testDB().get(0);
        return issueApiImpl.ping();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Issue> getAllIssueRecords() {
    	return issueApiImpl.getAllIssues();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{issueId}")
    public Issue getIssueRecord(@PathParam("issueId")String issueId) {
    	return issueApiImpl.getIssue(Long.valueOf(issueId));
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Issue addIssueRecord(Issue issue) {
    	return issueApiImpl.addIssue(issue);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{issueId}")
    public Issue updateIssueRecord(@PathParam("issueId")String issueId, Issue issue) {
    	issue.setId(Long.valueOf(issueId));
    	return issueApiImpl.updateIssue(issue);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{issueId}")
    public Issue deleteIssueRecord(@PathParam("issueId")String issueId) {
    	return issueApiImpl.removeIssue(Long.valueOf(issueId));
    }
}
