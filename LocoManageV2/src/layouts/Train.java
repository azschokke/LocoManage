package layouts;

//import java.util.ArrayList;

public class Train 
{
	private Chain cars;
	
	public Train(TrainCar ...trainCars)
	{
		cars = new Chain(); 
		for(TrainCar car : trainCars)
		{
			this.addCar(car);
		}
	}//end Train
	
	public Train(Chain ...chains)
	{
		//do shit
		cars = new Chain();
	}
	
	public void addCar(TrainCar car)
	{
		//verify car

	}//end addCar()
	
	public void addCars(TrainCar ...trainCars)
	{
		for(TrainCar car : trainCars)
		{
			this.addCar(car);
		}
	}//end addCars
	
	public Chain getCars()
	{
//		ArrayList<TrainCar> clone = new ArrayList<TrainCar>();
		
//		for(TrainCar car : this.train)
//		{
//			clone.add (car.clone()); 
//		}
		
		return (Chain) cars.clone(); 
	}
	
	/**
	 * Sets this chain of cars to paramater chain of cars, replacing any previous cars. 
	 * @param cars The Chain of cars to be added. if cars is null, no change. 
	 */
	public void setCars(Chain cars) 
	{
		if(cars != null)
		{
			this.cars = cars;
		}//end if
	}//end setCars
	
	
}//end class Train
