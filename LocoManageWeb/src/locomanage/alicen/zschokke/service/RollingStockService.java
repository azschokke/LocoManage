package locomanage.alicen.zschokke.service;

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
}//end RollingStockService
