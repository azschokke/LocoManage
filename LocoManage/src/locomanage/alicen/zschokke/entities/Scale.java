package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class models a Scale of a RollingStock item
 * @author Alicen Zschokke
 *
 */
@Entity
public class Scale implements JSONable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; 
	@Column
	private String scale; 
	
	/**
	 * Creates a new empty scale.
	 */
	public Scale() {}
	
	/**
	 * Creates a new scale with the given scale name
	 * @param scale the scale
	 */
	public Scale(String scale)
	{
		this.setScale(scale);
	}//end Scale(scale)
	
	/**
	 * Accessor for the unique id of this scale
	 * @return the id of this scale
	 */
	public Integer getId()
	{
		return this.id; 
	}//end getId()
	
	/**
	 * Accessor for the name of this scale
	 * @return the name of this scale
	 */
	public String getScale()
	{
		return this.scale; 
	}//end getScale()
	
	/**
	 * Mutator for the name of this scale
	 * @param scale the new name of this scale
	 */
	public void setScale(String scale)
	{
		this.scale = scale; 
	}//end setScale(scale)
	
	/**
	 * Creates a Json representation of this scale.
	 * @return a String representing a Json object
	 */
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ", \"name\":\"" + this.getScale() + "\"}";
	}

	/**
	 * Generates the hashCode for this scale
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		return result;
	}

	/**
	 * Determines if the parameter object is equal to this object.
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
		Scale other = (Scale) obj;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		return true;
	}
	
	
}//end Scale
