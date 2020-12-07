package projet.interfaces;

import java.io.IOException;
import java.util.List;

import javax.ejb.Remote;

import com.maxmind.geoip.Location;

import projet.entity.Fixed_store;
import projet.entity.Mobile_store;

@Remote
public interface Fixed_store_Interface {
	List<Fixed_store> getFixed_store();
	void addFixed_store(Fixed_store FS);
	void deleteFixed_storeById(int id);
	void updateFixed_store(Fixed_store FS);
	// void affecterFixed_storeToRating_store(int idS, int idR);
	
	int getnombrefixed_storebyCity(String name);//somme totale des M_store
	int getnombrefixed_store(); //somme total des store 

	
	String Lacalisationetlastway() ;

}
