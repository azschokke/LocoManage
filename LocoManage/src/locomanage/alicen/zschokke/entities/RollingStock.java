package locomanage.alicen.zschokke.entities;

import java.util.StringJoiner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class RollingStock implements JSONable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //the id number of the car
	@Column
	private int length; //car length in appropriate scale feet
	@Column
	private int carNumber; //number on the car
	@ManyToOne
	private Railroad owner; //the railroad the car belongs to
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Model model; //varies widely
	@Column
	private String notes; //optional notes
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product productInfo;
	private Integer inChain; 
	@Column
	private Integer userId; 
	
	/**
	 * Creates a blank RollingStock item
	 */
	public RollingStock()
	{
		super(); 
	}//end RollingStock()

	/**
	 * Creates a new RollingStock item
	 * @param owner the Railroad that owns this RollingStock item
	 * @param carNumber the number of this RollingStock item
	 * @param length the length of this RollingStock item
	 * @param model the model of RollingStock item
	 * @param productInfo the product information for this RollingStock item
	 * @param notes user notes on this RollingStock item
	 * @param userId the id of the user creating this RollingStock item
	 */
	public RollingStock(Railroad owner, int carNumber, int length, Model model, Product productInfo, String notes, Integer userId)
	{
		this.setOwner(owner); 
		this.setCarNumber(carNumber);
		this.setLength(length);
		this.setModel(model);
		this.setProductInfo(productInfo); 
		this.setNotes(notes);
		this.setInChain(null);
		this.setUserId(userId);
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
	 * Sets the chain Id of this RollingStock
	 * @param chainId the Integer chainId of the chain this rolling stock belongs to
	 */
	public Integer setInChain(Integer inChain)
	{
		this.inChain = inChain; 
		return this.getInChain(); 
	}
	
	/**
	 * Accessor for the chainId of the chain this RollingStock item is in
	 * @return the Integer id of the chain this RollingStock item is in, or null if it is not part of a chain
	 */
	public Integer getInChain()
	{
		return this.inChain; 
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

	/**
	 * Determines if the parameter object is equal to this object. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RollingStock other = (RollingStock) obj;
		if (carNumber != other.carNumber)
			return false;
		if (!inChain.equals(other.inChain))
			return false;
		if (length != other.length)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}//end class TrainCar
