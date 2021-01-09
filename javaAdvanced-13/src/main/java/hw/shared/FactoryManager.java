package hw.shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("ShopPersistence");
		}
		return entityManagerFactory;
	}
	
	
	
	public static EntityManager getEntityManager() {
		if(entityManager == null) {
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
}
