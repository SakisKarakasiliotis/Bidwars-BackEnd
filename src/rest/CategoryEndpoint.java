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

import db.CategoryDB;
import db.ProductDB;
import model.BidwarsCategory;
import model.BidwarsProduct;

@Path("/categories")
public class CategoryEndpoint {
	@POST
	@Consumes({ "application/json" })
	public Response create(final BidwarsCategory product) {
		entities.BidwarsCategory categoryd = new entities.BidwarsCategory();
		categoryd.setName(product.getName());
		categoryd.setDescription(product.getDescription());
		CategoryDB categoryDao = new CategoryDB();
		int id = categoryDao.insertCategory(categoryd);
		return Response.created(
				UriBuilder.fromResource(ProductEndpoint.class)
						.path(String.valueOf(id)).build()).build();
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({"application/json"})
	public Response findById(@PathParam("id") final Integer id) {
		CategoryDB categoryDao = new CategoryDB();
		entities.BidwarsCategory categoryd = categoryDao.getById(id);
		BidwarsCategory category = null;
		if (categoryd != null) {
			category = new BidwarsCategory();
			category.setID(categoryd.getId());
			categoryd.setName(category.getName());
			categoryd.setDescription(category.getDescription());
			
		}
		if (category == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(category).build();
	}
	
	@GET
	@Produces({ "application/json" })
	public List<BidwarsCategory> listAll() {
		CategoryDB categoryDao = new CategoryDB();
		List<entities.BidwarsCategory> categoriesd = categoryDao.getBidwarsCategories();
		List<BidwarsCategory> categories = null;
		if (categoriesd != null && categoriesd.size()>0)
		{
			categories = new ArrayList<BidwarsCategory>();
			for (entities.BidwarsCategory categoryd : categoriesd)
			{
				BidwarsCategory category = new BidwarsCategory();
				category.setID(categoryd.getId());
				category.setName(category.getName());
				category.setDescription(category.getDescription());
				categories.add(category);
			}
		}
		
		
		return categories;
	}
	
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the category matching by the given id 
		return Response.noContent().build();
	}
}
