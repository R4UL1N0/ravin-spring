package br.com.devxlabs.ravin.daos;

import org.springframework.data.repository.CrudRepository;

import br.com.devxlabs.ravin.models.entities.Product;

public interface ProductDAO extends CrudRepository<Product, Long>{
    
}
