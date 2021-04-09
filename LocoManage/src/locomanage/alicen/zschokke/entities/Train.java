package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//import java.util.ArrayList;

@Entity
public class Train implements JSONable
{
	@Id
	private Integer id; 
	@OneToOne
	private Chain cars;
	@ManyToOne
	private Location origin; 
	@ManyToOne
	private Location destination; 
	private Integer userId; 
	
	public Train()
	{
		//TODO fill in this stuff
	}
	public Train(RollingStock ...trainCars)
	{
		cars = new Chain(); 
		for(RollingStock car : trainCars)
		{
			this.addCar(car);
		}
	}//end Train
	
	public Train(Chain ...chains)
	{
		//do shit
		cars = new Chain();
	}
	
	public void addCar(RollingStock car)
	{
		//verify car

	}//end addCar()
	
	public void addCars(RollingStock ...trainCars)
	{
		for(RollingStock car : trainCars)
		{
			this.addCar(car);
		}
	}
	
	public Chain getCars()
	{		
		return cars; 
	}

	public void setCars(Chain cars) {
		this.cars = cars;
	}
	
	public Location getLocation()
	{
		return this.cars.getLocation(); 
	}
	
	public Integer getId()
	{
		return this.id; 
	}
	
	/**
	 * @return the origin
	 */
	public Location getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(Location origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public Location getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Location destination) {
		this.destination = destination;
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
	public String toJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
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
		Train other = (Train) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
}//end class Train
