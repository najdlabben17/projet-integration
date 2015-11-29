package edu.esprit.app.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import edu.esprit.app.dao.ICatalogDAO;
import edu.esprit.app.entities.Product;

@Transactional
public class CatalogServiceImpl implements ICatalogService {

	private ICatalogDAO catalogDAO;

	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}

	@Override
	public void addProduct(Product p) {

		catalogDAO.addProduct(p);

	}

	@Override
	public void deleteProduct(String serialNumber) {

		catalogDAO.deleteProduct(serialNumber);
	}

	@Override
	public void updtaeProduct(Product p) {

		catalogDAO.updtaeProduct(p);
	}

	@Override
	public Product findProductBySerialNumber(String serialNumber) {

		return catalogDAO.findProductBySerialNumber(serialNumber);
	}

	@Override
	public List<Product> findAllProducts() {

		return catalogDAO.findAllProducts();
	}

}
