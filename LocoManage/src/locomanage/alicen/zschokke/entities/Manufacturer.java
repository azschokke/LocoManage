package locomanage.alicen.zschokke.entities;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class models a RollingStock Manufacturer
 * @author cena-
 *
 */
@Entity
public class Manufacturer implements JSONable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	@Column
	private String name; 
	
	/**
	 * Creates an empty Manufacturer
	 */
	public Manufacturer() {}
	
	/**
	 * Creates a manufacturer with the given name 
	 * @param name the name of this manufacturer
	 */
	public Manufacturer(String name)
	{
		this.setName(name);
	}
	
	/**
	 * Creates a manufacturer with the fields from the HashMap
	 * @param json the HashMap generated from Json
	 */
	public Manufacturer(HashMap<String, Object> json)
	{
		this.id = (int) Double.parseDouble(json.get("id").toString());
		this.setName(json.get("name").toString()); 
	}//end Manufacturer(json)
	
	/**
	 * Accessor for the unique Id of this manufacturer
	 * @return the Integer id of this manufacturer
	 */
	public Integer getId()
	{
		return this.id; 
	}
	
	/**
	 * Accessor for the name of this manufacturer
	 * @return the name of this manufacturer
	 */
	public String getName()
	{
		return this.name; 
	}
	
	/**
	 * Mutator for the name of this manufacturer
	 * @param name the new name of this manufacturer
	 */
	public void setName(String name)
	{
		this.name = name; 
	}
	
	/**
	 * Creates a Json representation of this Manufacturer
	 */
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ",\"name\": \"" + this.getName() + "\"}"; 
	}

	/**
	 * Generates the hashcode for this manufacturer
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Determines if this object and the parameter object are equal. 
	 * @return true if they are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manufacturer other = (Manufacturer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}//end class Manufacturer
