package locomanage.alicen.zschokke.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import locomanage.alicen.zschokke.entities.TrainCar;
import locomanage.alicen.zschokke.service.TrainCarService;

import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TrainCarServiceTest 
{
	private static TrainCarService tcs; 
	private static TrainCar tc; 
	
	@BeforeClass
	public static void setUp()
	{
		System.out.println("Beginning Tests.....");
		tcs = new TrainCarService(); 
		tc = new TrainCar();
	}
	
	@Test
	public void testAdd()
	{
		fail("Not yet implemented");
	}//end test()

	@AfterClass
	public static void takeDown()
	{
		System.out.println("Testing finished. ");
	}//end takeDown
	
}//end TrainCarServiceTest
