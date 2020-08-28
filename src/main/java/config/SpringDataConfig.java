package config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.jolbox.bonecp.BoneCPDataSource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 *
 * @author JulianaMCS
 * 
 */
@Configuration 
@EnableJpaRepositories("repository") 
@EnableTransactionManagement
public class SpringDataConfig {
    
    
    /**este método configura as informações básicas de 
     * uma conexão com um banco de dado
     *
     * @return  **/
    @Bean
    public DataSource dataSource() {

        BoneCPDataSource ds = new BoneCPDataSource(); 
        ds.setUser("root");
        ds.setPassword("admin");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/posbd");
        ds.setDriverClass("com.mysql.jdbc.Driver");
        return ds;  
    }

    /**configurar os recursos necessários par o Spring Data lidar com o JPA
     * @return **/
    
    @Bean
    public EntityManagerFactory entityManagerFactory() {
   
       LocalContainerEntityManagerFactoryBean factory =
      new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = 
      new HibernateJpaVendorAdapter(); 
        vendorAdapter.setGenerateDdl(false); 
        vendorAdapter.setShowSql(true);

        factory.setDataSource(dataSource()); 
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("entity");
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    /**
     *
     * @return
     */
    @Bean(name="transactionManager")
    public PlatformTransactionManager transactioManager() {
        JpaTransactionManager manager = new JpaTransactionManager(); 
        manager.setEntityManagerFactory(entityManagerFactory()); 
        manager.setJpaDialect(new HibernateJpaDialect());
   
        return manager;
    }
    
}   


