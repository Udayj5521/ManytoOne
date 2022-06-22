package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestUpdate {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item1 = new Item();
		item1.setId(1);
		item1.setName("Mobile");
		item1.setPrice(15000);
		item1.setQuantity(3);

		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setId(2);
		amazonOrder.setName("TE");
		amazonOrder.setAddress("Kathriguppe");
		amazonOrder.setStatus("Getting Prepared");

		entityTransaction.begin();
		entityManager.merge(amazonOrder);
		entityManager.merge(item1);
		entityTransaction.commit();

	}

}
