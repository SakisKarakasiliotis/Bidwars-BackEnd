package db;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.BidwarsCategory;

public class CategoryDB {
	@SuppressWarnings("unchecked")
	public List<BidwarsCategory> getBidwarsCategories()
    {
        List<BidwarsCategory> categories = null;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Query q = em.createQuery("Select u from User u");
        Query q = em.createNamedQuery("Category.findAll");
        categories =  q.getResultList();
		
        tx.commit();
        em.close();
        return categories;
    }
	public BidwarsCategory find(String name)
    {
		BidwarsCategory category = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("Select p from BidwarsCategory p where p.name = :name");
        q.setParameter("name", name);        
        List categories =  q.getResultList();
        tx.commit();
        em.close();
        
        if (categories != null && categories.size() == 1)
        {
        	category = (BidwarsCategory) categories.get(0);
        }

        return category;
        
    }
	public int insertCategory(BidwarsCategory category)
    {
        int id = -1;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try 
        {
            em.persist(category);
            em.flush();
            id = category.getId();
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
	public BidwarsCategory getById(int id)
    {
		BidwarsCategory category = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        category =em.find(BidwarsCategory.class, id);
	
        tx.commit();
        em.close();
        
        
        return category;
        
    }
}
