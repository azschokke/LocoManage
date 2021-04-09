package locomanage.alicen.zschokke.config;

/* Imports */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * This class contains configurations for this web application. 
 * @author Alicen Zschokke
 */
@Configuration
@EnableWebMvc
@ComponentScan("locomanage.alicen.zschokke")
public class WebAppConfig implements WebMvcConfigurer 
{
	/**
	 * View resolver concatenates Strings returned from the controller with their prefix and suffix. 
	 * @return an InternalResourceViewResolver
	 */
	@Bean
	InternalResourceViewResolver viewResolver() 
	{
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}//end viewResolver()

	/**
	 * Add resource handlers adds other resource paths. 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}//end addResourceHandlers(registry)
	
}//end WebAppConfig