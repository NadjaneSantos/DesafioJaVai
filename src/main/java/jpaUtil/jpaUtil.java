package jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaUtil {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("desafioJaVai");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}
}