package com.posuftpr.projeto5;

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
@EnableJpaRepositories("com.posuftpr.projeto5")
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

    /**configurar os recursos necessários par o Spring Data lidar com o JP
     * @return A**/
    
    @Bean
    public EntityManagerFactory entityManagerFactory() {
   
        /**a instrução para vincular o DataSource com a EntityManagerFactory**/
        LocalContainerEntityManagerFactoryBean factory =
            new LocalContainerEntityManagerFactoryBean();
        /**é informado o provedor que vai ser aplicado a este recurso via método 
         * setJpaVendorAdapter()**/
        HibernateJpaVendorAdapter vendorAdapter = 
            new HibernateJpaVendorAdapter(); 
        /**setGenerateDdl é configurado como false, significa que o esquema do banco de dados 
         * não será gerado pelo Hibernate, Altere para true se existir essa necessidade**/
        vendorAdapter.setGenerateDdl(true); 
        /**setShowSql Escreve no log as instruções SQL geradas pelo Hibernate. Caso seja false, 
         * essas instruções são omitidas do log**/
        vendorAdapter.setShowSql(true);

        factory.setDataSource(dataSource()); 
        factory.setJpaVendorAdapter(vendorAdapter);
        /**setPackagesToScan(), recebe como parâmetro o pacote da aplicação que contém os 
         * mapeamentos do tipo objeto-relacional. Essa informação é essencial para o Hibernate 
         * junto a JPA saber onde se encontram os mapeamentos entre as classes de entidades e 
         * as tabelas do banco de dados**/
        factory.setPackagesToScan("com.curso.entity");
        /**o método afterPropertiesSet() , acessado a par tir da variável factory  a ser analisado. 
         * Este método é necessário para que o EntityManagerFactory só seja criado após todas as 
         * configurações terem sido carregadas**/
        factory.afterPropertiesSet();
        /**E por fim, o objeto factory retorna um objeto do tipo javax.persistence.EntityManagerFactory 
         * via método getObject().**/
        return factory.getObject();
    }

    /**
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactioManager() {

        /**é necessário informar o que será gerenciado, ou seja, o objeto que vai lidar com as interações 
         * no banco de dados. Este objeto é o retorno do recurso criado no método entityManagerFactory(), 
         * o qual deve ser adicionado com o parâmetro de setEntityManagerFactory() da variável manager.**/
        JpaTransactionManager manager = new JpaTransactionManager(); 
        manager.setEntityManagerFactory(entityManagerFactory()); 
        /**o setJpaDialect() , acessível via manager, indica ao controle transacional qual o dialeto do 
         * banco de dados que ele está lidando. A instancia da classe HibernateJpaDialect identifica 
         * automaticamente este dialeto a partir do banco de dados configurado.**/
        manager.setJpaDialect(new HibernateJpaDialect());
   
        return manager;
    }
    
}   


