package locomanage.alicen.zschokke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Scale;
import locomanage.alicen.zschokke.repositories.ScaleRepository;

@Service
public class ScaleService 
{
	private ScaleRepository scaleRepository; 
	
	@Autowired
	public ScaleService(ScaleRepository scaleRepository)
	{
		this.scaleRepository = scaleRepository; 
	}
	
	public Iterable<Scale> getAll()
	{
		return scaleRepository.findAll();
	}
	
	public void add(Scale s)
	{
		scaleRepository.save(s);
	}
}//end ScaleService
