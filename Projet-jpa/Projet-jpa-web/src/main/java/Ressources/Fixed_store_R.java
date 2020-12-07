package Ressources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.maxmind.geoip.Location;

import projet.entity.Fixed_store;
import projet.services.Fixed_store_Service;


@Path("Fixed_store")
public class Fixed_store_R {

	@EJB
	Fixed_store_Service Fixed_store_Ser;



	public Fixed_store_R() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fixed_store> getFixed_store(){

		return Fixed_store_Ser.getFixed_store();
	}


	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addFixed_store(Fixed_store FS) {
		Fixed_store_Ser.addFixed_store(FS);
		return "Fixed_store added";
	}


	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteFixed_store(@PathParam("id")int id) {
		Fixed_store_Ser.deleteFixed_storeById(id);
		return "remove Fixed_store  success ";
	} 


	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateFixed_store(Fixed_store c) {
		Fixed_store_Ser.updateFixed_store(c);
		return "update  Fixed_store success";
	}

	/*
	@PUT
	@Path("affecterstoretorating/{idF}/{idR}")
	@Produces(MediaType.TEXT_PLAIN)
	public String affecterFixed_storeToRating_store (@PathParam("idF")int idF ,@PathParam("idR") int idR)  {
		Fixed_store_Ser.affecterFixed_storeToRating_store(idF, idR);
		return "affecte   Fixed_store   to rating  with  success --- % 100 ---- ";
	}*/






	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("stat")
	public Map <String, Float> resultatsatistic() {
		Map <String, Float> hm = new HashMap<String, Float>();
		

		float Tunis = Fixed_store_Ser.getnombrefixed_storebyCity("Tunis");
		float Sfax = Fixed_store_Ser.getnombrefixed_storebyCity("Sfax");
		float Ben  = Fixed_store_Ser.getnombrefixed_storebyCity("Ben Arous");
		float Sousse = Fixed_store_Ser.getnombrefixed_storebyCity("Sousse");
		float Gabes = Fixed_store_Ser.getnombrefixed_storebyCity("Gabes");
		float Medenine = Fixed_store_Ser.getnombrefixed_storebyCity("Medenine");
		float Nabeul  = Fixed_store_Ser.getnombrefixed_storebyCity("Nabeul ");
		float Monastir = Fixed_store_Ser.getnombrefixed_storebyCity("Monastir");
		float Kairouan = Fixed_store_Ser.getnombrefixed_storebyCity("Kairouan");
		float Bizerte = Fixed_store_Ser.getnombrefixed_storebyCity("Bizerte");
		float Mahdia = Fixed_store_Ser.getnombrefixed_storebyCity("Mahdia");
		float Jendouba = Fixed_store_Ser.getnombrefixed_storebyCity("Jendouba");
		float Sidi  = Fixed_store_Ser.getnombrefixed_storebyCity("Sidi Bouzid");
		float Gafsa  = Fixed_store_Ser.getnombrefixed_storebyCity("Gafsa ");
		float Tozeur = Fixed_store_Ser.getnombrefixed_storebyCity("Ariana");
		float Kef = Fixed_store_Ser.getnombrefixed_storebyCity("Kef");
		float Kasserine = Fixed_store_Ser.getnombrefixed_storebyCity("Kasserine");
		float Manouba = Fixed_store_Ser.getnombrefixed_storebyCity("Manouba");
		float Tataouine = Fixed_store_Ser.getnombrefixed_storebyCity("Tataouine");
		float Siliana = Fixed_store_Ser.getnombrefixed_storebyCity("Siliana");
		float Beja = Fixed_store_Ser.getnombrefixed_storebyCity("Beja");
		float Kebili = Fixed_store_Ser.getnombrefixed_storebyCity("Kebili");
		float Zaghouan = Fixed_store_Ser.getnombrefixed_storebyCity("Zaghouan");
		float Ariana = Fixed_store_Ser.getnombrefixed_storebyCity("Ariana");

		int S = Fixed_store_Ser.getnombrefixed_store();

		Float
		SondageT,SondageSf ,SondageBen,SondageSou,SondageGa ,SondageMed,SondageNa,SondageMo
		,SondageKAi ,SondageBiz ,SondageMah,SondageJen,SondageSid,SondageGaf,SondageToz,SondageKef,SondageKas,SondageManou
		,SondageTAT,SondageSil,SondageBej,SondagesKebi,SondageZag,SondageARIA
		,sTu,sSf,sben,sSou,sGab,sMed,sNab,sMoun,sKair,sBize,sMah,sJendou,sSidi,sGaf,sTouz,sKef,sKas,sManou,sTata,sSilia,sBeej,sKebi,sZahg,sAria
		= (float) 0;
		
		
		SondageT = (float) (Tunis / S);
		sTu = SondageT * 100;
		
		SondageSf = (float) (Sfax / S);
		sSf = SondageSf * 100;
		
		
		SondageBen = (float) (Ben / S);
		sben = SondageBen * 100;
		
		SondageSou = (float) (Sousse / S);
		sSou = SondageSou * 100;
		
		SondageGa = (float) (Gabes / S);
		sGab = SondageGa * 100;
		
		
		SondageMed = (float) (Medenine / S);
		sMed = SondageMed * 100;
		
		SondageNa = (float) (Nabeul / S);
		sNab = SondageNa * 100;
		
		SondageMo = (float) (Monastir / S);
		sMoun = SondageMo * 100;
		
		SondageKAi = (float) (Kairouan / S);
		sKair = SondageKAi * 100;
		
		SondageBiz = (float) (Bizerte / S);
		sBize = SondageBiz * 100;
		
		SondageMah = (float) (Mahdia / S);
		sMah = SondageMah * 100;
		
		SondageJen = (float) (Jendouba / S);
		sJendou = SondageJen * 100;
		
		
		SondageSid = (float) (Sidi / S);
		sSidi = SondageSid * 100;
		
		SondageGaf = (float) (Gafsa / S);
		sGaf = SondageGaf * 100;
		
		SondageToz = (float) (Tozeur / S);
		sTouz = SondageToz * 100;
		
		SondageKef = (float) (Kef / S);
		sKef = SondageKef * 100;
		
		
		SondageKas = (float) (Kasserine / S);
		sKas = SondageKas * 100;
		
		SondageManou = (float) (Manouba / S);
		sManou = SondageManou * 100;
		
		SondageTAT = (float) (Tataouine / S);
		sTata = SondageTAT * 100;
		
		SondageSil = (float) (Siliana / S);
		sSilia = SondageSil * 100;
		
		SondageBej = (float) (Beja / S);
		sBeej= SondageBej * 100;
		
		SondageZag = (float) (Zaghouan / S);
		sZahg = SondageZag * 100;
		
		SondageARIA = (float) (Ariana / S);
		sAria= SondageARIA * 100;
		
		
		SondagesKebi = (float) (Kebili / S);
		sKebi = SondagesKebi * 100;
		
		
		/*
		return " la voilla distribusion des Store fixe dans les villes tunisiennes \n"
				+"Tunis .."+sTu+"% \n"
		+"Sfax .."+sSf+"% \n"
		+"Ben Arous .."+sben+"%\n"
		+"Sousse .."+sSou+"%\n"
		+"Gafsa .."+sGaf+"%\n"
		+"Mednine .."+sMed+"%\n"
		+"Nabel .."+sNab+"%\n"
		+"Mounastir .."+sMoun+"%\n"
		+"Kairoune .."+sKair+"%\n"
		+"Bizerte .."+sBize+"%\n"
		+"Mahdia .."+sMah+"%\n"
		+"Jendouba .."+sJendou+"%\n"
		+"Sidi Bouzid .."+sSidi+"%\n"
		+"Gafsa .."+sGaf+"%\n"
		+"Tozeur .."+sTouz+"%\n"
		+"Kef .."+sKef+"%\n"
		+"Kassrine .."+sKas+"%\n"
		+"Manouba .."+sManou+"%\n"
		+"Tatauoin .."+sTata+"%\n"
		+"Siliana .."+sSilia+"%\n"
		+"Beja .."+sBeej+"%\n"
		+"Kebili .."+sKebi+"%\n"
		+"Zaghouan .."+sZahg+"%\n"
		+"Ariana .."+sAria+"%\n"
		
		
		
		;*/
		ArrayList<Float> Liste = new ArrayList<Float>();
		
		Liste.add(sSf );
		Liste.add(sben );
		Liste.add(sSou );
		Liste.add(sGab );
		Liste.add(sMed );
		Liste.add(sNab );
		Liste.add(sMoun );
		Liste.add(sKair );
		Liste.add(sBize );
		Liste.add(sMah );
		Liste.add(sJendou );
		Liste.add(sSidi );
		Liste.add(sGaf );
		Liste.add(sTouz );
		Liste.add(sKef );
		Liste.add(sKas );
		Liste.add(sManou );
		Liste.add(sTata );
		Liste.add(sSilia );
		Liste.add(sBeej );
		Liste.add(sKebi );
		Liste.add(sZahg );
		Liste.add(sAria );
		Liste.add(sTu );
		//Tri dans l'ordre décroissant
		
		

		hm.put("Sfax",sSf );
		hm.put("Ben Arous",sben );
		hm.put("Sousse",sSou );
		hm.put("Gabes",sGab );
		hm.put("Medenine",sMed );
		hm.put("Nabel",sNab );
		hm.put("Mounastir",sMoun );
		hm.put("Kaisrine",sKair );
		hm.put("Bizerte",sBize );
		hm.put("Mahdia",sMah );
		hm.put("Jendouba",sJendou );
		hm.put("Sidi Bouzid",sSidi );
		hm.put("Gafsa",sGaf );
		hm.put("Touzeur",sTouz );
		hm.put("Kef",sKef );
		hm.put("Kasserine",sKas );
		hm.put("Manouba",sManou );
		hm.put("Tataouine",sTata );
		hm.put("Siliana",sSilia );
		hm.put("Beja",sBeej );
		hm.put("Kebili",sKebi );
		hm.put("Zaghouan",sZahg );
		hm.put("Ariana",sAria );
		hm.put("Tunis",sTu );
		
		 return hm.entrySet()
				 .stream()
				 .sorted(Map.Entry.comparingByValue())
				 .collect(Collectors.toMap(
				 Map.Entry::getKey, 
				 Map.Entry::getValue, 
				 (e1, e2) -> e1, 
				 LinkedHashMap::new
				 ));
		
		
	}

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("Localisation")
	public String  Lacalisationetlastway(){
		  String c=Fixed_store_Ser.Lacalisationetlastway();
		return c;
	}



}
