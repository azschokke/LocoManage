package locomanage.alicen.zschokke.entities;

import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Models the classification, or type, of a Rolling Stock item. 
 * @author Alicen Zschokke
 */
@Entity
public class Classification implements JSONable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //unique id
	@Column
	private String name; //name of this classification
	
	/**
	 * Default no-arg constructor, creates an empty Classification
	 */
	public Classification() {}
	
	/**
	 * Creates a Classification with the parameter name
	 * @param name the name of the classification
	 */
	public Classification(String name)
	{
		this.setName(name);
	}
	
	/**
	 * Creates a Classification object from a HashMap - result from Gson.fromJson
	 * @param classification a HashMap containing the information from a JSON classification object
	 */
	public Classification(HashMap<String, Object> classification)
	{
		this.id = ((Double) classification.get("id")).intValue();
		this.setName(classification.get("name").toString());
	}
	
	/**
	 * Accessor for the unique id of this classification
	 * @return the id of this classification
	 */
	public Integer getId()
	{
		return this.id;
	}
	
	/**
	 * Accessor for the name of this classification
	 * @return the name of this classification
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Mutator for the name of this classification
	 * @param name the new name of this classification
	 */
	public void setName(String name)
	{
		this.name = name.trim().toUpperCase(); 
	}
	
	/**
	 * @return a String representation of this classification
	 */
	public String toString()
	{
		return this.getName(); 
	}
	
	/**
	 * Determines if the parameter object is equal to this object
	 * @return true if they are equal, otherwise false
	 */
	@Override
	public boolean equals(Object c)
	{
		if(c instanceof Classification)
		{
			return this.getName().equals(((Classification) c).getName());
		}
		return false; 
	}//end equals
	
	/**
	 * Converts this classification to a Json object.
	 * @return a String representing a Json object of this classification
	 */
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ", \"name\":\"" + this.getName() + "\"}" ;
	}
}//end Classification
