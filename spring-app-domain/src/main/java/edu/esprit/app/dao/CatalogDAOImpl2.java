package edu.esprit.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import edu.esprit.app.entities.Product;

@Transactional
public class CatalogDAOImpl2 implements ICatalogDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public void addProduct(Product p) {

		em.persist(p);
	}

	@Override
	public void deleteProduct(String serialNumber) {

		em.remove(findProductBySerialNumber(serialNumber));
	}

	@Override
	public void updtaeProduct(Product p) {

		em.merge(p);
	}

	@Override
	public Product findProductBySerialNumber(String serialNumber) {

		return em.find(Product.class, serialNumber);
	}

	@Override
	public List<Product> findAllProducts() {

		return em.createQuery("select p from Product P", Product.class)
				.getResultList();
	}

	public void init() {

		System.out
				.println("\n----------> Starting execution of [ init() ] method ...\n");
		addProduct(new Product("A1245i", "HP510", 1500.0, 50l));
		addProduct(new Product("ERTY7845i", "DELL VOSTRO", 2500.0, 15l));
		addProduct(new Product("100XZ087", "EPSON LX20", 600.0, 20l));
		System.out.println("\n----------> End execution of [ init() ] method.");
	}

}
