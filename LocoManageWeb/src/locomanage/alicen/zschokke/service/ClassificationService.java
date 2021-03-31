package locomanage.alicen.zschokke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import locomanage.alicen.zschokke.entities.Classification;
import locomanage.alicen.zschokke.repositories.ClassificationRepository;


@Service
public class ClassificationService 
{
	//inject repository
	private ClassificationRepository classificationRepository;
	
	@Autowired //tells this class where the managed bean should be injected
	public ClassificationService(ClassificationRepository classificationRepository)
	{
		this.classificationRepository = classificationRepository; 
	}
	
	public void saveUser(Classification classification)
	{
		classificationRepository.save(classification);
	}
	
}//end ClassificationService
