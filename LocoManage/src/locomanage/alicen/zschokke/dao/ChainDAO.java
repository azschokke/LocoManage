package locomanage.alicen.zschokke.dao;

import java.util.List;

import locomanage.alicen.zschokke.db_access.DBAccess;
import locomanage.alicen.zschokke.entities.Chain;

public class ChainDAO extends DBAccess implements DAOI<Chain>
{
	//TODO javadoc
	@Override
	public void add(Chain c) 
	{
		this.connect(); 
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit(); 
		this.disconnect(); 
	}//end add(c)

	//TODO javadoc
	@Override
	public Chain get(int id)
	{
		this.connect(); 
		Chain c = em.find(Chain.class, id);
		this.disconnect(); 
		return c;
	}//end get(id)

	//TODO javadoc
	@Override
	public void update(Chain c) 
	{
		this.connect(); 
		Chain f = em.find(Chain.class, c.getId());
		f.setChain(c.getChain());
		f.setLocation(c.getLocation());
		this.disconnect(); 
	}//end update(c)

	//TODO javadoc
	@Override
	public void remove(int id) 
	{
		this.connect();
		em.remove(em.find(Chain.class, id));
		this.disconnect(); 
	}//end remove(id)

	//TODO javadoc
	@Override
	public List<Chain> getAll() {
		this.connect();
		@SuppressWarnings("unchecked")
		List<Chain> chains = em.createNamedQuery("getAllChains").getResultList();
		this.disconnect(); 
		return chains;
	}

}
