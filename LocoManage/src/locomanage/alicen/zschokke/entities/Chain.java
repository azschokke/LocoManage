package locomanage.alicen.zschokke.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class models a chain of rolling stock linked together.
 * @author Alicen Zschokke
 */
@Entity
public class Chain implements JSONable
{
	//TODO comment these 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity = RollingStock.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "carId")
	private Set chain; 
	
	@ManyToOne
	private Location location; 
	
	@Column
	private String name; 
	
	@Column
	private Integer userId; 
	
	/**
	 * Creates an empty chain. 
	 */
	public Chain()
	{
		chain = new HashSet<RollingStock>(); 
	}//end Chain()
	
	public Chain(String name)
	{
		this.name = name; 
		chain = new HashSet<RollingStock>(); 
	}

	/**
	 * Returns a list of the <b>Train Cars</b> in this Chain. 
	 * @return a list of the train cars in this chain. 
	 */
	public Set<RollingStock> getChain() 
	{
		return chain;
	}//end getChain

	/**
	 * TODO do i really want this? 
	 * @param chain
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setChain(Set chain) 
	{
		for(Object c : chain)
		{
			this.chain.add(c);
		}
	}
	
	/**
	 * Adds a RollingStock item to this chain. 
	 * @param the RollingStock item to add
	 */
	@SuppressWarnings("unchecked")
	public boolean addRollingStock(RollingStock car)
	{
		return ((this.chain.add(car)) ? car.setInChain(true) : false);
	}
	
	/**
	 * Returns the location of this Chain of cars
	 * @return the <b>Location</b> of this chain of cars
	 */
	public Location getLocation() 
	{
		return location;
	}
	
	/**
	 * Sets the location of this chain of cars
	 * @param location the new location of this chain of cars
	 */
	public void setLocation(Location location) 
	{
		this.location = location;
	}//end setLocation
	
	/**
	 * Returns the id number of this chain. 
	 * @return the integer id of this chain
	 */
	public Integer getId()
	{
		return this.id; 
	}

	@Override
	public String toJSON()
	{
		StringJoiner json = new StringJoiner(", ", "{", "}")
		.add("\"name\": \"" + this.name + "\"")
		.add("\"id\": " + this.getId());
		String locationJSON = ""; 
		if(this.getLocation() == null)
		{
			locationJSON = null;
		}
		else
		{
			locationJSON = this.getLocation().toJSON(); 
		}
		json.add("\"location\": " + locationJSON);
		StringJoiner carsJSON = new StringJoiner(", ", "[", "]");
		for(Object r : chain)
		{
			carsJSON.add(((RollingStock) r).toJSON());
		}
		json.add("\"cars\": " + carsJSON.toString());
		return json.toString(); 
	}
}//end Chain