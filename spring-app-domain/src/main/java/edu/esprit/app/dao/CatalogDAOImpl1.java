package edu.esprit.app.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.esprit.app.entities.Product;

public class CatalogDAOImpl1 implements ICatalogDAO {

	Map<String, Product> products = new HashMap<String, Product>();

	@Override
	public void addProduct(Product p) {

		products.put(p.getSerialNumber(), p);
	}

	@Override
	public void deleteProduct(String serialNumber) {

		products.remove(serialNumber);
	}

	@Override
	public void updtaeProduct(Product p) {

		products.put(p.getSerialNumber(), p);
	}

	@Override
	public Product findProductBySerialNumber(String serialNumber) {

		return products.get(serialNumber);
	}

	@Override
	public List<Product> findAllProducts() {

		return new ArrayList<Product>(products.values());
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
