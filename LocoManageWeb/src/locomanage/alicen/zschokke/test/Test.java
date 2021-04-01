package locomanage.alicen.zschokke.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.service.ClassificationService;


public class Test 
{
	@Autowired
	private static ClassificationService cs; 
	
	public static void main(String[] args)
	{
		cs.add(new Classification("locomotive"));
	}//end main
}
