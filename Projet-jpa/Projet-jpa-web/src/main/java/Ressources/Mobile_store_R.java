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

import projet.entity.Mobile_store;
import projet.services.Mobile_store_Service;

@Path("Mobile_store")
public class Mobile_store_R {
	

	@EJB
	Mobile_store_Service Mobile_store_Ser;

	public Mobile_store_R() {
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mobile_store> getMobile_store(){
		
		return Mobile_store_Ser.getMobile_store();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addFixed_store(Mobile_store m) {
		Mobile_store_Ser.addMobile_store(m);
		return "Mobile_store added";
	}
	
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMobile_store(@PathParam("id")int id) {
		Mobile_store_Ser.deleteMobile_storeById(id);
		return "remove Mobile_store  success ";
	} 
	
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateMobile_store(Mobile_store m) {
		Mobile_store_Ser.updateMobile_store(m);
		return "update  		Mobile_store success";
	}
	
	
	

}
