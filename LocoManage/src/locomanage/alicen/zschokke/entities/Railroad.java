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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Railroad other = (Railroad) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}//end Railroad
