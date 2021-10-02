package com.kart.springboot.service;

import com.kart.springboot.dao.CartDao;
import com.kart.springboot.dao.ProductDao;
import com.kart.springboot.dao.UserDao;
import com.kart.springboot.model.Cart;
import com.kart.springboot.model.Product;
import com.kart.springboot.model.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Cart createCart(Long userId) {
        log.debug("Create cart", userId);
        Cart cart = new Cart();
        User user = userDao.getUserById(userId);
        Cart userCart = cartDao.addCart(cart);
        user.setCart(cart);
        userDao.updateUser(user);
        return userCart;
    }

    @Override
    public Cart addProduct(Long productId, Long cartId) throws Exception {
        log.debug("Add product", productId, cartId);
        Product product = productDao.getProductById(productId);
        Cart cart = cartDao.getCartById(cartId);
        cart.setSum(cart.getSum().multiply(product.getPrice()));
        cart.setPurchases(cart.getPurchases() + 1);
        cart.getProduct().add(product);
        cartDao.updateCart(cart);
        return cart;
    }

    @Override
    public Cart deleteProduct(Long productId, Long cartId) throws Exception {
        log.debug("Delete product", productId, cartId);
        Product product = productDao.getProductById(productId);
        Cart cart = cartDao.getCartById(cartId);
        for (Product p : cart.getProduct()) {
            if (productId.equals(p.getId())) {
                cart.setPurchases(cart.getPurchases() - 1);
                cart.getSum().subtract(product.getPrice());
                cartDao.updateCart(cart);
            }
        }
        return cart;
    }
}
