package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//TODO javadoc comments
@Entity
public class Manufacturer implements JSONable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	@Column
	private String name; 
	
	public Manufacturer() {}
	
	public Manufacturer(String name)
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
		return "{\"id\": " + this.getId() + ",\"name\": \"" + this.getName() + "\"}"; 
	}
}//end class Manufacturer
