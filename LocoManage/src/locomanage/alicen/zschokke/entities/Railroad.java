package locomanage.alicen.zschokke.entities;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class models a Railroad
 * @author Alicen Zschokke
 */
@Entity
public class Railroad implements JSONable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; 
	@Column
	private String name; 
	
	/**
	 * Creats an empty Railroad. 
	 */
	public Railroad() {}
	
	/**
	 * Creates a Railroad with the given name
	 * @param name the name of the Railroad
	 */
	public Railroad(String name)
	{
		this.setName(name);
	}
	
	/**
	 * Creates a railroad from a HashMap containing the fields for this Railroad
	 * @param json the HashMap generated from Gson.fromJson()
	 */
	public Railroad(HashMap<String, Object> json)
	{
		this.id = (int) Double.parseDouble(json.get("id").toString());
		this.setName(json.get("name").toString()); 
	}
	
	/**
	 * Accessor for the unique id of this railroad
	 * @return the Integer id of this railroad
	 */
	public Integer getId()
	{
		return this.id; 
	}
	
	/**
	 * Accessor for the name of this railroad
	 * @return the name of this railroad
	 */
	public String getName()
	{
		return this.name; 
	}
	
	/**
	 * Mutator for the name of this railroad.
	 * @param name the new name of this railroad
	 */
	public void setName(String name)
	{
		this.name = name; 
	}
	
	/**
	 * Returns a Json representation of this Railroad
	 * @return a String representation of a Json object
	 */
	public String toJSON()
	{
		return "{ \"id\": " + this.getId() + ", \"name\" : \"" + this.getName() + "\"}"; 
	}

	/**
	 * Generates a hashcode for this Railroad
	 * @return the hashcode of this Railroad
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Determines if this object is equal to the parameter object.
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
		Railroad other = (Railroad) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}//end Railroad
