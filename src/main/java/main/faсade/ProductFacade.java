package main.faсade;

import lombok.AllArgsConstructor;
import main.dto.message.FailureDTO;
import main.dto.message.SuccessDTO;
import main.entitys.Product;
import main.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ProductFacade {
    private ProductService productService;

    public ResponseEntity<?> addNewProductToDB(Product product) {
        Product savedProduct = productService.save(product);
        if (savedProduct != null) {
            return new ResponseEntity<>(new SuccessDTO("Product added successfully to DB", HttpStatus.OK.toString(), LocalDateTime.now()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new FailureDTO("Product was not added to DB", LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getProductById(long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(new FailureDTO("User was not founded by ID in repository", LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
