package locomanage.alicen.zschokke.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table
@NamedQuery(query="SELECT c FROM Chain c", name="getAllChains")
public class Chain implements JSONable
{
	//TODO comment these 
	@Id
	@Column
	private Integer id; 
	
	@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity = RollingStock.class)
	private Set chain; 
	
	@ManyToOne @JoinColumn(nullable = false, name="l_id")
	private Location location; 
	
	/**
	 * Creates an empty chain. 
	 */
	public Chain()
	{
		chain = new HashSet<RollingStock>(); 
	}//end Chain()

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
	public String toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
}//end Chain