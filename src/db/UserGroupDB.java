package db;

import entities.BidwarsUserGroup;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class UserGroupDB {
	@SuppressWarnings("unchecked")
	public List<BidwarsUserGroup> getBidwarsUserGroups()
    {
        List<BidwarsUserGroup> usergroups = null;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Query q = em.createQuery("Select u from User u");
        Query q = em.createNamedQuery("UserGroup.findAll");
        usergroups =  q.getResultList();
		
        tx.commit();
        em.close();
        return usergroups;
    }
	
    public BidwarsUserGroup find(String name)
    {
    	BidwarsUserGroup usegroup = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("Select u from BidawarsUserGroup u where u.name = :name");
        q.setParameter("name", name);
        List<?> usegroups =  q.getResultList();
        tx.commit();
        em.close();
        
        if (usegroups != null && usegroups.size() == 1)
        {
        	usegroup = (BidwarsUserGroup) usegroups.get(0);
        }

        return usegroup;
        
    }
    public int insertUserGroup(BidwarsUserGroup usergroup)
    {
        int id = -1;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try 
        {
            em.persist(usergroup);
            em.flush();
            id = usergroup.getId();
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
    public BidwarsUserGroup getById(int id)
    {
    	BidwarsUserGroup usergroup = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        usergroup =em.find(BidwarsUserGroup.class, id);
	
        tx.commit();
        em.close();
        
        
        return usergroup;
        
    }
    
}
