package main.controllers;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import main.entitys.Cart;
import main.entitys.Product;
import main.entitys.User;
import main.faсade.UserFacade;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserFacade userFacade;

    @PostMapping("/add")
    public HttpEntity<?> addUser(@RequestBody User user) {
        return userFacade.addUser(user);
    }

    @GetMapping("/get{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        return userFacade.getUser(id);
    }

    @PutMapping("/add_product")
    public ResponseEntity<?> addProductToCart(@NotNull @RequestBody User user, @RequestBody Cart cart, @RequestBody Product product) {
        return userFacade.addProductToCart(user, cart, product);
    }
}
