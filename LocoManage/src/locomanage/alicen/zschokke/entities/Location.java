package locomanage.alicen.zschokke.entities;

import java.util.List; 
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private int id; 
	private String name; 
//	@OneToMany
//	private ArrayList<Location> children; 
	@ManyToOne
	private Location parent; 
	private boolean isTrack; 
	
	/**
	 * TODO comment this
	 */
	public Location()
	{
		
	}//end Location
	
	/**
	 * Adds the parameter location as a child of this location. 
	 * @param childLocation the location to add as a child
	 */
	public void addChild(Location childLocation)
	{
//		children.add(childLocation);
		childLocation.setParent(this);
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
//	public List<Location> getChildren() 
//	{
//		return children;
//	}//end getChildren

	/**
	 * TODO I hate this
	 * Replaces the child locations of this location with the paramater list of locations
	 * @param children the list of locations to be set as children of this location
	 */
//	public void setChildren(List<Location> children) 
//	{
//		for(Location l : children)
//		{
//			this.children.add(l);
//		}
//	}//end setChildren

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
	}

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
	
}//end class Location
