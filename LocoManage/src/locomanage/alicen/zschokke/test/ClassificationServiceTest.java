package locomanage.alicen.zschokke.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
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

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.repositories.ClassificationRepository;
import locomanage.alicen.zschokke.service.ClassificationService;

public class ClassificationServiceTest 
{
	private static ClassificationService classificationService; 
	private static ClassificationRepository classificationRepository; 
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		classificationRepository = Mockito.mock(ClassificationRepository.class);
		classificationService = new ClassificationService(classificationRepository);
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
	
	//tests ClassificationService getAll method
	@Test
	public void testGetAll() 
	{
		Mockito.when(classificationRepository.findAll()).thenReturn(
				Arrays.asList(new Classification(), new Classification(), new Classification()));
		Collection<Classification> actual = (Collection<Classification>) classificationService.getAll();
		int expected = 3; 
		assertEquals(expected, actual.size());
	}//end test
	
	//tests ClassificationService get method
	@Test
	public void testGet()
	{
		Mockito.when(classificationRepository.findById(anyObject())).thenReturn(Optional.of(new Classification("test")));
		Classification actual = classificationService.get(0);
		Classification expected = new Classification("test"); 
		assertEquals(expected, actual);
	}//end testGet()

	//tests ClassificationService add method
	@Test
	public void testAdd()
	{
		classificationService.add(new Classification("test"));
		verify(classificationRepository).save(new Classification("test"));
	}//end testAdd()
	
	//tests ClassificationService update method
	@Test
	public void testUpdate()
	{
		classificationService.update(new Classification("test"));
		verify(classificationRepository, times(2)).findById(anyObject());
	}
	
	//test ClassificationService remove method
	@Test
	public void testRemove()
	{
		classificationService.remove(new Classification("test"));
		verify(classificationRepository).delete(anyObject());
	}
	

}//end ChainServiceTest
