package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.BidwarsProduct;

public class ProductDB {
	@SuppressWarnings("unchecked")
	public List<BidwarsProduct> getBidwarsProducts()
    {
        List<BidwarsProduct> products = null;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Query q = em.createQuery("Select u from User u");
        Query q = em.createNamedQuery("Product.findAll");
        products =  q.getResultList();
		
        tx.commit();
        em.close();
        return products;
    }
	
	public BidwarsProduct find(String name)
    {
    	BidwarsProduct product = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("Select p from BidwarsProduct p where p.name = :name");
        q.setParameter("name", name);        
        List products =  q.getResultList();
        tx.commit();
        em.close();
        
        if (products != null && products.size() == 1)
        {
            product = (BidwarsProduct) products.get(0);
        }

        return product;
        
    }
	
	public int insertProduct(BidwarsProduct product)
    {
        int id = -1;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try 
        {
            em.persist(product);
            em.flush();
            id = product.getId();
            tx.commit();
            return id;
        }
        catch (PersistenceException e)
        {
            if (tx.isActive()) tx.rollback();
            return id;
        }
        finally 
        {
            em.close();
        }
    }
	public BidwarsProduct getById(int id)
    {
		BidwarsProduct product = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        product =em.find(BidwarsProduct.class, id);
	
        tx.commit();
        em.close();
        
        
        return product;
        
    }
}
