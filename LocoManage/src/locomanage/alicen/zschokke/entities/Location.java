package locomanage.alicen.zschokke.entities;

import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This class models a location in the model railroading system. Anything from a layout down to a track is a location. 
 * @author Alicen Zschokke
 *
 */
@Entity
public class Location implements JSONable
{
	//TODO comment these
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	@Column
	private String name; 
	@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity = Location.class, fetch = FetchType.EAGER)
	private Set children; 
	@Column(name = "parentId")
	private Integer parentId; 
	@Column
	private boolean isTrack; 
	@Column
	private Integer userId; 
	
	/**
	 * TODO comment this
	 */
	public Location()
	{
		super(); 
	}//end Location
	
	public Location(String name, Integer parentId, boolean isTrack, Integer userId)
	{
		this.setName(name);
		if(parentId == null)
		{
			this.setParent(null);
		}
		else
		{
			this.setParent(parentId);
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
		this.userId = userId; 
		
	}//end Location()
	
	/**
	 * Adds the parameter location as a child of this location. 
	 * @param childLocation the location to add as a child
	 */
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
	public Set<Location> getChildren() 
	{
		return children;
	}//end getChildren

	/**
	 * TODO I hate this
	 * Replaces the child locations of this location with the paramater list of locations
	 * @param s the list of locations to be set as children of this location
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	public Integer getParent()
	{
		return parentId;
	}

	/**
	 * Mutator for the parent location of this location. 
	 * @param parent the new parent location of this location
	 */
	public void setParent(Integer parentId)
	{
		this.parentId = parentId; 
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
	public Integer getId()
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + (isTrack ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
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
		Location other = (Location) obj;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (isTrack != other.isTrack)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}//end class Location
