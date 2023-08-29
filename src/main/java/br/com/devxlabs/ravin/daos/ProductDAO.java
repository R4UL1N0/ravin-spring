package br.com.devxlabs.ravin.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devxlabs.ravin.models.entities.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

    Optional<Product> findProductByCode(String code);
    
}
