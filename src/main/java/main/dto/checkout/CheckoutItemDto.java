package main.dto.checkout;

import lombok.AllArgsConstructor;
import main.entitys.Cart;
import main.entitys.User;

@AllArgsConstructor
public class CheckoutItemDto {
    private User user;
    private Cart cart;

}
