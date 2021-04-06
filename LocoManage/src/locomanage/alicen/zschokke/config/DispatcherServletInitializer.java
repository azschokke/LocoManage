package locomanage.alicen.zschokke.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Dispatcher Servlet Initializer configuration class. 
 * @author Alicen Zschokke
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return null;
	}//end getRootConfigClasses()

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return new Class<?>[] {WebAppConfig.class};
	}//end getServletConfigClasses()

	@Override
	protected String[] getServletMappings()
	{
		return new String[] {"/"};
	}//end getServletMappings()

}//end DispatcherServletInitializer