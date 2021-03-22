package layouts;

import java.util.ArrayList;

/**
 * This class models a track
 * @author Alicen Zschokke
 *
 */
public class Track 
{
	private ArrayList<Train> trains;
	private int length; 
	/**
	 * Constructor
	 * creates an empty track
	 */
	public Track()
	{
		trains = new ArrayList<Train>(); 
	}//end Track()
	
	/**
	 * Constructor
	 * @param trains One or more parameter trains to add to the track
	 */
	public Track(Train ...trains)
	{
		for(Train train : trains)
		{
			this.addTrain(train);
		}//end for
	}//end Track(Train[])
	
	/**
	 * This method adds a train to the track.
	 * @param train the train to be added to the track
	 */
	public void addTrain(Train train)
	{
		this.trains.add(train);
	}//end addTrain(Train)

}//end class Track
