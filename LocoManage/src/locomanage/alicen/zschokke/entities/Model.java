package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * This class represents a RollingStock model
 * @author Alicen Zschokke
 */
@Entity
public class Model implements JSONable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; //unique id
	
	@Column(nullable = false)
	private String name; //model name
	
	@JoinColumn(nullable = false, name="c_id")
	@ManyToOne
	private Classification classification; //model classification
	
	/**
	 * Creates an empty model.
	 */
	public Model() {}
	
	/**
	 * Creates a model with the given name and classification
	 * @param name the name of the model
	 * @param classification the Classification of this model
	 */
	public Model(String name, Classification classification)
	{
		this.setName(name);
		this.setClassification(classification);
	}
	
	/**
	 * Accessor for the unique id of this Model
	 * @return the Integer id of this Model
	 */
	public Integer getId()
	{
		return this.id; 
	}
	
	/**
	 * Mutator for the name of this Model
	 * @return the name of this Model
	 */
	public String getName()
	{
		return this.name; 
	}
	
	/**
	 * Mutator for the name of this Model
	 * @param name the new name of this Model
	 */
	public void setName(String name)
	{
		this.name = name; 
	}
	
	/**
	 * Accessor for the Classification of this Model
	 * @return the Classification of this Model
	 */
	public Classification getClassification()
	{
		return this.classification; 
	}
	
	/**
	 * Mutator for the Classification of this Model
	 * @param classification the new Classification of this model
	 */
	public void setClassification(Classification classification)
	{
		this.classification = classification; 
	}
	
	/**
	 * Determines if this Object and the parameter object are equal 
	 * @return true if they are equal, otherwise false 
	 */
	@Override
	public boolean equals(Object m)
	{
		if(m instanceof Model)
		{
			return this.getName().equals(((Model ) m ).getName()) && this.getClassification().equals(((Model ) m ).getClassification()); 
		}
		return false; 
	}//end equals
	
	/**
	 * Creates a Json representation of this Model
	 */
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ",\"name\": \"" + this.getName() + "\", \"classification\":" + this.getClassification().toJSON() + "}"; 
	}
}//end 
