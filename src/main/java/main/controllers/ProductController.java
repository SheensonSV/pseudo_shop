package main.controllers;

import lombok.AllArgsConstructor;
import main.entitys.Product;
import main.faсade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/product")
public class ProductController {
    private ProductFacade productFacade;

    public ResponseEntity<?> addNewProduct(@RequestBody Product product) {
        return productFacade.addNewProductToDB(product);
    }
}
