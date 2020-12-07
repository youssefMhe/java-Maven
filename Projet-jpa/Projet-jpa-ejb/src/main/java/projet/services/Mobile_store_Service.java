package projet.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import projet.entity.Mobile_store;
import projet.interfaces.Mobile_store_Interface;
@Stateless
@LocalBean
public class Mobile_store_Service implements Mobile_store_Interface {
	@PersistenceContext(unitName = "jee-ejb") 
	EntityManager em;

	/**
	 * Default constructor. 
	 */
	public Mobile_store_Service() {

	}
	@Override
	public List<Mobile_store> getMobile_store() {
		return (List<Mobile_store>) em.createQuery(" select c from Mobile_store c ",Mobile_store.class).getResultList();
	}

	@Override
	public void addMobile_store(Mobile_store m) {
		em.persist(m);

	}

	@Override
	public void deleteMobile_storeById(int id) {
		Mobile_store c = em.find(Mobile_store.class, id);
		em.remove(c);

	}

	@Override
	public void updateMobile_store(Mobile_store m) {
		Mobile_store Mobile_storeToUpdade = em.find(Mobile_store.class, m.getId());
		Mobile_storeToUpdade.setEmail(m.getEmail());
		Mobile_storeToUpdade.setName_store(m.getName_store());
		Mobile_storeToUpdade.setPhone(m.getPhone());
		Mobile_storeToUpdade.setPicture(m.getPicture());
		Mobile_storeToUpdade.setService(m.getService());
		Mobile_storeToUpdade.setValid(m.getValid());


	}

}
