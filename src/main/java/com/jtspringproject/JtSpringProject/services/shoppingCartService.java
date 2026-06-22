package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class shoppingCartService {
    private final shoppingCartDao shoppingCartDao;

    @Autowired
    public shoppingCartService(shoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public ShoppingCart addCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.addCart(shoppingCart);
    }

    public List<ShoppingCart> getCarts() {
        return this.shoppingCartDao.getCarts();
    }

    public void updateCart(ShoppingCart shoppingCart) {
        shoppingCartDao.updateCart(shoppingCart);
    }

    public void deleteCart(ShoppingCart shoppingCart) {
        shoppingCartDao.deleteCart(shoppingCart);
    }
}
