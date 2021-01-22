package me.formacion;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@EnableWebMvc
public class Config {
    @Autowired 
    Environment env;
	public String PERSISTENCE_UNIT_NAME = "FORACION";
	
    @Bean
	public LocalEntityManagerFactoryBean entityManagerFactory(){
	    LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
	    factoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
	    return factoryBean;
	}
    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        //txManager.setDataSource(dataSource());
        return txManager;
    }

}
