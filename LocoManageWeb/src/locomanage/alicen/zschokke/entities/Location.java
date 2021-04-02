package locomanage.alicen.zschokke.entities;

import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class models a location in the model railroading system. Anything from a layout down to a track is a location. 
 * @author Alicen Zschokke
 *
 */
@Entity
public class Location 
{
	//TODO comment these
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private String name; 
	@OneToMany(targetEntity = Location.class, fetch = FetchType.EAGER)
	private Set children; 
	@JoinColumn
	@ManyToOne
	private Location parent; 
	private boolean isTrack; 
	
	/**
	 * TODO comment this
	 */
	public Location()
	{
		
	}//end Location
	
	public Location(String name, Location parent, boolean isTrack)
	{
		this.setName(name);
		if(parent == null)
		{
			this.setParent(null);
		}
		else
		{
			this.setParent(parent);
		}
		this.isTrack = isTrack; 
		if(isTrack)
		{
			children = null; 
		}
		else
		{
			children = new TreeSet<Location>(); 
		}
		
		
	}//end Location()
	
	/**
	 * Adds the parameter location as a child of this location. 
	 * @param childLocation the location to add as a child
	 */
	public void addChild(Location childLocation)
	{
		children.add(childLocation);
	}//end addChild()
	
	//TODO I need a remove child

	/**
	 * Accessor for the name of this location. 
	 * @return the name of this location
	 */
	public String getName() 
	{
		return name;
	}//end getName()

	/**
	 * Mutator for the name of this location. 
	 * @param name the new name of this location
	 */
	public void setName(String name) 
	{
		this.name = name;
	}//end setName

	/**
	 * Accessor for the children of this location. 
	 * @return a list containing the child locations of this location
	 */
	public Set<Location> getChildren() 
	{
		return children;
	}//end getChildren

	/**
	 * TODO I hate this
	 * Replaces the child locations of this location with the paramater list of locations
	 * @param s the list of locations to be set as children of this location
	 */
	public void setChildren(Set s) 
	{
		for(Object l : s)
		{
			this.children.add(l);
		}
	}//end setChildren

	/**
	 * Accessor for the parent location of this location.
	 * @return the parent location of this location
	 */
	public Location getParent()
	{
		return parent;
	}

	/**
	 * Mutator for the parent location of this location. 
	 * @param parent the new parent location of this location
	 */
	public void setParent(Location parent)
	{
		this.parent = parent; 
	}//end setParent

	/**
	 * @return true if this location is a track, false otherwise
	 */
	public boolean isTrack()
	{
		return isTrack;
	}
	
	//TODO do i need this? 
	public void setTrack(boolean isTrack)
	{
		this.isTrack = isTrack;
	}//end setTrack
	
	/**
	 * Accessor for the unique id of this location.
	 * @return the id of this location
	 */
	public int getId()
	{
		return this.id; 
	}
	
	public String toJSON()
	{
		StringJoiner json = new StringJoiner(",", "{", "}");
		json.add("\"id\":" + this.getId())
			.add("\"name\": \"" + this.getName() + "\"")
			.add("\"isTrack\":" + this.isTrack() );
		if(!this.isTrack())
		{
			StringJoiner childrenJson = new StringJoiner(",", "[", "]");
			for(Object c : children)
			{
				childrenJson.add(((Location) c).toJSON()); 
			}
			json.add("\"children\":" + childrenJson.toString());
		}//end if		
		
		return json.toString(); 
	}//end toJSON
	
}//end class Location
