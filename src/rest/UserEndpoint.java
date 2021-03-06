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

import db.UserDB;
import model.BidwarsUser;

@Path("/users")
public class UserEndpoint {

	@POST
	@Path("/save")
	@Consumes({ "application/json" })
	public Response create(final BidwarsUser user) {
		entities.BidwarsUser userd = new entities.BidwarsUser();
		userd.setName(user.getName());
		userd.setSurname(user.getSurname());
		userd.setUsername(user.getUsername());
		userd.setPassword(user.getPassword());
		userd.setEmail(user.getEmail());
		userd.setUserKey(user.getUser_key());
		userd.setBidwarsUserGroup(1);



		UserDB userDao = new UserDB();
		int id = userDao.insertUser(userd);
		return Response.created(
				UriBuilder.fromResource(UserEndpoint.class)
						.path(String.valueOf(id)).build()).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({"application/json"})
	public Response findById(@PathParam("id") final Integer id) {
		UserDB userDao = new UserDB();
		entities.BidwarsUser userd = userDao.getById(id);
		BidwarsUser user = null;
		if (userd != null) {
			user = new BidwarsUser();
			user.setID(userd.getId());
			user.setSurname(userd.getSurname());
			user.setName(userd.getName());
			user.setPassword(userd.getPassword());
			user.setUsername(userd.getUsername());
		}
		if (user == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(user).build();
	}

	@GET
	@Produces({ "application/json" })
	public List<BidwarsUser> listAll() {
		System.out.println("entering users");
		UserDB userDao = new UserDB();
		List<entities.BidwarsUser> usersd = userDao.getBidwarsUsers();
		List<BidwarsUser> users = null;
		if (usersd != null && usersd.size()>0)
		{
			users = new ArrayList<BidwarsUser>();
			for (entities.BidwarsUser userd : usersd)
			{
				BidwarsUser user = new BidwarsUser();
				user.setID(userd.getId());
				user.setSurname(userd.getSurname());
				user.setName(userd.getName());
				user.setPassword(userd.getPassword());
				user.setUsername(userd.getUsername());
				users.add(user);
			}
		}
		
		System.out.println("exiting users"+users);
		return users;
	}


	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the user matching by the given id 
		return Response.noContent().build();
	}


}
