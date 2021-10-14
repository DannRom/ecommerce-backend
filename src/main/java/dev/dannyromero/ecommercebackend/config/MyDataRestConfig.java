package dev.dannyromero.ecommercebackend.config;

import dev.dannyromero.ecommercebackend.entity.Product;
import dev.dannyromero.ecommercebackend.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] actions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        // Disable POST, PUT, DELETE HTTP Methods for Product class
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(actions)))
                .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(actions)));

        // Disable POST, PUT, DELETE HTTP Methods for ProductCategory class
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metadata, httpMethods) -> httpMethods.disable(actions)))
                .withCollectionExposure(((metadata, httpMethods) -> httpMethods.disable(actions)));

        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();

        // These types must be changed into java classes.
        List<Class> entityClasses = new ArrayList<>();
        for (EntityType type : entityTypes)
            entityClasses.add(type.getJavaType());

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

}
