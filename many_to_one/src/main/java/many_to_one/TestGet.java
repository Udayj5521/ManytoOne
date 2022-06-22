package many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGet {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Item item = entityManager.find(Item.class , 1);
		
		if (item != null) {
			System.out.println("Item name is "+item.getName());
			System.out.println("Item Price is "+item.getPrice());
			System.out.println("Item Quantity is "+item.getQuantity());
			System.out.println("----------------------------");
			
			AmazonOrder amazonOrder = item.getAmazonOrder();
			System.out.println("AmazonOrder Name is "+amazonOrder.getName());
			System.out.println("AmazonOrder Addrress is "+amazonOrder.getAddress());
			System.out.println("AmazonOrder Status is "+amazonOrder.getStatus());
		}else {
			System.out.println("There is no item for given id");
		}
	
	}

}
