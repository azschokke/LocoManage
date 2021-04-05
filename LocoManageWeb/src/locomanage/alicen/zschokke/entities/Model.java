package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Model 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; //unique id
	
	@Column(nullable = false)
	private String name; //model name
	
	@JoinColumn(nullable = false, name="c_id")
	@ManyToOne
	private Classification classification; //model classification
	
	//TODO javadoc
	public Model() {}
	
	//TODO javadoc
	public Model(String name, Classification classification)
	{
		this.setName(name);
		this.setClassification(classification);
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
		this.name = name; 
	}
	
	//TODO javadoc
	public Classification getClassification()
	{
		return this.classification; 
	}
	
	//TODO javadoc
	public void setClassification(Classification classification)
	{
		this.classification = classification; 
	}
	
	//TODO javadoc
	@Override
	public boolean equals(Object m)
	{
		if(m instanceof Model)
		{
			return this.getName().equals(((Model ) m ).getName()) && this.getClassification().equals(((Model ) m ).getClassification()); 
		}
		return false; 
	}//end equals
	
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ",\"name\": \"" + this.getName() + "\", \"classification\":" + this.getClassification().toJSON() + "}"; 
	}
}//end 
