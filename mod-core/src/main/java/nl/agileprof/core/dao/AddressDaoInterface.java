package nl.agileprof.core.dao;

import nl.agileprof.domain.Address;


public interface AddressDaoInterface {

	/**
	 * Zoekt een entity op aan de hand van zijn id.
	 * 
	 * @param entityClass
	 *            het type entity waarop gezocht moet worden.
	 * @param id
	 *            het id van de entity.
	 * @return de gevonden entity of <code>null</code>.
	 */
	<T> T findById(Class<T> entityClass, long id);
	
	Address findByPostcodeHousenumber(String zipcode, String housenumber);
}