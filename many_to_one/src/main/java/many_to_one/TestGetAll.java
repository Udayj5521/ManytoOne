package many_to_one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetAll {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT i From Item i";

		Query query = entityManager.createQuery(sql);

		List<Item> items = query.getResultList();

		for (Item item : items) {
			System.out.println(item.getId());
			System.out.println(item.getName());
			System.out.println(item.getPrice());
			System.out.println(item.getQuantity());
			System.out.println("-------------------------");
		}

	}

}
