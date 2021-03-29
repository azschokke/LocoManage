package locomanage.alicen.zschokke.db_access;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class DBAccess
{
	/** Entity manager factory for the project. <br> <b>DO NOT USE BEFORE CALLING connect() OR AFTER CALLING disconnect() WITHOUT RECONNECTING. </b> */
	protected EntityManagerFactory emf = null; 
	/** Entity manager for the project. <br> <b>DO NOT USE BEFORE CALLING connect() OR AFTER CALLING disconnect() WITHOUT RECONNECTING. </b> */
	protected EntityManager em = null; 
	private String unitName = "LocoManage";
	
	/**
	 * Connects to the database.<br>
	 * <i>Initializes EntityManagerFactory and EntityManager</i>
	 */
	public void connect()
	{
		this.emf = javax.persistence.Persistence.createEntityManagerFactory(unitName);
		this.em = emf.createEntityManager();
	}//end connect()
	
	/**
	 * Disconnects from the database<br>
	 * <i>If not null, closes EntityManagerFactory and EntityManager</i>
	 */
	public void disconnect()
	{
		if(this.em != null)
		{
			em.close(); 
		}
		if(this.emf != null)
		{
			emf.close(); 
		}
	}//end disconnect()
	
}//end class DBAccess
