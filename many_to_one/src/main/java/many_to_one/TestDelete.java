package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDelete {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item = entityManager.find(Item.class, 1);
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
		} else {
			System.out.println("No record to Delete");
		}

	}

}
