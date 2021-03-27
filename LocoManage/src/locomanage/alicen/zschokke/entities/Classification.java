package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classification 
{
	@Id
	private int id; 
	private String name; 
	
	public Classification() {}
	
	public Classification(String name)
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
}//end Classification
