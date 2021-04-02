package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Railroad 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; 
	private String name; 
	
	public Railroad() {}
	
	public Railroad(String name)
	{
		this.setName(name);
	}
	
	public Integer getId()
	{
		return this.id; 
	}
	
	public String getName()
	{
		return this.name; 
	}
	
	public void setName(String name)
	{
		this.name = name; 
	}
	
	public String toJSON()
	{
		return "{ \"id\": " + this.getId() + ", \"name\" : \"" + this.getName() + "\"}"; 
	}
	
}//end Railroad
