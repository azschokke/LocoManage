package layouts;

import java.util.ArrayList;

/**
 * The Chain class models a chain of connected Train Cars.
 * @author Alicen Zschokke
 *
 */
public class Chain
{
	private ArrayList<TrainCar> chain; 
	private Location location; 
	
	/**
	 * Class constructor 
	 */
	public Chain()
	{
		chain = new ArrayList<TrainCar>();
		this.setLocation(null);
	}//end Chain()
	
	/**
	 * Class constructor specifying this chain's location
	 * @param location the chain's location
	 */
	public Chain(Location location)
	{
		this(); 
		this.setLocation(location);
	}//end Chain()
	
	/**
	 * Class constructor specifying the Train Cars to be added to this chain
	 * @param cars one or more Train Cars to be added to the Chain
	 */
	public Chain(TrainCar ...cars)
	{
		this(); 
		for(TrainCar car : cars)
		{
			this.add(car);
		}
	}//end Chain(TrainCar ...cars)
	
	/**
	 * Class constructor specifying the location of this Chain and the Train Cars to be added to this Chain
	 * @param location
	 * @param cars
	 */
	public Chain(Location location, TrainCar ...cars)
	{
		this(); 
		this.setLocation(location);
		for(TrainCar car : cars)
		{
			this.add(car);
		}
	}//end Chain(Location location, TrainCar ...cars)

	/**
	 * 
	 * @return 
	 */
	public ArrayList<TrainCar> getChain() 
	{
		ArrayList<TrainCar> copy = new ArrayList<TrainCar>(chain.size());
		for(TrainCar car : chain)
		{
			copy.add(car.clone());
		}
		return copy;
	}//end getChain()

	public void setChain(ArrayList<TrainCar> chain) {
		this.chain = chain;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public boolean add(TrainCar car)
	{
		return chain.add(car);
	}
	
	public Object clone()
	{
		return new Chain();
	}//end clone
	
}//end Chain