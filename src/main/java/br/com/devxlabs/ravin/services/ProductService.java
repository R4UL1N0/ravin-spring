package br.com.devxlabs.ravin.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Product getProductById(Long id) throws Exception{
		if (!(productDAO.findById(id).isPresent())) {
			throw new Exception("Product doesn't exist.");
		}
		return productDAO.findById(id).get();
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

	public Page<Product> search(Integer page, Integer size) {
		PageRequest pageable = PageRequest.of(page, size);
		return productDAO.findAll(pageable);
	}

	public Product updateProduct(ProductDTO productDTO) {
		Product p = new Product(productDTO);
		return productDAO.save(p);
	}

	
	public Product deleteProduct(Long id) throws Exception {
		Product p = this.getProductById(id);
		productDAO.deleteById(id);

		return p;
	}


}
