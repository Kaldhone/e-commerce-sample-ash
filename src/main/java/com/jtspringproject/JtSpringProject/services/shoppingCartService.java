package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.ShoppingCart;

import org.springframework.stereotype.Service;

@Service
public class shoppingCartService {

    private final shoppingCartDao shoppingCartDao;

    public shoppingCartService(shoppingCartDao shoppingCartDao) {
        this.shoppingCartDao = shoppingCartDao;
    }

    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartDao.addShoppingCart(shoppingCart);
    }

    public List<ShoppingCart> getShoppingCarts() {
        return this.shoppingCartDao.getShoppingCarts();
    }

    public void updateShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDao.updateShoppingCart(shoppingCart);
    }

    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDao.deleteShoppingCart(shoppingCart);
    }
}
