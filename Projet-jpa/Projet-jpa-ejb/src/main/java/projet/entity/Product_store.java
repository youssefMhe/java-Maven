package projet.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity
public class Product_store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Product_storePK Product_storePK;

	@ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id", insertable=false, updatable=false)
	private Product Product;
	
	//idEmploye est a la fois primary key et foreign key
	@ManyToOne
    @JoinColumn(name = "idstore", referencedColumnName = "id", insertable=false, updatable=false)
	private Fixed_store Fixed_store;

	public Product_storePK getProduct_storePK() {
		return Product_storePK;
	}

	public void setProduct_storePK(Product_storePK product_storePK) {
		Product_storePK = product_storePK;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public Fixed_store getFixed_store() {
		return Fixed_store;
	}

	public void setFixed_store(Fixed_store fixed_store) {
		Fixed_store = fixed_store;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
