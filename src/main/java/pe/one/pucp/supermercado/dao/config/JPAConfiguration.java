package pe.one.pucp.supermercado.dao.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.sql.SQLException;

/**
 * Clase JPAConfiguration.
 *
 * @author lmiguelmh
 * @version 0.0.1
 * @since 20/10/2014 04:34 PM
 */
//@Configuration
//@EnableJpaRepositories(basePackages = "com.yummynoodlebar.persistence.repository",
//        includeFilters = @ComponentScan.Filter(value = {OrdersRepository.class}, type = FilterType.ASSIGNABLE_TYPE))
//@EnableJpaRepositories(basePackages = "pe.one.pucp.supermercado.dao")
//@EnableTransactionManagement
public class JPAConfiguration {

    //@Bean
    //public DataSource dataSource() throws SQLException {
    //    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    //    return builder.setType(EmbeddedDatabaseType.H2).build();
    //}
    //
    //@Bean
    //public EntityManagerFactory entityManagerFactory() throws SQLException {
    //
    //    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    //    vendorAdapter.setGenerateDdl(true);
    //
    //    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    //    factory.setJpaVendorAdapter(vendorAdapter);
    //    factory.setPackagesToScan("pe.one.pucp.supermercado.model");
    //    factory.setDataSource(dataSource());
    //    factory.afterPropertiesSet();
    //
    //    return factory.getObject();
    //}
    //
    //@Bean
    //public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
    //    return entityManagerFactory.createEntityManager();
    //}
    //
    ///*
    //@Bean
    //public PlatformTransactionManager transactionManager() throws SQLException {
    //
    //    JpaTransactionManager txManager = new JpaTransactionManager();
    //    txManager.setEntityManagerFactory(entityManagerFactory());
    //    return txManager;
    //}
    //*/
    //
    //@Bean
    //public HibernateExceptionTranslator hibernateExceptionTranslator() {
    //    return new HibernateExceptionTranslator();
    //}

}
