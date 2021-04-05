package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scale 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; 
	@Column
	private String scale; 
	
	public Scale() {}
	
	public Scale(String scale)
	{
		this.setScale(scale);
	}//end Scale(scale)
	
	public Integer getId()
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
	
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ", \"name\":\"" + this.getScale() + "\"}";
	}
}//end Scale
