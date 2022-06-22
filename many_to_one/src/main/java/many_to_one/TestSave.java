package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item1 = new Item();
		item1.setName("Mobile");
		item1.setPrice(15000);
		item1.setQuantity(2);
		
		Item item2 = new Item();
		item2.setName("Tab");
		item2.setPrice(25000);
		item2.setQuantity(3);
		
		Item item3 = new Item();
		item3.setName("Laptop");
		item3.setPrice(50000);
		item3.setQuantity(4);
		
		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setName("Order Bill");
		amazonOrder.setAddress("Bangalore");
		amazonOrder.setStatus("Getting prepared");
		
		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}

}
