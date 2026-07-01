package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.models.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class shoppingCartDaoTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @InjectMocks
    private shoppingCartDao shoppingCartDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    @Test
    void addCart_savesCartAndReturnsIt() {
        Cart cart = new Cart();
        cart.setId(1);

        Cart result = shoppingCartDao.addCart(cart);

        verify(session, times(1)).save(cart);
        assertEquals(cart, result);
    }

    @Test
    void getCarts_returnsListOfCarts() {
        Cart cart1 = new Cart();
        cart1.setId(1);
        Cart cart2 = new Cart();
        cart2.setId(2);

        @SuppressWarnings("unchecked")
        Query<Cart> query = mock(Query.class);
        when(session.createQuery("from CART", Cart.class)).thenReturn(query);
        when(query.list()).thenReturn(Arrays.asList(cart1, cart2));

        List<Cart> result = shoppingCartDao.getCarts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
    }

    @Test
    void getCarts_returnsEmptyListWhenNoCarts() {
        @SuppressWarnings("unchecked")
        Query<Cart> query = mock(Query.class);
        when(session.createQuery("from CART", Cart.class)).thenReturn(query);
        when(query.list()).thenReturn(List.of());

        List<Cart> result = shoppingCartDao.getCarts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void updateCart_callsSessionUpdate() {
        Cart cart = new Cart();
        cart.setId(3);

        shoppingCartDao.updateCart(cart);

        verify(session, times(1)).update(cart);
    }

    @Test
    void deleteCart_callsSessionDelete() {
        Cart cart = new Cart();
        cart.setId(4);

        shoppingCartDao.deleteCart(cart);

        verify(session, times(1)).delete(cart);
    }
}
