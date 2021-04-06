package locomanage.alicen.zschokke.entities;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Railroad implements JSONable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; 
	@Column
	private String name; 
	
	public Railroad() {}
	
	public Railroad(String name)
	{
		this.setName(name);
	}
	
	public Railroad(HashMap<String, Object> json)
	{
		this.id = (int) Double.parseDouble(json.get("id").toString());
		this.setName(json.get("name").toString()); 
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
