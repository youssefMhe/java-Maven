package projet.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Product_storePK implements Serializable {
	
     private int idProduct;
	
	private int idstore;



	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getIdstore() {
		return idstore;
	}

	public void setIdstore(int idstore) {
		this.idstore = idstore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduct;
		result = prime * result + idstore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product_storePK other = (Product_storePK) obj;
		if (idProduct != other.idProduct)
			return false;
		if (idstore != other.idstore)
			return false;
		return true;
	}
	
	
}
