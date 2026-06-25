package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import com.jtspringproject.JtSpringProject.models.Cart;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class cartDao {
    private final SessionFactory sessionFactory;

    public cartDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Cart addCart(Cart shoppingCart) {
        this.sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart;
    }

    @Transactional
    public List<Cart> getCarts() {
        return this.sessionFactory.getCurrentSession().createQuery("from CART", Cart.class).list();
    }

    @Transactional
    public void updateCart(Cart shoppingCart) {
        this.sessionFactory.getCurrentSession().update(shoppingCart);
    }

    @Transactional
    public void deleteCart(Cart shoppingCart) {
        this.sessionFactory.getCurrentSession().delete(shoppingCart);
    }
}
