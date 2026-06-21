package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import com.jtspringproject.JtSpringProject.models.ShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class shoppingCartDao {

    private final SessionFactory sessionFactory;

    public shoppingCartDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        this.sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart;
    }

    @Transactional
    public List<ShoppingCart> getShoppingCarts() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from CART", ShoppingCart.class)
                .list();
    }

    @Transactional
    public void updateShoppingCart(ShoppingCart shoppingCart) {
        this.sessionFactory.getCurrentSession().update(shoppingCart);
    }

    @Transactional
    public void deleteShoppingCart(ShoppingCart shoppingCart) {
        this.sessionFactory.getCurrentSession().delete(shoppingCart);
    }
}
