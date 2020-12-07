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


import projet.entity.Plannig;
import projet.services.Plannig_Service;





@Path("Plannig")
public class Plannig_R {
	

	@EJB
	Plannig_Service Plannig_Ser;
	
	
	
	public Plannig_R() {
		
	}



	@GET
	@Path("getallPlannig/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plannig> getPlannigbyIDMobileStore(@PathParam("id")int id){
		
		return Plannig_Ser.getPlannigbyIDMobileStore(id);
	}
	
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plannig> getPlannig(){
		
		return Plannig_Ser.getPlannig();
	}
	

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addPlannig(Plannig c) {
		Plannig_Ser.addPlannig(c);
		return "Plannig added";
	}
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePlannig(@PathParam("id")int id) {
		Plannig_Ser.deletePlannigById(id);
		return "remove success";
	}
	
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePlannig(Plannig c) {
		Plannig_Ser.updatePlannig(c);
		return "update success";
	}
	
	
	@PUT
	@Path("affecterMobile-store-to_planning/{idM}/{idP}")
	@Produces(MediaType.TEXT_PLAIN)
	public String affecterMobile_storePlanning (@PathParam("idM")int idM ,@PathParam("idP") int idP)  {
		boolean resultat ;
		resultat =Plannig_Ser.affecterMobile_storePlanning(idM, idP);
		if (resultat==true)
		{
			return "affecte   Mobile store   to Plannig  with  success  :) ";
		}
		return "affecte   Mobile store   to Plannig   noo  !!!  this Mobile store have work yet  or have not the same Object work :(";
		
	}
	

	@GET
	@Path("dateaugent")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plannig> getPlannigencoursdefinir(){
		
		return Plannig_Ser.getPlannigencoursdefinir();
	}
	
	

}
