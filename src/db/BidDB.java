package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import entities.BidwarsBid;

public class BidDB {
	@SuppressWarnings("unchecked")
	public List<BidwarsBid> getBidwarsBids()
    {
        List<BidwarsBid> bids = null;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Query q = em.createQuery("Select u from User u");
        Query q = em.createNamedQuery("Bid.findAll");
        bids =  q.getResultList();
		
        tx.commit();
        em.close();
        return bids;
    }
	public BidwarsBid find(int id)
    {
		BidwarsBid bid = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("Select p from BidwarsBid p where p.id = :id");
        q.setParameter("id", id);        
        List bids =  q.getResultList();
        tx.commit();
        em.close();
        
        if (bids != null && bids.size() == 1)
        {
        	bid = (BidwarsBid) bids.get(0);
        }

        return bid;
        
    }
	public int insertBid(BidwarsBid bid)
    {
        int id = -1;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try 
        {
            em.persist(bid);
            em.flush();
            id = bid.getId();
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
	public BidwarsBid getById(int id)
    {
		BidwarsBid bid = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        bid =em.find(BidwarsBid.class, id);
	
        tx.commit();
        em.close();
        
        
        return bid;
        
    }
}
