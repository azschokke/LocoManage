package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//TODO javadoc comments
@Entity
public class Manufacturer 
{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	private String name; 
	
	public Manufacturer() {}
	
	public Manufacturer(String name)
	{
		this.setName(name);
	}
	
	public int getId()
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
}//end class Manufacturer
