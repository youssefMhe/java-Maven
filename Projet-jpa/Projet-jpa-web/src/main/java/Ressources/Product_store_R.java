package Ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import projet.entity.Product;
import projet.services.Product_Service;
import projet.services.Product_store_Service;

@Path("Product_store_R")
public class Product_store_R {
	@EJB
	Product_store_Service Product_store_Ser;
	
	
	@POST
	@Path("add/{idF}/{idP}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addProduct_to_store (@PathParam("idF")int idF ,@PathParam("idP") int idP) 
	{
		Product_store_Ser.addProduct_store(idP, idF);
		return "Product et sotre affecter -----> added";
	}
	
	
	

	@GET
	@Path("getparidfixedstore/{idF}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> findallproduitofFixedstore(@PathParam("idF")int idF )
	{
		
		return Product_store_Ser.findallproduitofFixedstore(idF);
	}
	
}
