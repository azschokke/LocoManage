package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Model 
{
	@Id
	private int id; 
	private String name; 
	@ManyToOne
	private Classification classification; 
	
	public Model() {}
	
	public Model(String name, Classification classification)
	{
		this.setName(name);
		this.setClassification(classification);
	}
	
	public int getInt()
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
	
	public Classification getClassification()
	{
		return this.classification; 
	}
	
	public void setClassification(Classification classification)
	{
		this.classification = classification; 
	}
}//end 
