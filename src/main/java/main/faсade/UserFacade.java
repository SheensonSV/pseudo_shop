package main.faсade;

import lombok.AllArgsConstructor;
import main.dto.message.FailureDTO;
import main.dto.message.SuccessDTO;
import main.entitys.Cart;
import main.entitys.Product;
import main.entitys.User;
import main.services.CartService;
import main.services.ProductService;
import main.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class UserFacade {
    private UserService userService;
    private CartService cartService;
    private ProductService productService;

    public ResponseEntity<?> addUser(User user) {
        User savedUser = userService.save(user);
        if (savedUser != null) {
            return new ResponseEntity<>(new SuccessDTO("User was added Successfully to repository", HttpStatus.OK.toString(), LocalDateTime.now()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new FailureDTO("User doesn't was added to repository", LocalDateTime.now()), HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> getUser(long id) {
        User user = userService.getById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(new FailureDTO("User was not founded by ID in repository", LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    public void addCart(Cart cart) {
        cartService.addCart(cart);
    }

    public ResponseEntity<?> addProductToCart(User user, Cart cart, Product product) {
        if (cartService.isCartExist(cart)) {
            cartService.addProductToCart(cart, product);
            return new ResponseEntity<>(new SuccessDTO("Product added to cart", HttpStatus.OK.toString(), LocalDateTime.now()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new FailureDTO("Product didn't added to cart", LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }
}