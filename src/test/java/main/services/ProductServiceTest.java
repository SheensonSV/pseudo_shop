package main.services;

import main.entitys.Product;
import main.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @MockBean
    ProductService productService;

    @Mock
    ProductRepo productRepo;

    @Test
    public void getProductsTest(){
        assertNotNull(productRepo);
        when(productRepo.findAll())
                .thenReturn(Stream.of(
                        new Product("Sugar", "Common sweet sugar", 33F),
                        new Product("Potato", "Potato white", 44F))
                        .collect(Collectors.toList()));

        productRepo.findAll().forEach(t -> {
            System.out.println(t.getName() + " " + t.getDescription() + " " + t.getPrice());
        });

        assertNotNull(productService);
        assertEquals(2, productService.getProducts().size());
    }

    @Test
    public void saveProductTest() {
        Product product = new Product("Vodka", "Common Red Vodka", 200F);
        when(productRepo.save(product)).thenReturn(product);
        assertEquals(product, productService.save(product));
    }

}
