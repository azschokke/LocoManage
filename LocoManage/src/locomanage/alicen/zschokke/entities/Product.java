package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This class models a Product
 * @author Alicen Zschokke
 *
 */
@Entity
public class Product implements JSONable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id; 
	@ManyToOne
	private Manufacturer manufacturer; 
	@ManyToOne
	private Scale scale; 
	@Column
	private String sku; 
	
	/**
	 * Creates an empty product
	 */
	public Product() {}
	
	/**
	 * Creates a product with the given manufacturer, scale, and sku
	 * @param manufacturer the manufacturer of this product
	 * @param scale the scale of this product
	 * @param sku the sku of this product
	 */
	public Product(Manufacturer manufacturer, Scale scale, String sku)
	{
		this.setManufacturer(manufacturer);
		this.setScale(scale);
		this.setSku(sku);
	}

	/**
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the scale
	 */
	public Scale getScale() {
		return scale;
	}

	/**
	 * @param scale the scale to set
	 */
	public void setScale(Scale scale) {
		this.scale = scale;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Creates a Json representation of this product
	 */
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ", \"scale\":" + this.getScale().toJSON() + ", \"manufacturer\": " + this.getManufacturer().toJSON() + ", \"sku\": \"" + this.getSku() + "\"}" ;
	}

	/**
	 * Generates a hashcode for this product. 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	/**
	 * Determines if this object and the parameter object are equal.
	 * @return true if they are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
	
	
	
}//end class Product
