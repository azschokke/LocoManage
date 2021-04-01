package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import java.util.ArrayList;

@Entity
public class Train 
{
	@Id
	private int id; 
	@OneToOne
	private Chain cars;
//	private Date departure; 
//	private Date arrival; 
	@ManyToOne
	private Location origin; 
	@ManyToOne
	private Location destination; 
	
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
	
}//end class Train
