package locomanage.alicen.zschokke.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//TODO cry

/**
 * This class models a single model train car. 
 * @author Alicen Zschokke
 */
@Entity
@Table
@NamedQuery(query="SELECT t FROM TrainCar t", name="getAllCars")
public class TrainCar implements Cloneable
{
	@Id
	private int id; //the id number of the car
	private int length; //car length in appropriate scale feet
	private String railroad; //the railroad the car belongs to
	private String carClass; //varies widely
	private String notes; //optional notes
	private String manufacturer; //who makes the car 
	private String sku; //manufacturer's sku number
	private String status; 
	private String category; //classification of piece
	private int carNumber; 

	public TrainCar()
	{
		setLength(0); 
		this.id = 0;  
		setCarClass(""); 
		setNotes("");
		setManufacturer("");
		setSku("");
		setStatus("");
	}//end TrainCar()

	/**
	 * Returns the length of this train car. 
	 * @return the integer length of this train car
	 */
	public int getLength() 
	{
		return length;
	}

	/**
	 * Sets the length of this train car
	 * @param length the integer length of this train car
	 */
	public void setLength(int length) 
	{
		this.length = length;
	}

	/**
	 * Returns the id number of this train car. 
	 * @return the integer id number of the train car
	 */
	public int getId() 
	{
		return id;
	}

	/**
	 * Returns the user notes on this train car. 
	 * @return the string representation of the user's notes on this train car
	 */
	public String getNotes() 
	{
		return notes;
	}

	/**
	 * Sets the user's notes on this train car. 
	 * @param notes the string of user notes for this train car
	 */
	public void setNotes(String notes) 
	{
		this.notes = notes;
	}

	/**
	 * Returns the sku of this train car. 
	 * @return the String representation of the sku of this train car
	 */
	public String getSku() 
	{
		return sku;
	}

	/**
	 * Sets the sku of this train car
	 * @param sku a string representing the sku of this train car
	 */
	public void setSku(String sku) 
	{
		this.sku = sku;
	}

	//TODO find a better way to differentiate unique id and car number
	/**
	 * Returns the car number of this train car
	 * @return the integer representation of the car number of this train car
	 */
	public int getCarNumber() 
	{
		return carNumber;
	}

	/**
	 * Sets the car number of this train car. 
	 * @param carNumber the integer car number of this train car
	 */
	public void setCarNumber(int carNumber) 
	{
		this.carNumber = carNumber;
	}
	
	//TODO parameter checking probably
	/**
	 * Returns the name of the railroad this train car belongs to.
	 * @return the string representation of the railroad this train car belongs to
	 */
	public String getRailroad()
	{
		return railroad;
	}

	/**
	 * Sets the name of the railroad this train car belongs to.
	 * @param railroad the string representation of the railroad this train car belongs to
	 */
	public void setRailroad(String railroad)
	{
		this.railroad = railroad;
	}

	/**
	 * Returns the name of the manufacturer of this train car. 
	 * @return the name of the manufacturer of this train car
	 */
	public String getManufacturer()
	{
		return manufacturer;
	}

	/**
	 * Sets the name of the manufacturere of this train car
	 * @param manufacturer the string representation of the manufacturer of the train car
	 */
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	/**
	 * Return the string representation of the class of the car. 
	 * @return a string representing the class of this car
	 */
	public String getCarClass()
	{
		return carClass;
	}

	/**
	 * TODO find an even remotely elegant way to phrase this crap
	 * Mutator for the car class field
	 * @param carClass the string representation of the class of the car
	 */
	public void setCarClass(String carClass) 
	{
		this.carClass = carClass;
	}

	//TODO do i even need this? 
	public String getStatus()
	{
		return status;
	}
	
	//TODO or this?
	public void setStatus(String status) {
		this.status = status;
	}
	
	//TODO or this? 
	public String getCategory() {
		return category;
	}
	
	//TODO or this? 
	public void setCategory(String category) {
		this.category = category;
	}
	
	//TODO cry in "this isn't how entity managers work"
	/**
	 * Creates and returns a clone of this train car. 
	 * @return a TrainCar identical to this train car
	 */
	@Override
	public TrainCar clone()
	{
		TrainCar clone = new TrainCar();
		clone.carClass = this.carClass; 
		clone.carNumber = this.carNumber; 
		clone.category = this.category; 
		clone.id = this.id; 
		clone.length = this.length; 
		clone.manufacturer = this.manufacturer; 
		clone.notes = this.notes; 
		clone.railroad = this.railroad; 
		clone.sku = this.sku; 
		clone.status = this.status; 
		return clone;
	}//end clone
	
}//end class TrainCar
