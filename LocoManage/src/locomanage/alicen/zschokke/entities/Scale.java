package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scale implements JSONable
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
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
		Scale other = (Scale) obj;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		return true;
	}
	
	
}//end Scale
