package locomanage.alicen.zschokke.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Chain;
import locomanage.alicen.zschokke.repositories.ChainRepository;

@Service
public class ChainService 
{
	private ChainRepository chainRepository; 
	
	@Autowired
	public ChainService(ChainRepository chainRepository)
	{
		this.chainRepository = chainRepository;
	}
	
	public List<Chain> getAll()
	{
		return chainRepository.findAll();
	}//end getAll(); 
	
	public Chain get(int id)
	{
		try
		{
			return chainRepository.findById(id).get();
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}//end get(id)
	
	public boolean update(Chain c)
	{
		try
		{
			Chain found = chainRepository.findById(c.getId()).get();
			found.setLocation(c.getLocation());
		}
		catch(NoSuchElementException e)
		{
			return false; 
		}
		return true; 
	}//end update(Chain c)
	
	public void remove(Chain c)
	{
		chainRepository.delete(c);
	}
	
}//end ChainService
