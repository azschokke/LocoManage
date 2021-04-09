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
	private Set cars; 
	
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
		cars = new HashSet<RollingStock>(); 
	}//end Chain()
	
	public Chain(String name)
	{
		this.name = name; 
		cars = new HashSet<RollingStock>(); 
	}

	/**
	 * Returns a list of the <b>Train Cars</b> in this Chain. 
	 * @return a list of the train cars in this chain. 
	 */
	@SuppressWarnings("unchecked")
	public Set<RollingStock> getChain() 
	{
		return cars;
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
			this.cars.add(c);
		}
	}
	
	/**
	 * Adds a RollingStock item to this chain. 
	 * @param the RollingStock item to add
	 */
	@SuppressWarnings("unchecked")
	public boolean addRollingStock(RollingStock car)
	{
		if(this.cars.add(car))
		{
			car.setInChain(this.getId()); 
			return true; 
		}
		return false; 
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

	/**
	 * @return the cars
	 */
	public Set getCars() {
		return cars;
	}

	/**
	 * @param cars the cars to set
	 */
	public void setCars(Set cars) {
		this.cars = cars;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Chain other = (Chain) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
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
		for(Object r : cars)
		{
			carsJSON.add(((RollingStock) r).toJSON());
		}
		json.add("\"cars\": " + carsJSON.toString());
		return json.toString(); 
	}
}//end Chain