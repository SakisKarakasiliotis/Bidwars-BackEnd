package db;

import entities.BidwarsUser;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


public class UserDB {

    
    @SuppressWarnings("unchecked")
	public List<BidwarsUser> getBidwarsUsers()
    {
        List<BidwarsUser> users = null;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("SELECT b FROM BidwarsUser b");
//        Query q = em.createNamedQuery("User.findAll");
        users =  q.getResultList();
		
        tx.commit();
        em.close();
        return users;
    }
    
    public BidwarsUser find(String username, String password)
    {
    	BidwarsUser user = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("Select u from BidawarsUser u where u.username = :username and u.password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
		List<?> users =  q.getResultList();
        tx.commit();
        em.close();
        
        if (users != null && users.size() == 1)
        {
            user = (BidwarsUser) users.get(0);
        }

        return user;
        
    }
    
    public int insertUser(BidwarsUser user)
    {
        int id = -1;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try 
        {
            em.persist(user);
            em.flush();
            id = user.getId();
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
    
    public BidwarsUser getById(int id)
    {
    	BidwarsUser user = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        user =em.find(BidwarsUser.class, id);
	
        tx.commit();
        em.close();
        
        
        return user;
        
    }
    
}
