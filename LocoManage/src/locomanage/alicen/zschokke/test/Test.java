package locomanage.alicen.zschokke.test;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.service.ClassificationService;

public class Test 
{
	public static void main(String[] args)
	{
		ClassificationService cs = new ClassificationService(); 
		cs.add(new Classification("locomotive"));
	}//end main
}
