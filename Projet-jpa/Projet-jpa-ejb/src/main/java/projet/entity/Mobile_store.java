package projet.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Mobile_store")


public class Mobile_store extends Store implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="Valid")
	String valid;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Mobile_stores")
	private Set<Plannig> Plannigs;
	
	
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
