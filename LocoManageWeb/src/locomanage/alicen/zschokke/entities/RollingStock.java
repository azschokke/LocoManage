package locomanage.alicen.zschokke.entities;

import java.util.StringJoiner;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//TODO cry

/**
 * This class models a single model train car. 
 * @author Alicen Zschokke
 */
@Entity
@Table
@NamedQuery(query="SELECT r FROM RollingStock r", name="getAllCars")
public class RollingStock
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; //the id number of the car
	private int length; //car length in appropriate scale feet
	private int carNumber; //number on the car
	@ManyToOne
	private Railroad owner; //the railroad the car belongs to
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Model model; //varies widely
	private String notes; //optional notes
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product productInfo;

	
	//TODO javadocs
	public RollingStock()
	{
		super(); 
	}//end RollingStock()

	public RollingStock(Railroad owner, int carNumber, int length, Model model, Product productInfo, String notes)
	{
		this.setOwner(owner); 
		this.setCarNumber(carNumber);
		this.setLength(length);
		this.setModel(model);
		this.setProductInfo(productInfo); 
		this.setNotes(notes);
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
	public Integer getId() 
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
	 * @return the owner
	 */
	public Railroad getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Railroad owner) {
		this.owner = owner;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the productInfo
	 */
	public Product getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(Product productInfo) {
		this.productInfo = productInfo;
	}

	/**
	 * Creates and returns a JSON representation of this train car. 
	 * @return a String representing this train car as a JSON object. 
	 */
	public String toJSON()
	{
		return new StringJoiner(", ", "{", "}")
			.add("\"id\":" + this.getId())
			.add("\"owner\":" + this.getOwner().toJSON())
			.add("\"carNumber\":" + this.getCarNumber())
			.add("\"length\": " + this.getLength())
			.add("\"model\":" + this.getModel().toJSON())
			.add("\"productInfo\":" + this.getProductInfo().toJSON())
			.add("\"notes\": " + "\"" + this.getNotes() + "\"")
			.toString();
	}//end toJSON
	
}//end class TrainCar
