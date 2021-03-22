package layouts;

/**
 * This class models a single model train car. 
 * @author Alicen Zschokke
 */
public class TrainCar implements Cloneable
{
	private int idNumber; //the id number of the car
	private int length; //car length in HO scale feet
	private String railroad; //the railroad the car belongs to
	private int carNumber; 
	private String type; //varies widely
	private String notes; //optional notes
	private String manufacturer; //who makes the car 
	private String sku; //manufacturer's sku number
	private String status; 
	private String category; //classification of piece
	

	public TrainCar()
	{
		setLength(0); 
		setIdNumber(0); 
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
	public int getIdNumber() 
	{
		return idNumber;
	}
	
	/**
	 * Sets the id number for this train car. 
	 * @param idNumber the integer id number for this train car
	 */
	public void setIdNumber(int idNumber)
	{
		this.idNumber = idNumber;
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
	public void setOwner(String railroad)
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
		return type;
	}

	public void setCarClass(String type) 
	{
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

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
		clone.type = this.type; 
		clone.carNumber = this.carNumber; 
		clone.category = this.category; 
		clone.idNumber = this.idNumber; 
		clone.length = this.length; 
		clone.manufacturer = this.manufacturer; 
		clone.notes = this.notes; 
		clone.railroad = this.railroad; 
		clone.sku = this.sku; 
		clone.status = this.status; 
		return clone;
	}//end clone
	
	
}//end class TrainCar
