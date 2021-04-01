package locomanage.alicen.zschokke.service;

import java.util.List;

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
	
	public List<RollingStock> getAll()
	{
		return rsr.findAll(); 
	}//end getAll()
}//end RollingStockService
