package projet.interfaces;

import java.util.List;

import javax.ejb.Remote;

import projet.entity.Plannig;
import projet.entity.Product;
@Remote

public interface Product_Interface {
	List<Product> getProduct();
	Product getProductbyid(int id);
	void addProduct(Product p);
	void deleteProductById(int id);
	void updateProduct(Product  p);
	void  createfileExel();
	void  updateProduct_From_Exel();
	
}