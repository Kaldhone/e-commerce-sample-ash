package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.models.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartDaoTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Query<Cart> query;

    @InjectMocks
    private shoppingCartDao shoppingCartDao;

    @BeforeEach
    void setUp() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    void addCart_savesAndReturnsCart() {
        Cart cart = new Cart();
        cart.setId(1);

        Cart result = shoppingCartDao.addCart(cart);

        verify(session).save(cart);
        assertEquals(cart, result);
    }

    @Test
    void getCarts_returnsListFromSession() {
        List<Cart> expected = List.of(new Cart(), new Cart());
        when(session.createQuery("from CART", Cart.class)).thenReturn(query);
        when(query.list()).thenReturn(expected);

        List<Cart> result = shoppingCartDao.getCarts();

        assertEquals(expected, result);
    }

    @Test
    void updateCart_delegatesToSession() {
        Cart cart = new Cart();
        cart.setId(2);

        shoppingCartDao.updateCart(cart);

        verify(session).update(cart);
    }

    @Test
    void deleteCart_delegatesToSession() {
        Cart cart = new Cart();
        cart.setId(3);

        shoppingCartDao.deleteCart(cart);

        verify(session).delete(cart);
    }
}
