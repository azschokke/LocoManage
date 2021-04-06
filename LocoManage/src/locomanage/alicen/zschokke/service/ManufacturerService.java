package locomanage.alicen.zschokke.service;

import java.util.NoSuchElementException;

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
	
	public void update(Manufacturer m)
	{
		try
		{
			Manufacturer found = this.manufacturerRepository.findById(m.getId()).get();
			found.setName(m.getName());
			this.manufacturerRepository.save(found);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No match found for id " + m.getId());
		}
	}//end update
	
	public void remove(Integer id)
	{
		try
		{
			this.manufacturerRepository.delete(this.manufacturerRepository.findById(id).get());
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No match found for id " + id);
		}
	}
}//end ManufacturerService
