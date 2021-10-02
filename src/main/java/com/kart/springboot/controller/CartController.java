package com.kart.springboot.controller;

import com.kart.springboot.model.Cart;
import com.kart.springboot.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/cart")
public class CartController {

    CartService cartService;

    @PostMapping("create/{userId}")
    public ResponseEntity<Cart> createCart(@PathVariable Long userId) throws Exception {
        log.debug("Create and add cart", userId);
        return ResponseEntity.ok(cartService.createCart(userId));
    }

    @PutMapping("/{cartId}/add/product/{productId}/{product}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) throws Exception {
        log.debug("Add product to cart", cartId, productId);
        return ResponseEntity.ok(cartService.addProduct(productId, cartId));
    }

    @DeleteMapping("/{cartId}/delete/product/{productId}")
    public ResponseEntity<Cart> deleteProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) throws Exception {
        log.debug("Delete product from cart", cartId, productId);
        return ResponseEntity.ok(cartService.deleteProduct(productId, cartId));
    }
}
