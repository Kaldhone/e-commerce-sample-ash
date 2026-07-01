package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cartService {
    private final shoppingCartDao cartDao;

    @Autowired
    public cartService(shoppingCartDao cartDao) {
        this.cartDao = cartDao;
    }

    public Cart addCart(Cart cart) {
        return cartDao.addCart(cart);
    }

    public List<Cart> getCarts() {
        return this.cartDao.getCarts();
    }

    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    public void deleteCart(Cart cart) {
        cartDao.deleteCart(cart);
    }
}
