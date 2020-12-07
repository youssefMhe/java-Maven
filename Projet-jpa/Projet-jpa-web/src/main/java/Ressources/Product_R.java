package Ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import projet.services.Product_Service;
import projet.entity.*;
@Path("Product")
public class Product_R {
	
	@EJB
	Product_Service Product_Ser;
	
	
	
	public Product_R() {
		
	}



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProduct(){
		
		return Product_Ser.getProduct();
	}
	
	@GET
	@Path("makeExel")
	@Produces(MediaType.APPLICATION_JSON)
	public String createfileExel(){
		
		Product_Ser.createfileExel();
		
		return "file made with sucess";
		
	}
	
	
	@GET
	@Path("get/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Product getProductbyid(@PathParam("id")int id) {
		
		return Product_Ser.getProductbyid(id);
	}
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addProduct(Product c) {
		Product_Ser.addProduct(c);
		return "Product added";
	}
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProduct(@PathParam("id")int id) {
		Product_Ser.deleteProductById(id);
		return "remove Product   success";
	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateProduct(Product c) {
		Product_Ser.updateProduct(c);
		return "update Product success";
	}
	
	@PUT
	@Path("updateEX")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateProduct_From_Exel() {
		Product_Ser.updateProduct_From_Exel();
		return "update Product success";
	}

}
