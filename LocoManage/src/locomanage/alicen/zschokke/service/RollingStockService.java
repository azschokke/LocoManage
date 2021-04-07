package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.repositories.RollingStockRepository;

@Service
public class RollingStockService 
{
	private RollingStockRepository rsr; 
	
	@Autowired
	public RollingStockService(RollingStockRepository rsr)
	{
		this.rsr = rsr; 
	}
	
	public Iterable<RollingStock> getAll()
	{
		return rsr.findAll(); 
	}//end getAll()
	
	public void add(RollingStock r)
	{
		rsr.save(r);
	}
	
	public RollingStock get(Integer id)
	{
		try
		{
			return rsr.findById(id).get(); 
		}
		catch(NoSuchElementException e)
		{
			return null; 
		}
	}
	
	public Iterable<RollingStock> getAvailable()
	{
		return this.rsr.findAvailable(); 
	}
	
	public void update(RollingStock rollingStock)
	{
		try
		{
			RollingStock found = this.rsr.findById(rollingStock.getId()).get();
			found.setCarNumber(rollingStock.getCarNumber());
			found.setInChain(rollingStock.getInChain());
			found.setLength(rollingStock.getLength());
			found.setModel(rollingStock.getModel());
			found.setNotes(rollingStock.getNotes());
			found.setOwner(rollingStock.getOwner());
			found.setProductInfo(rollingStock.getProductInfo());
		}//end try
		catch(NullPointerException | NoSuchElementException e){}	
		
	}//end update()
	
}//end RollingStockService
