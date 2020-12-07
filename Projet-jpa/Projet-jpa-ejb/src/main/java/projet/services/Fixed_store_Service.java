package projet.services;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.IOException;



import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import okhttp3.OkHttpClient;
import projet.dto.test;
import projet.entity.Fixed_store;

import projet.interfaces.Fixed_store_Interface;




@Stateless
@LocalBean
public class Fixed_store_Service implements Fixed_store_Interface {
	@PersistenceContext(unitName = "jee-ejb") 
	EntityManager em;




	/**
	 * Default constructor. 
	 */
	public Fixed_store_Service() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public List<Fixed_store> getFixed_store() {
		return (List<Fixed_store>) em.createQuery(" select c from Fixed_store c ",Fixed_store.class).getResultList();
	}

	@Override
	public void addFixed_store(Fixed_store FS) {
		em.persist(FS);

	}

	@Override
	public void deleteFixed_storeById(int id) {
		Fixed_store c = em.find(Fixed_store.class, id);
		em.remove(c);


	}

	@Override
	public void updateFixed_store(Fixed_store FS) {
		Fixed_store Fixed_storeToUpdade = em.find(Fixed_store.class, FS.getId());
		Fixed_storeToUpdade.setEmail(FS.getEmail());
		Fixed_storeToUpdade.setName_store(FS.getName_store());
		Fixed_storeToUpdade.setPhone(FS.getPhone());
		Fixed_storeToUpdade.setPicture(FS.getPicture());
		Fixed_storeToUpdade.setService(FS.getService());
		Fixed_storeToUpdade.setCity(FS.getCity());
		Fixed_storeToUpdade.setHour_B(FS.getHour_B());
		Fixed_storeToUpdade.setHour_E(FS.getHour_E());
		Fixed_storeToUpdade.setStreet(FS.getStreet());

	}




	@Override
	public int getnombrefixed_storebyCity(String city) {
		int S=0;
		List<Fixed_store> L = em.createQuery(" select c from Fixed_store c where c.city =:city ",Fixed_store.class).setParameter("city", city).getResultList();
		for(Fixed_store elem: L)
		{
			S=S+1;
		}
		return S;
	}




	@Override
	public int getnombrefixed_store() {
		int S=0;
		List<Fixed_store> L = em.createQuery(" select c from Fixed_store c ",Fixed_store.class).getResultList();
		for(Fixed_store elem: L)
		{
			S=S+1;
		}
		return S;
	}




	@Override
	public String Lacalisationetlastway() {
		
		
		 final String endpoint = "http://ip-api.com/json";
		 String a = null ;
		 	HttpClient client = new DefaultHttpClient();
		 	HttpGet request = new HttpGet(endpoint);
		 	String ip = "not found"; 
		 	try { HttpResponse response = client.execute(request);
		 	String jsonResponse = EntityUtils.toString(response.getEntity());
		 	System.out.println("Response as String : " + jsonResponse);
		 	JSONObject responseObj = new JSONObject(jsonResponse); 
		 	 
		 	ip = responseObj.getString("query");
		 	
		 	String city = responseObj.getString("city");
		 //	String city = "Tunis";
		 	
		 	String country = responseObj.getString("country");
		 	
		 	String regionName = responseObj.getString("regionName");
		 	
		 	System.out.println("ip : " + ip); 
		 	
		 	
		 	String detaille="";
		 	String position ;
		 	String position_optimal="" ;
		 	int index ;
		 	
		 	double distance_op = 0;
			Client c = ClientBuilder.newClient();
		 	
		 	 List<String> L = em.createQuery(" select c.city from Fixed_store c ",String.class).getResultList();
		 	List<String> L1 = em.createQuery(" select c.street from Fixed_store c ",String.class).getResultList();
		 	
		 	Double tab[] = new Double[L.size()];
		 	
		 	
		 	for (int i=0 ; i < L.size(); i++)
		 	{ 
		 		position =L.get(i);
		 		double n =0;
		 		
		 		
		 		String url = "http://dev.virtualearth.net/REST/V1/Routes/Driving?"
		                + "wp.0="+URLEncoder.encode(city, "UTF-8")+"&wp.1="+URLEncoder.encode(position, "UTF-8")+"&optmz=distance&output=json&key=Ao18FlElwsSZbs5qUOVM8Ima0hjhM-Ss29N4VyFHzAgf_bYfnFoSDO9ukf_vaLd_";
		 		 test content =
			        		c.target(url)
			                .request(MediaType.APPLICATION_JSON)
			                .get(test.class);
		 		double distance = content.getResourceSets().get(0).getResources().get(0).getTravelDistance();
		 		tab[i]= distance;
		 		
		 		 
		 	}
		 	
		 	
		 
		 	int S=0;
		 	Double minVal=tab[0] ;
		       for(int i = 1; i < tab.length; i++)
		       {
		    		

		         if(tab[i] < minVal)
		         {
		        	 minVal=tab[i];
		        	 S=i;
		        	 
		         }
		        	
		         
		       
		       }
		       
		       
		       String  positionF =L.get(S);
		       String url = "http://dev.virtualearth.net/REST/V1/Routes/Driving?"
		                + "wp.0="+URLEncoder.encode(city, "UTF-8")+"&wp.1="+URLEncoder.encode(positionF, "UTF-8")+"&optmz=distance&output=json&key=Ao18FlElwsSZbs5qUOVM8Ima0hjhM-Ss29N4VyFHzAgf_bYfnFoSDO9ukf_vaLd_";
		       test content =
		        		c.target(url)
		                .request(MediaType.APPLICATION_JSON)
		                .get(test.class);
		       
		   	double distance = content.getResourceSets().get(0).getResources().get(0).getTravelDistance();
			int travelDuration_op = content.getResourceSets().get(0).getResources().get(0).getTravelDuration();
			String trafficCongestion_op = content.getResourceSets().get(0).getResources().get(0).getTrafficCongestion();
			
			
			//voir detaille pour verif la dicission
			for (int j=0 ; j<tab.length;j++)
			{
				detaille=detaille+"--"+tab[j]+"-- \n";
			}
		       
		       
	        
		 	return  "ip : "+ ip+"\n "+"votre propre position est :  \n country :  "+country+"\n city :"+city+"\nregionName :"+regionName
		 			+"\n le magasin le plus proche de vous par rapport à votre propre position est :\n  "+"\n"+positionF+".."+L1.get(S)+" - -  - - de distance : "+distance+ "km"
		 			+
		 			"\n travel Duration ="+travelDuration_op+"s" +" \n traffic Congestion (embouteillage) :"+trafficCongestion_op+"\n *"+minVal+"***\n"+detaille;
		 	
	        //return  "hhh"+L.get(0)+"--"+L1.get(0); 
		 //	return  "ip : "+ ip+"\n "+"ton propre position est :  \n country :  "+country+"\n city :"+city+"\nregionName :"+regionName+content.getResourceSets().get(0).getResources().get(0).getTravelDistance();
		 	
	
		 	} catch (IOException e) { e.printStackTrace(); return "erreur"; }  
		
		
		
	}











	/*

	@Override
	public void affecterFixed_storeToRating_store(int idS, int idR)
	{
		// TODO Auto-generated method stub
		Rating_store R  = em.find(Rating_store.class, idR);
		Fixed_store F = em.find(Fixed_store.class, idS);

		R.setFixed_store(F);

	}
	 */

}
