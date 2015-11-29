package edu.esprit.app.dao;

import java.util.List;

import edu.esprit.app.entities.Product;

public interface ICatalogDAO {

	public abstract void addProduct(Product p);

	public abstract void deleteProduct(String serialNumber);

	public abstract void updtaeProduct(Product p);

	public abstract Product findProductBySerialNumber(String serialNumber);

	public abstract List<Product> findAllProducts();

}
