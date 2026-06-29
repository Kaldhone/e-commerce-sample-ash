package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cartService {
    private final shoppingCartDao shoppingCartDao;

    @Autowired
    public cartService(shoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public Cart addCart(Cart cart) {
        return shoppingCartDao.addCart(cart);
    }

    public List<Cart> getCarts() {
        return this.shoppingCartDao.getCarts();
    }

    public void updateCart(Cart cart) {
        shoppingCartDao.updateCart(cart);
    }

    public void deleteCart(Cart cart) {
        shoppingCartDao.deleteCart(cart);
    }
}
