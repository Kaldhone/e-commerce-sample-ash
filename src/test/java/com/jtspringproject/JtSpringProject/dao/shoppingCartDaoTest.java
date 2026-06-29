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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class shoppingCartDaoTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @InjectMocks
    private shoppingCartDao dao;

    @BeforeEach
    void setUp() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    void addCart_savesAndReturnsCart() {
        Cart cart = new Cart();
        Cart result = dao.addCart(cart);
        verify(session).save(cart);
        assertSame(cart, result);
    }

    @Test
    void updateCart_updatesCart() {
        Cart cart = new Cart();
        dao.updateCart(cart);
        verify(session).update(cart);
    }

    @Test
    void deleteCart_deletesCart() {
        Cart cart = new Cart();
        dao.deleteCart(cart);
        verify(session).delete(cart);
    }

    @Test
    @SuppressWarnings("unchecked")
    void getCarts_returnsListFromQuery() {
        Query<Cart> query = mock(Query.class);
        List<Cart> expected = List.of(new Cart());
        when(session.createQuery("from CART", Cart.class)).thenReturn(query);
        when(query.list()).thenReturn(expected);

        List<Cart> result = dao.getCarts();

        assertEquals(expected, result);
    }
}
