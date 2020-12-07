package projet.interfaces;
import java.util.List;

import javax.ejb.Remote;
import projet.entity.*;


@Remote
public interface Product_store_interface {
	void addProduct_store(int  idP, int idF);
	
	public  List<Product> findallproduitofFixedstore(int id) ;
}
