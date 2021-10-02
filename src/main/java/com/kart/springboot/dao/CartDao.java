package com.kart.springboot.dao;

import com.kart.springboot.model.Cart;

public interface CartDao {
    Cart addCart(Cart cart);

    void updateCart(Cart cart);

    Cart getCartById(Long id);
}
