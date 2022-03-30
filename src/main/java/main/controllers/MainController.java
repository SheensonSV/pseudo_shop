package main.controllers;

import lombok.AllArgsConstructor;
import main.entitys.Product;
import main.services.CartService;
import main.services.ProductService;
import main.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class MainController {
    private CartService cartService;
    private ProductService productService;
    private UserService userService;

    @GetMapping("hello")
    public String sayHello() {
        return "Hello " + LocalDateTime.now();
    }
    @GetMapping("hello2")
    public Product sayHello2() {
        return productService.getProductById(1L);
    }
    @GetMapping("hello3")
    public ResponseEntity<Product> sayHello3() {
        return new ResponseEntity<>(productService.getProductById(1L), HttpStatus.OK);
    }
    @GetMapping("hello4")
    public Product sayHello4(Model model) {
        model.addAttribute("product", productService.getProductById(1L));
        return (Product) model.getAttribute("product");
    }
}
