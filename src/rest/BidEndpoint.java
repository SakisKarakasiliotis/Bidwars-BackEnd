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

import db.BidDB;
import model.BidwarsBid;


@Path("/bids")
public class BidEndpoint {
	
	@POST
	@Consumes({ "application/json" })
	public Response create(final BidwarsBid bid) {
		entities.BidwarsBid bidd = new entities.BidwarsBid();
		bidd.setId(bid.getId());
		bidd.setAmount(bid.getAmount());
		bidd.setBidTime(bid.getBidTime());
		BidDB bidDao = new BidDB();
		int id = bidDao.insertBid(bidd);
		return Response.created(
				UriBuilder.fromResource(UserEndpoint.class)
						.path(String.valueOf(id)).build()).build();
	}


	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({"application/json"})
	public Response findById(@PathParam("id") final Integer id) {
		BidDB bidDao = new BidDB();
		entities.BidwarsBid bidd = bidDao.getById(id);
		BidwarsBid bid = null;
		if (bidd != null) {
			bid = new BidwarsBid();
			bid.setId(bidd.getId());
			bid.setAmount(bidd.getAmount());
			bid.setBidTime(bidd.getBidTime());			
		}
		if (bid == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(bid).build();
	}

	@GET
	@Produces({ "application/json" })
	public List<BidwarsBid> listAll() {
		BidDB bidDao = new BidDB();
		List<entities.BidwarsBid> bidsd = bidDao.getBidwarsBids();
		List<BidwarsBid> bids = null;
		if (bidsd != null && bidsd.size()>0)
		{
			bids = new ArrayList<BidwarsBid>();
			for (entities.BidwarsBid bidd : bidsd)
			{
				BidwarsBid bid = new BidwarsBid();
				bid.setId(bidd.getId());
				bid.setAmount(bidd.getAmount());
				bid.setBidTime(bidd.getBidTime());
				
				bids.add(bid);
			}
		}
		
		
		return bids;
	}
	
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the user matching by the given id 
		return Response.noContent().build();
	}
}