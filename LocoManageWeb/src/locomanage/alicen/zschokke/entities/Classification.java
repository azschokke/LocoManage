package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Classification 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //unique id
	@Column
	private String name; //name of this classification
	
	//TODO javadoc
	public Classification() {}
	
	//TODO javadoc
	public Classification(String name)
	{
		this.setName(name);
	}
	
	//TODO javadoc
	public Integer getId()
	{
		return this.id;
	}
	
	//TODO javadoc
	public String getName()
	{
		return this.name;
	}
	
	//TODO javadoc
	public void setName(String name)
	{
		this.name = name.trim().toUpperCase(); 
	}
	
	//TODO javadoc
	public String toString()
	{
		return this.getName(); 
	}
	
	//TODO javadoc
	@Override
	public boolean equals(Object c)
	{
		if(c instanceof Classification)
		{
			return this.getName().equals(((Classification) c).getName());
		}
		return false; 
	}//end equals
	
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ", \"name\":\"" + this.getName() + "\"}" ;
	}
}//end Classification
