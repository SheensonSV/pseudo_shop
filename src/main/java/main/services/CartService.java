package main.services;

import lombok.AllArgsConstructor;
import main.entitys.Cart;
import main.entitys.Product;
import main.repo.CartRepo;
import main.repo.ProductRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CartService {
    private CartRepo cartRepo;
    private ProductRepo productRepo;

    public void addCart(Cart cart) {
        cartRepo.save(cart);
    }

    public Cart getCartById(long id) {
        Optional<Cart> cart = cartRepo.findById(id);
        return cart.orElse(null);
    }

    public boolean isCartExist(Cart cart) {
        return cartRepo.existsById(cart.getId());
    }

    public void deleteCartById(Cart cart) {
        cartRepo.delete(cart);
    }

    public void addProductToCart(Cart cart, Product product) {
        cart.addProduct(product);
        cartRepo.save(cart);
    }

    private double getTotalPriceFromProductList(List<Product> productList) {
        double totalPrice = 0;
        for (Product p : productList) {
            totalPrice += p.getPrice();
        }
        return totalPrice;
    }

    public List<Cart> getCarts() {
        List<Cart> cartList = new ArrayList<>();
        cartRepo.findAll().forEach(cartList::add);
        return cartList;
    }
}
