package com.handbags.spring.config;


import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.handbags.spring.Impl.BrandImpl;
import com.handbags.spring.Impl.CategoryImpl;
import com.handbags.spring.Impl.ProductImpl;
import com.handbags.spring.Impl.SubcategoryImpl;
import com.handbags.spring.Impl.SupplierImpl;
import com.handbags.spring.model.Brand;
import com.handbags.spring.model.Category;
import com.handbags.spring.model.Product;
import com.handbags.spring.model.Subcategory;
import com.handbags.spring.model.Supplier;



@Configuration
@ComponentScan("com.handbags")
@EnableTransactionManagement
public class HibernateConfiguration {
 
    // @Bean configurations go here...
 

@Bean(name = "dataSource")
public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setUrl("jdbc:h2:tcp://localhost/~/TheBolsoVilla");
    dataSource.setUsername("sa");
    dataSource.setPassword("");
 
    Properties dproperties = new Properties();
    dproperties.setProperty("hibernate.show_sql", "true");
    dproperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    dproperties.setProperty("hibernate.hbm2ddl.auto","update");
    return dataSource;
}

private Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    properties.put("hibernate.hbm2ddl.auto","update");
    return properties;
}

@Bean
@Autowired
public HibernateTransactionManager transactionManager(SessionFactory sessionFactory ) {
   HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
   
   return txManager;
}
@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
 
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionBuilder.addProperties(getHibernateProperties());
    sessionBuilder.addAnnotatedClasses(Category.class);
    sessionBuilder.addAnnotatedClasses(Supplier.class);
    sessionBuilder.addAnnotatedClasses(Subcategory.class);
    sessionBuilder.addAnnotatedClasses(Brand.class);
    sessionBuilder.addAnnotatedClasses(Product.class);
    return sessionBuilder.buildSessionFactory();
}
@Autowired
@Bean(name="categoryImpl")
public CategoryImpl getCategoryImpl(SessionFactory sessionFactory){
	return new CategoryImpl(sessionFactory);
}
@Autowired
@Bean(name="supplierImpl")
public SupplierImpl getSupplierImpl(SessionFactory sessionFactory){
	return new SupplierImpl(sessionFactory);
}
@Autowired
@Bean(name="subcategoryImpl")
public SubcategoryImpl getSubcategoryImpl(SessionFactory sessionFactory){
	return new SubcategoryImpl(sessionFactory);
}
@Autowired
@Bean(name="brandImpl")
public BrandImpl  getBrandImpl(SessionFactory sessionFactory){
	return new BrandImpl(sessionFactory);	
}

@Autowired
@Bean(name="productImpl")
public ProductImpl  getProductImpl(SessionFactory sessionFactory){
	return new ProductImpl(sessionFactory);	
}


}
