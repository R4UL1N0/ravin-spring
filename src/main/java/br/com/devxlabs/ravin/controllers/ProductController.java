package br.com.devxlabs.ravin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.entities.Product;
import br.com.devxlabs.ravin.services.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;


	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception{
			return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) throws Exception{
		Product created = productService.createProduct(productDTO);
		productDTO.setId(created.getId());
		return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
	} 

	@GetMapping("/search")
	public Page<Product> search(
		@RequestParam(required = false, defaultValue = "0") Integer page,
		@RequestParam(required = false, defaultValue = "10") Integer size
	) {
		return productService.search(page, size);
	}

	@PutMapping("/{id}")
	public ProductDTO changeProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) throws Exception {
		productDTO.setId(id);
		productService.updateProduct(id, productDTO);
		return productDTO;
	}

	@DeleteMapping("/{id}")
	public ProductDTO deleteProduct(@PathVariable Long id) throws Exception {
		return productService.deleteProduct(id);
	}
}
