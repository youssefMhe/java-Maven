package projet.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Plannig")

public class Plannig  implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Id")
	int id;

	@Column(name="City")
	String city;
	@Column(name="Street")
	String street;
	@Column(name="Description")
	String description;
	@Column(name="Name")
	String name;

	@Column(name="Program_object")
	String program_object;
	
	@Column(name="Date_Begin")
	Date date_Begin;

	@Column(name="Date_Ending")
	Date date_Ending;


	
	
	@ManyToOne
	Mobile_store Mobile_stores;




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




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




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getProgram_object() {
		return program_object;
	}




	public void setProgram_object(String program_object) {
		this.program_object = program_object;
	}




	public Date getDate_Begin() {
		return date_Begin;
	}




	public void setDate_Begin(Date date_Begin) {
		this.date_Begin = date_Begin;
	}




	public Date getDate_Ending() {
		return date_Ending;
	}




	public void setDate_Ending(Date date_Ending) {
		this.date_Ending = date_Ending;
	}




	public Mobile_store getMobile_stores() {
		return Mobile_stores;
	}




	public void setMobile_stores(Mobile_store mobile_stores) {
		Mobile_stores = mobile_stores;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Mobile_stores == null) ? 0 : Mobile_stores.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((date_Begin == null) ? 0 : date_Begin.hashCode());
		result = prime * result + ((date_Ending == null) ? 0 : date_Ending.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((program_object == null) ? 0 : program_object.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		Plannig other = (Plannig) obj;
		if (Mobile_stores == null) {
			if (other.Mobile_stores != null)
				return false;
		} else if (!Mobile_stores.equals(other.Mobile_stores))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (date_Begin == null) {
			if (other.date_Begin != null)
				return false;
		} else if (!date_Begin.equals(other.date_Begin))
			return false;
		if (date_Ending == null) {
			if (other.date_Ending != null)
				return false;
		} else if (!date_Ending.equals(other.date_Ending))
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
		if (program_object == null) {
			if (other.program_object != null)
				return false;
		} else if (!program_object.equals(other.program_object))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}



	
	

}
