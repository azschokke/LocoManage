package locomanage.alicen.zschokke.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import locomanage.alicen.zschokke.entities.RollingStock;
import locomanage.alicen.zschokke.service.RollingStockService;

import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RollingStockServiceTest 
{
	private static RollingStockService rss; 
	private static RollingStock expected; 
	
	@BeforeClass
	public static void setUp()
	{
		System.out.println("Beginning Tests.....");
		rss = new RollingStockService(); 
		expected = new RollingStock();
	}
	
	@Test
	public void testAAdd()
	{
		rss.add(expected);
	}//end test()
	
	@Test
	public void testBGet()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testCUpdate()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testDRemove()
	{
		fail("Not yet implemented");
	}

	@AfterClass
	public static void takeDown()
	{
		System.out.println("Testing finished. ");
	}//end takeDown
	
}//end TrainCarServiceTest
