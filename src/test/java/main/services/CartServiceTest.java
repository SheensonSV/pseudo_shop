package main.services;

import main.entitys.Cart;
import main.entitys.Product;
import main.repo.CartRepo;
import main.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {
    @Mock
    private CartService cartService;
    @Mock
    private CartRepo cartRepo;

    @Test
    void addCart() {
        assertNotNull(cartRepo);
        Cart cart = new Cart("First cart", new ArrayList<Product>());
        when(cartRepo.save(cart)).thenReturn(cart);

        assertEquals(1, cartService.getCarts().size());
    }

    @Test
    void getCartById() {
    }

    @Test
    void isCartExist() {
    }

    @Test
    void deleteCartById() {
    }

    @Test
    void addProductToCart() {
    }
}