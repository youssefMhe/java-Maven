package projet.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="ID")
	int id;
	@Column(name="Name")
	String name;
	
	@Column(name="Picture")
	String picture;
	@Column(name="Code_AB")
	int code_AB;
	
	@Column(name="Type")
	String type;
	@Column(name="Description")
	String description;
	
	@Column(name="Price")
	Float price;
	@Column(name="Quantity")
	int quantity;
	
	@Column(name="TVA")
	Float tva;
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="Product")
	private List<Product_store> Product_store;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	public int getCode_AB() {
		return code_AB;
	}


	public void setCode_AB(int code_AB) {
		this.code_AB = code_AB;
	}

	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}

	 
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public Float getTva() {
		return tva;
	}


	public void setTva(Float tva) {
		this.tva = tva;
	}

	@JsonIgnore 
	public List<Product_store> getProduct_store() {
		return Product_store;
	}


	public void setProduct_store(List<Product_store> product_store) {
		Product_store = product_store;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Product_store == null) ? 0 : Product_store.hashCode());
		result = prime * result + code_AB;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((tva == null) ? 0 : tva.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Product other = (Product) obj;
		if (Product_store == null) {
			if (other.Product_store != null)
				return false;
		} else if (!Product_store.equals(other.Product_store))
			return false;
		if (code_AB != other.code_AB)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		if (tva == null) {
			if (other.tva != null)
				return false;
		} else if (!tva.equals(other.tva))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	


	

}
