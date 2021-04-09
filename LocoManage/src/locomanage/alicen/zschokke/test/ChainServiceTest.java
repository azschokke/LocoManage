package locomanage.alicen.zschokke.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import locomanage.alicen.zschokke.entities.Chain;
import locomanage.alicen.zschokke.repositories.ChainRepository;
import locomanage.alicen.zschokke.repositories.LocationRepository;
import locomanage.alicen.zschokke.service.ChainService;

public class ChainServiceTest 
{
	private static ChainService chainService; 
	private static ChainRepository chainRepository; 
	private static LocationRepository locationRepository; 
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		chainRepository = Mockito.mock(ChainRepository.class);
		locationRepository = Mockito.mock(LocationRepository.class);
		chainService = new ChainService(chainRepository, locationRepository);
	}//end setUp()
	
	@AfterClass
	public static void takeDown()
	{
		System.out.println("All testing complete.");
	}
	
	@Before
	public void beforeTest()
	{
		System.out.println("Beginning Test");
	}
	
	@After
	public void afterTest()
	{
		System.out.println("Test Complete");
	}
	
	//tests ChainService getAll method
	@Test
	public void testGetAll() 
	{
		Mockito.when(chainRepository.findAll(anyObject())).thenReturn(
				Arrays.asList(new Chain(), new Chain(), new Chain()));
		List<Chain> actual = chainService.getAll(0);
		int expected = 3; 
		assertEquals(expected, actual.size());
	}//end test
	
	//tests ChainService get method
	@Test
	public void testGet()
	{
		Mockito.when(chainRepository.findById(anyObject())).thenReturn(Optional.of(new Chain("test")));
		Chain actual = chainService.get(0);
		Chain expected = new Chain("test"); 
		assertEquals(expected, actual);
	}//end testGet()

	//tests ChainService add method
	@Test
	public void testAdd()
	{
		chainService.add(new Chain("test"));
		verify(chainRepository).save(new Chain("test"));
	}//end testAdd()
	
	//tests ChainService update method
	@Test
	public void testUpdate()
	{
		chainService.update(new Chain("test"));
		verify(chainRepository, times(2)).findById(anyObject());
	}
	
	@Test
	public void testRemove()
	{
		chainService.remove(new Chain("test"));
		verify(chainRepository).delete(anyObject());
	}
	

}//end ChainServiceTest
