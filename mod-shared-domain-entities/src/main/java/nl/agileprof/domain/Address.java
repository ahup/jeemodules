package nl.agileprof.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String housenumber;
	private String street;

	@OneToMany(fetch=FetchType.LAZY)
	private List<ZipCode> zipCodes;
	
	public Long getId(){
		return id;
	}
	
	public List<ZipCode> getZipCodes(){
		return Collections.unmodifiableList(zipCodes);
	}
	
	public void setZipCodes(List<ZipCode> zipCodes) {
		this.zipCodes = zipCodes;
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
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
			buf.append("Address:\n" + street + "\n") ;
			for (Iterator<ZipCode> iterator = zipCodes.iterator(); iterator.hasNext();) {
				ZipCode zipCode = iterator.next();
				buf.append(zipCode.getCode() + "\n");
				
			}
			return buf.toString();
	}
}
