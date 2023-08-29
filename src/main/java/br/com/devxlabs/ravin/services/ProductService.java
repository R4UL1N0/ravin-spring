package br.com.devxlabs.ravin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devxlabs.ravin.daos.ProductDAO;
import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.entities.Product;

@Service
public class ProductService {

	private ProductDAO productDAO;

	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> getAllProducts() {
		return productDAO.findAll();
	}

	public void saveProduct(Product product) {
		productDAO.save(product);
	}

	public Product createProduct(ProductDTO productDTO) throws Exception{
		if (productDAO.findProductByCode(productDTO.getCode()).isPresent()) {
			throw new Exception("Product Code already exists.");
		}
		Product newProduct = new Product(productDTO);
		saveProduct(newProduct);

		return newProduct;

	}


}
