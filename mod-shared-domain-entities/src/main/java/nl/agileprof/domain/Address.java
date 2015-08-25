package nl.agileprof.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String zipcode;
	private String housenumber;
	private String street;
	
	public Long getId(){
		return id;
	}
	
	public String getPostalCode() {
		return zipcode;
	}
	public void setPostalCode(String postalCode) {
		this.zipcode = postalCode;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
