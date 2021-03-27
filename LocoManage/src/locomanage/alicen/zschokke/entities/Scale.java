package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scale 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	private String scale; 
	
	public Scale() {}
	
	public Scale(String scale)
	{
		this.setScale(scale);
	}//end Scale(scale)
	
	public int getId()
	{
		return this.id; 
	}//end getId()
	
	public String getScale()
	{
		return this.scale; 
	}//end getScale()
	
	public void setScale(String scale)
	{
		this.scale = scale; 
	}//end setScale(scale)
	
}//end Scale
