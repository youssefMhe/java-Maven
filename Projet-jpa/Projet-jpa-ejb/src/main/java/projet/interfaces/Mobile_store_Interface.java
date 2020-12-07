package projet.interfaces;

import java.util.List;

import javax.ejb.Remote;


import projet.entity.Mobile_store;
@Remote
public interface Mobile_store_Interface {
	List<Mobile_store> getMobile_store();
	void addMobile_store(Mobile_store m);
	void deleteMobile_storeById(int id);
	void updateMobile_store(Mobile_store m);
	
	
	
	
}
