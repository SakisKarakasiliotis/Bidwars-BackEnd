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

import db.ProductDB;
import model.BidwarsProduct;

@Path("/products")
public class ProductEndpoint {
	@POST
	@Consumes({ "application/json" })
	public Response create(final BidwarsProduct product) {
		entities.BidwarsProduct productd = new entities.BidwarsProduct();
		productd.setName(product.getName());
		productd.setLocation(product.getLocation());
		productd.setCountry(product.getCountry());
		productd.setBeginDate(product.getBegin_date());
		ProductDB productDao = new ProductDB();
		int id = productDao.insertProduct(productd);
		return Response.created(
				UriBuilder.fromResource(ProductEndpoint.class)
						.path(String.valueOf(id)).build()).build();
	}
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({"application/json"})
	public Response findById(@PathParam("id") final Integer id) {
		ProductDB productDao = new ProductDB();
		entities.BidwarsProduct productd = productDao.getById(id);
		BidwarsProduct product = null;
		if (productd != null) {
			product = new BidwarsProduct();
			product.setID(productd.getId());
			productd.setName(product.getName());
			productd.setLocation(product.getLocation());
			productd.setCountry(product.getCountry());
			productd.setBeginDate(product.getBegin_date());
		}
		if (product == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(product).build();
	}
	
	@GET
	@Produces({ "application/json" })
	public List<BidwarsProduct> listAll() {
		ProductDB productDao = new ProductDB();
		List<entities.BidwarsProduct> productsd = productDao.getBidwarsProducts();
		List<BidwarsProduct> products = null;
		if (productsd != null && productsd.size()>0)
		{
			products = new ArrayList<BidwarsProduct>();
			for (entities.BidwarsProduct productd : productsd)
			{
				BidwarsProduct product = new BidwarsProduct();
				product.setID(productd.getId());
				product.setName(product.getName());
				product.setLocation(product.getLocation());
				product.setCountry(product.getCountry());
				product.setBegin_date(product.getBegin_date());
				products.add(product);
			}
		}
		
		
		return products;
	}
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the user matching by the given id 
		return Response.noContent().build();
	}

}
