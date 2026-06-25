package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import com.jtspringproject.JtSpringProject.dao.cartDao;
import com.jtspringproject.JtSpringProject.models.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cartService {
    private final cartDao cartDao;

    @Autowired
    public cartService(cartDao cartDao) {
        this.cartDao = cartDao;
    }

    public Cart addCart(Cart shoppingCart) {
        return cartDao.addCart(shoppingCart);
    }

    public List<Cart> getCarts() {
        return this.cartDao.getCarts();
    }

    public void updateCart(Cart shoppingCart) {
        cartDao.updateCart(shoppingCart);
    }

    public void deleteCart(Cart shoppingCart) {
        cartDao.deleteCart(shoppingCart);
    }
}
