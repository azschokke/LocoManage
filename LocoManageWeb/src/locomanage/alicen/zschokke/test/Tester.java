package locomanage.alicen.zschokke.test;

import org.springframework.beans.factory.annotation.Autowired;

import locomanage.alicen.zschokke.service.ManufacturerService;

public class Tester 
{
	private ManufacturerService ms; 
	
	@Autowired
	public Tester(ManufacturerService ms)
	{
		this.ms = ms; 
	}
	
	public static void main(String[] args)
	{
		
	}
}
