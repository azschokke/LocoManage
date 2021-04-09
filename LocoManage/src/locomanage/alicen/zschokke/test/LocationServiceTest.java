package locomanage.alicen.zschokke.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import locomanage.alicen.zschokke.entities.Location;
import locomanage.alicen.zschokke.repositories.LocationRepository;
import locomanage.alicen.zschokke.service.LocationService;

public class LocationServiceTest 
{
	private static LocationService locationService; 
	private static LocationRepository locationRepository; 
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		locationRepository = Mockito.mock(LocationRepository.class);
		locationService = new LocationService(locationRepository);
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
	
	//tests LocationService getAll method
	@Test
	public void testGetAll() 
	{
		Mockito.when(locationRepository.findAll(anyObject())).thenReturn(
				Arrays.asList(new Location(), new Location(), new Location()));
		Collection<Location> actual = (Collection<Location>) locationService.getAll(0);
		int expected = 3; 
		assertEquals(expected, actual.size());
	}//end test
	
	//tests LocationService get method
	@Test
	public void testGet()
	{
		Mockito.when(locationRepository.findById(anyObject())).thenReturn(Optional.of(new Location()));
		Location actual = locationService.get(0);
		Location expected = new Location(); 
		assertEquals(expected, actual);
	}//end testGet()

	//tests LocationService add method
	@Test
	public void testAdd()
	{
		locationService.add(new Location());
		verify(locationRepository).save(new Location());
	}//end testAdd()
	/*
	//tests ClassificationService update method
	@Test
	public void testUpdate()
	{
		locationService.update(new Location());
		verify(locationRepository, times(2)).findById(anyObject());
	}
	
	//test ClassificationService remove method
	@Test
	public void testRemove()
	{
		locationService.remove(new Location());
		verify(locationRepository).delete(anyObject());
	}
	*/
}//end ChainServiceTest
