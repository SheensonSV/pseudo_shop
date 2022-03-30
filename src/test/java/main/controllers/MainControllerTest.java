package main.controllers;

import main.Shop;
import main.entitys.Product;
import main.services.ProductService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Shop.class})
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MainControllerTest {

    @Autowired
    ProductService productService;

    @Autowired
    MockMvc mvc;

    @MockBean
    MainController mainController;

    @Test
    public void helloTest() throws Exception {
        when(mainController.sayHello()).thenCallRealMethod();
        mvc.perform(get("/api/v1/hello")).andExpect(status().isOk());
    }

    @Test
    public void hello2Test() throws Exception {
        Product product = productService.getProductById(0L);
        when(mainController.sayHello2()).thenReturn(product);



//        mvc.perform(get("/api/v1/hello2")).andExpect(productService.getProductById(0L));
    }
}
