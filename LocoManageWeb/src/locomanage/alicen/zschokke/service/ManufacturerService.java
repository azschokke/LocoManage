package locomanage.alicen.zschokke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Manufacturer;
import locomanage.alicen.zschokke.repositories.ManufacturerRepository;

@Service
public class ManufacturerService 
{
	private ManufacturerRepository mr; 
	
	@Autowired
	public ManufacturerService(ManufacturerRepository mr)
	{
		this.mr = mr; 
	}
	
	public Iterable<Manufacturer> getAll()
	{
		return mr.findAll(); 
	}
	
	public void add(Manufacturer m)
	{
		mr.save(m);
	}
	
	public Manufacturer get(Integer id)
	{
		return mr.findById(id).get(); 
	}
}	
