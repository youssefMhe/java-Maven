package projet.entity;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Fixed_store")


public class Fixed_store  extends Store implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="City")
	String city;
	@Column(name="Street")
	String street;
	@Column(name="Hour_B")
	Time hour_B;
	@Column(name="Hour_E")
	Time hour_E;
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="Fixed_store")
	private List<Product_store> Product_store;


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Time getHour_B() {
		return hour_B;
	}


	public void setHour_B(Time hour_B) {
		this.hour_B = hour_B;
	}


	public Time getHour_E() {
		return hour_E;
	}


	public void setHour_E(Time hour_E) {
		this.hour_E = hour_E;
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
		int result = super.hashCode();
		result = prime * result + ((Product_store == null) ? 0 : Product_store.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((hour_B == null) ? 0 : hour_B.hashCode());
		result = prime * result + ((hour_E == null) ? 0 : hour_E.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fixed_store other = (Fixed_store) obj;
		if (Product_store == null) {
			if (other.Product_store != null)
				return false;
		} else if (!Product_store.equals(other.Product_store))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (hour_B == null) {
			if (other.hour_B != null)
				return false;
		} else if (!hour_B.equals(other.hour_B))
			return false;
		if (hour_E == null) {
			if (other.hour_E != null)
				return false;
		} else if (!hour_E.equals(other.hour_E))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
