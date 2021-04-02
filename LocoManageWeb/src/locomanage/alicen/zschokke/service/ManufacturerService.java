package locomanage.alicen.zschokke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Manufacturer;
import locomanage.alicen.zschokke.repositories.ManufacturerRepository;

@Service
public class ManufacturerService 
{
	private ManufacturerRepository manufacturerRepository; 
	
	@Autowired
	public ManufacturerService(ManufacturerRepository manufacturerRepository)
	{
		this.manufacturerRepository = manufacturerRepository; 
	}
	
	public Iterable<Manufacturer> getAll()
	{
		return manufacturerRepository.findAll(); 
	}
	
	public void add(Manufacturer m)
	{
		manufacturerRepository.save(m);
	}
	
	public Manufacturer get(Integer id)
	{
		return manufacturerRepository.findById(id).get(); 
	}
}	
