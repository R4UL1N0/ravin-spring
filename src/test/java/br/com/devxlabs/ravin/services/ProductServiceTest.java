package br.com.devxlabs.ravin.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.entities.Product;
import br.com.devxlabs.ravin.models.enums.ProductType;
import br.com.devxlabs.ravin.repositories.ProductRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {
    
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ModelMapper mapper;


    @Test
    public void testGetAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        Assertions.assertTrue(products.size() != 0, "There's no object in the list");

    }
    

    @Test
    @Transactional
    public void testCreateAndDeleteProduct() throws Exception {

        ProductDTO p = new ProductDTO();
        p.setCode("234324");
        p.setName("Lucas");
        p.setDescription("blabla");
        p.setCostPrice(20.0);
        p.setSalePrice(30.0);
        p.setPreparationTime("1000");
        p.setComments("blabla");
        p.setProductType(ProductType.SNACK);

        productService.createProduct(p);

        Assert.assertTrue("Product should be found in the DB", productRepository.findProductByCode("234324").isPresent());

        Long pByCodeId = productRepository.findProductByCode("234324").get().getId();

        productService.deleteProduct(pByCodeId);
        
        

        Assert.assertFalse("Product should not be in the DB after removing", productRepository.findProductByCode("234324").isPresent());

        ProductDTO emptyP = new ProductDTO();
        Assert.assertThrows("Should not create empty Product", Exception.class, () -> {productService.createProduct(emptyP);});

    }

    @Test
    public void testProductDTOToEntity() {
        ProductDTO pDTO = new ProductDTO();
        Product p = new Product();

        when(mapper.map(pDTO, Product.class)).thenReturn(p);

        when(mapper.map(pDTO, Product.class)).thenReturn(any());
    }
}
