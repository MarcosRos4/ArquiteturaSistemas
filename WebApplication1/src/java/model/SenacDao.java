package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marcos.vcrosa
 */
public class SenacDao {
    private EntityManagerFactory factory;
    private EntityManager manager;
    
    private void conectar(){
        factory = Persistence.createEntityManagerFactory("WebApplication1PU");
        manager = factory.createEntityManager();
    }
    
}
