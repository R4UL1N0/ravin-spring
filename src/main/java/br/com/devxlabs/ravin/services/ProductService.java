package br.com.devxlabs.ravin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.devxlabs.ravin.infra.ExceptionUtils;
import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.entities.Product;
import br.com.devxlabs.ravin.repositories.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private ModelMapper mapper;

	public ProductService(ProductRepository productRepository, ModelMapper mapper) {
		this.productRepository = productRepository;
		this.mapper = mapper;
	}

	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productsDTO = new ArrayList<>();

		// List<ProductDTO> productsDTO2 = products.stream()
    	// 	.map(product -> mapper.map(product, ProductDTO.class))
    	// 	.collect(Collectors.toList());

		for (Product product : products) {
			ProductDTO productDTO = mapper.map(product, ProductDTO.class);
			productsDTO.add(productDTO);
		}
		return productsDTO;
	}

	public ProductDTO getProductById(Long id) throws Exception{
		if (!(productRepository.findById(id).isPresent())) {
			throw new Exception("Product doesn't exist.");
		}
		ProductDTO p = mapper.map(productRepository.findById(id).get(), ProductDTO.class);
		return p;
	}

	public Product getProductByCode(String code) throws Exception {
		Optional<Product> opProduct = productRepository.findProductByCode(code);
		if (!opProduct.isPresent()) {
			throw new Exception("No product has the code received.");
		}
		return opProduct.get();
	}

	public void saveProduct(ProductDTO productDTO) throws Exception {
		if (productDTO.getCostPrice() > productDTO.getSalePrice()) {
			throw new Exception(ExceptionUtils.COST_PRICE_GREATER_THAN_SALE_PRICE);
		}
		Product p = mapper.map(productDTO, Product.class);
		productRepository.save(p);
	}

	public ProductDTO createProduct(ProductDTO productDTO) throws Exception{
		Optional<Product> opProduct = productRepository.findProductByCode(productDTO.getCode());
		if (opProduct.isPresent()) {
			throw new Exception(ExceptionUtils.PRODUCT_CODE_ALREADY_EXISTS);
		}
		// Product newProduct = new Product(productDTO);
		saveProduct(productDTO);

		return productDTO;

	}

	public Page<Product> search(Integer page, Integer size) {
		PageRequest pageable = PageRequest.of(page, size);
		return productRepository.findAll(pageable);
	}

	public ProductDTO updateProduct(Long productId, ProductDTO productDTO) throws Exception{
		Optional<Product> opProduct = productRepository.findById(productId);
		if (!opProduct.isPresent()) {
			throw new Exception("No product with id " + productId);
		}
		
		Product p = new Product(productDTO);
		productRepository.save(p);
		return productDTO;
	}

	
	public ProductDTO deleteProduct(Long id) throws Exception {
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			productRepository.deleteById(id);
		}
		ProductDTO pDTO = mapper.map(p.get(), ProductDTO.class);
		
		return pDTO;
	}


}
