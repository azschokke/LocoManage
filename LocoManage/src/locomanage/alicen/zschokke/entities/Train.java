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
//		ArrayList<TrainCar> clone = new ArrayList<TrainCar>();
		
//		for(TrainCar car : this.train)
//		{
//			clone.add(car.clone()); 
//		}
		
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
}//end class Train
