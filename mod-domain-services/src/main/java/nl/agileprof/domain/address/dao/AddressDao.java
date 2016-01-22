package nl.agileprof.domain.address.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import nl.agileprof.core.dao.AddressDaoInterface;
import nl.agileprof.domain.Address;

import org.apache.log4j.Logger;

@Stateless
@Local(AddressDaoInterface.class)
@Named
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AddressDao implements AddressDaoInterface {
	
	private static final String UNIT_NAME = "mod-datainteractie";

	/**
	 * Logger.
	 */
	protected final Logger log = Logger.getLogger(getClass());

	/** Entity manager. */
	@PersistenceContext(unitName = UNIT_NAME)
	protected EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	/* (non-Javadoc)
	 * @see nl.agileprof.domain.address.dao.AddressDaoInterface#findById(java.lang.Class, long)
	 */
	@Override
	public <T> T findById(Class<T> entityClass, long id) {
		return entityManager.find(entityClass, Long.valueOf(id));
	}
	
	/**
	 * Slaat een entiteit op in de database.
	 */
	public <C> C persist(C entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public Address findByPostcodeHousenumber(String zipcode, String housenumber) {
		TypedQuery<Address> query = entityManager.createQuery("select a from Address a where a.housenumber = :housenumber", Address.class);
//		query.setParameter("zipcode" , zipcode);
		query.setParameter("housenumber" , housenumber);
		return query.getSingleResult();
	}

}
