package nl.agileprof.mod;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;

import nl.agileprof.core.TestEJBInterface;
import nl.agileprof.core.dao.AddressDaoInterface;
import nl.agileprof.domain.Address;

@Stateless
@Local(TestEJBInterface.class)
@Named
public class TestEJB implements TestEJBInterface {
	
	@EJB
	private AddressDaoInterface addressDao;
	
	public String test() {
		String zipcode="1111AA";
		String housenumber = "1";
		Address address = addressDao.findByPostcodeHousenumber(zipcode, housenumber);
		return "Address\n street: " + address.getStreet();
	}
	
}
