package br.com.devxlabs.ravin.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devxlabs.ravin.models.dtos.ProductDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {
    
    @Autowired
    private ProductService productService;

    @Test
    public void test() {
        List<ProductDTO> products = productService.getAllProducts();
        Assertions.assertTrue(products.size() == 0, "There's no object in the list");
    }
}
