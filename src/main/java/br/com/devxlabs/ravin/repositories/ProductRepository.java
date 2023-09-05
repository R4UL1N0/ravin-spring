package br.com.devxlabs.ravin.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devxlabs.ravin.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findProductByCode(String code);

    @Query("SELECT p FROM Product p WHERE p.costPrice >= :c")
    List<Product> findProductsCostPriceGreaterThan(@Param("c") double costPrice);

    @Query("SELECT p FROM Product p WHERE p.costPrice <= :c")
    List<Product> findProductsCostPriceLessThan(@Param("c") double costPrice);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :letters%")
    List<Product> findProductsStartingWith(@Param("letters") String letters);

    List<Product> findProductByCreatedDate(LocalDate date);

    @Query("SELECT p.name FROM Product p")
    List<String> getProductNames();


    
}
