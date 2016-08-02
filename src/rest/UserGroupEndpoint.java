package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;


import db.UserGroupDB;
import model.BidwarsUserGroup;

@Path("/usergroups")
public class UserGroupEndpoint {
	@POST
	@Consumes({ "application/json" })
	public Response create(final BidwarsUserGroup usergroup) {
		entities.BidwarsUserGroup usergroupd = new entities.BidwarsUserGroup();
		usergroupd.setName(usergroup.getName());
		usergroupd.setDescription(usergroup.getDescription());
		usergroupd.setId(usergroup.getId());
		// List pending!!!
		UserGroupDB usergroupDao = new UserGroupDB();
		int id = usergroupDao.insertUserGroup(usergroupd);
		return Response.created(
				UriBuilder.fromResource(UserGroupEndpoint.class)
						.path(String.valueOf(id)).build()).build();
	}


@GET
@Path("/{id:[0-9][0-9]*}")
@Produces({"application/json"})
public Response findById(@PathParam("id") final Integer id) {
	UserGroupDB usergroupDao = new UserGroupDB();
	entities.BidwarsUserGroup usergroupd = usergroupDao.getById(id);
	BidwarsUserGroup usergroup = null;
	if (usergroupd != null) {
		usergroup = new BidwarsUserGroup();
		usergroup.setId(usergroupd.getId());
		usergroup.setName(usergroupd.getName());
		usergroup.setDescription(usergroupd.getDescription());
		
	}
	if (usergroup == null) {
		return Response.status(Status.NOT_FOUND).build();
	}
	return Response.ok(usergroup).build();
	}

@GET
@Produces({ "application/json" })
public List<BidwarsUserGroup> listAll() {
	UserGroupDB usergroupDao = new UserGroupDB();
	List<entities.BidwarsUserGroup> usergroupsd = usergroupDao.getBidwarsUserGroups();
	List<BidwarsUserGroup> usergroups = null;
	if (usergroupsd != null && usergroupsd.size()>0)
	{
		usergroups = new ArrayList<BidwarsUserGroup>();
		for (entities.BidwarsUserGroup usergroupd : usergroupsd)
		{
			BidwarsUserGroup usergroup = new BidwarsUserGroup();
			usergroup.setId(usergroupd.getId());
			usergroup.setName(usergroupd.getName());
			usergroup.setDescription(usergroupd.getDescription());
			
			usergroups.add(usergroup);
		}
	}
	
	
	return usergroups;
}

@DELETE
@Path("/{id:[0-9][0-9]*}")
public Response deleteById(@PathParam("id") final Long id) {
	//TODO: process the user matching by the given id 
	return Response.noContent().build();
}
}