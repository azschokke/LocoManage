package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classification 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; //unique id
	@Column(nullable = false)
	private String name; //name of this classification
	
	//TODO javadoc
	public Classification() {}
	
	//TODO javadoc
	public Classification(String name)
	{
		this.setName(name);
	}
	
	//TODO javadoc
	public int getId()
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
	
}//end Classification
