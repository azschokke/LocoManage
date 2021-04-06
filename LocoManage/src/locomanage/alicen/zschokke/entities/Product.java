package locomanage.alicen.zschokke.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	public Product() {}
	
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
	
	public String toJSON()
	{
		return "{\"id\": " + this.getId() + ", \"scale\":" + this.getScale().toJSON() + ", \"manufacturer\": " + this.getManufacturer().toJSON() + ", \"sku\": \"" + this.getSku() + "\"}" ;
	}
	
}//end class Product
