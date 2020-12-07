package projet.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import projet.entity.*;
import projet.interfaces.Product_store_interface;


@Stateless
@LocalBean
public class Product_store_Service implements Product_store_interface {
	@PersistenceContext(unitName = "jee-ejb") 
	EntityManager em;
	
	@Override
	public void addProduct_store(int  idP, int idF) {
		
		
		
		// TODO Auto-generated method stub
Product_storePK Product_storePK =new Product_storePK();
Product_storePK.setIdstore(idF);
Product_storePK.setIdProduct(idP);

Product_store Product_store = new Product_store();
Product_store.setProduct_storePK(Product_storePK);


em.persist(Product_store);
	}
	
	
	
	
	

	@Override
	public List<Product> findallproduitofFixedstore(int idFixedstore) {
TypedQuery<Product> query = em.createQuery("select DISTINCT m from Product m join m.Product_store t join t.Fixed_store e where e.id=:idstore",Product.class);
query.setParameter("idstore", idFixedstore);
		return query.getResultList();
	}

}
