package locomanage.alicen.zschokke.config;

/* IMPORTS */
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class handles JPA Configuration
 * @author Alicen Zschokke
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = { "locomanage.alicen.zschokke" })
@EnableTransactionManagement
public class JpaConfig
{
	/**
	 * Sets up EntityManagerFactoryBean and sets Persistence Unit name
	 * @return LocalEntityManagerFactoryBean for this persistence unit
	 */
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory()
	{
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("LocoManage");

		return factoryBean;
	}//end entityManagerFactory

	/**
	 * Transaction Manager
	 * @param entityManagerFactory
	 * @return transaction manager
	 */
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}//end transaction manager
	
}//end JpaConfig