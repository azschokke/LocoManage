package locomanage.alicen.zschokke.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.service.ClassificationService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClassificationServiceTest {
	
	private static ClassificationService cs; 
	private static Classification c; 
	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Beginning Clasification Service testing....");
		cs = new ClassificationService(); 
		c = new Classification("locomotive");
	}//end setUp()
	
	@Test
	public void testAAdd()
	{
		System.out.println("Test add");
		System.out.println(c);
		cs.add(c);
	}//end test()
	
//	@Test
//	public void testBGet()
//	{
//		System.out.println("Test get");
//		Classification f = cs.get(c.getId());
//		System.out.println(c + ", " + f);
//		assertEquals(c, f);
//	}//end testBGet
//	
//	@Test
//	public void testCUpdate()
//	{
//		System.out.println("Test update");
//		c.setName("box car");
//		cs.update(c);
//		Classification f = cs.get(c.getId());
//		System.out.println(c + ", " + f);
//		assertEquals(c, f);
//	}//end testCUpdate
//	
//	@Test
//	public void testDRemove()
//	{
//		System.out.println("Test remove");
//		cs.remove(c.getId());
//	}
	
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("Classification Service testing complete. ");
	}

}
