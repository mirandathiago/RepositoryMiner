package org.visminer.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.visminer.model.Committer;
import org.visminer.model.Repository;

public class CommitterDAO{
	
	private Connection connection = Connection.getInstance();
	
	public Committer save(Committer committer){
		
		EntityManager em = connection.getEntityManager();
		em.getTransaction().begin();
		committer = em.merge(committer);
		em.getTransaction().commit();
		em.close();
		return committer;
		
	}
	
	public List<Committer> getByRepository(Repository repository){
		
		EntityManager em = connection.getEntityManager();
		TypedQuery<Committer> query = em.createQuery("select c from Committer c where c.repository.idrepository=:arg1", Committer.class);
		query.setParameter("arg1", repository.getIdrepository());
		
		try{
			return query.getResultList();
		}catch(NoResultException e){
			return null;
		}
		
	}
	
}
