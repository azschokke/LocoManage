package locomanage.alicen.zschokke.entities;

import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; //the id number of the car
	private int length; //car length in appropriate scale feet
	private String owner; //the railroad the car belongs to
	private String model; //varies widely
	private String notes; //optional notes
	private String manufacturer; //who makes the car 
	private String sku; //manufacturer's sku number
	private String category; //classification of piece
	private int carNumber; //number on the car
	private String scale; //scale of the car 
	
	//TODO javadocs
	public TrainCar()
	{
		super(); 
	}//end TrainCar()

	public TrainCar(String owner, int carNumber, String model, String manufacturer, String sku, int length, String scale)
	{
		this.setOwner(owner);
		this.setCarNumber(carNumber);
		this.setModel(model);
		this.setManufacturer(manufacturer);
		this.setSku(sku);
		this.setLength(length);
	}
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
	public String getOwner()
	{
		return owner;
	}

	/**
	 * Sets the name of the railroad this train car belongs to.
	 * @param railroad the string representation of the railroad this train car belongs to
	 */
	public void setOwner(String owner)
	{
		this.owner = owner;
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
	 * Accessor for the model of this car. 
	 * @return a string representing the model this car
	 */
	public String getModel()
	{
		return model;
	}

	/**
	 * Sets the model of this car. 
	 * @param carClass the string representation of the class of the car
	 */
	public void setModel(String model) 
	{
		this.model = model;
	}

	
	
	//TODO or this? 
	public String getCategory() {
		return category;
	}
	
	//TODO or this? 
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Creates and returns a clone of this train car. 
	 * @return a TrainCar identical to this train car
	 */
	@Override
	public TrainCar clone()
	{
		TrainCar clone = new TrainCar();
		clone.model = this.model; 
		clone.carNumber = this.carNumber; 
		clone.category = this.category; 
		clone.id = this.id; 
		clone.length = this.length; 
		clone.manufacturer = this.manufacturer; 
		clone.notes = this.notes; 
		clone.owner = this.owner; 
		clone.sku = this.sku; 
		return clone;
	}//end clone
	
	/**
	 * Creates and returns a JSON representation of this train car. 
	 * @return a String representing this train car as a JSON object. 
	 */
	public String toJSON()
	{
		return new StringJoiner(", ", "{", "}")
			.add("\"id: \"" + this.getId())
			.add("\"class:\"" + "\"" + this.getModel() + "\"")
			.add("\"carNumber:\"" + this.getCarNumber())
			.add("\"category: \"" + "\"" + this.getCategory() + "\"")
			.add("\"length: \"" + this.getLength())
			.add("\"notes: \"" + "\"" + this.getNotes() + "\"")
			.add("\"manufacturer: \"" + "\"" + this.getManufacturer() + "\"")
			.add("\"owner: \"" + "\"" + this.getOwner() + "\"")
			.add("\"sku: \"" + "\"" + this.getSku() + "\"")
			.toString();
	}//end toJSON
	
}//end class TrainCar
