package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("hibernate_example");

    public EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
}
