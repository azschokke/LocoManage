package layouts;

import java.util.ArrayList;

public class Location 
{
	private String name; 
	private ArrayList<Location> children; 
	private Location parent; 
	private boolean isTrack; 
	
	public Location()
	{
		
	}//end Location
	
	public void addChild(Location childLocation)
	{
		children.add(childLocation);
		childLocation.setParent(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Location> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Location> children) {
		this.children = children;
	}

	public Location getParent() {
		return parent;
	}

	public void setParent(Location parent) {
		this.parent = parent;
	}

	public boolean isTrack() {
		return isTrack;
	}

	public void setTrack(boolean isTrack) {
		this.isTrack = isTrack;
	}
	
	
}//end class Location
