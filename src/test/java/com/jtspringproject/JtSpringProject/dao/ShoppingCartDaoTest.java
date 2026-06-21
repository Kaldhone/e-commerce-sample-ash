package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.models.ShoppingCart;
import com.jtspringproject.JtSpringProject.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartDaoTest {

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Query<ShoppingCart> query;

    private shoppingCartDao shoppingCartDao;

    @BeforeEach
    void setUp() {
        shoppingCartDao = new shoppingCartDao(sessionFactory);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    // -------------------------------------------------------------------------
    // addShoppingCart
    // -------------------------------------------------------------------------

    @Test
    void addShoppingCart_savesAndReturnsCart() {
        ShoppingCart shoppingCart = buildCart(1, "alice");

        ShoppingCart result = shoppingCartDao.addShoppingCart(shoppingCart);

        verify(session, times(1)).save(shoppingCart);
        assertEquals(shoppingCart, result, "addShoppingCart should return the saved cart");
    }

    // -------------------------------------------------------------------------
    // getShoppingCarts
    // -------------------------------------------------------------------------

    @Test
    void getShoppingCarts_returnsListFromSession() {
        List<ShoppingCart> expected = Arrays.asList(buildCart(1, "alice"), buildCart(2, "bob"));
        when(session.createQuery("from CART", ShoppingCart.class)).thenReturn(query);
        when(query.list()).thenReturn(expected);

        List<ShoppingCart> result = shoppingCartDao.getShoppingCarts();

        assertEquals(expected, result, "Should return the list provided by the session");
        verify(session, times(1)).createQuery("from CART", ShoppingCart.class);
    }

    @Test
    void getShoppingCarts_returnsEmptyList_whenNoneExist() {
        when(session.createQuery("from CART", ShoppingCart.class)).thenReturn(query);
        when(query.list()).thenReturn(Collections.emptyList());

        List<ShoppingCart> result = shoppingCartDao.getShoppingCarts();

        assertNotNull(result, "Result should not be null");
        assertTrue(result.isEmpty(), "Result should be an empty list");
    }

    // -------------------------------------------------------------------------
    // updateShoppingCart
    // -------------------------------------------------------------------------

    @Test
    void updateShoppingCart_callsSessionUpdate() {
        ShoppingCart shoppingCart = buildCart(1, "alice");

        shoppingCartDao.updateShoppingCart(shoppingCart);

        verify(session, times(1)).update(shoppingCart);
    }

    // -------------------------------------------------------------------------
    // deleteShoppingCart
    // -------------------------------------------------------------------------

    @Test
    void deleteShoppingCart_callsSessionDelete() {
        ShoppingCart shoppingCart = buildCart(1, "alice");

        shoppingCartDao.deleteShoppingCart(shoppingCart);

        verify(session, times(1)).delete(shoppingCart);
    }

    // -------------------------------------------------------------------------
    // helpers
    // -------------------------------------------------------------------------

    private ShoppingCart buildCart(int cartId, String username) {
        User user = new User();
        user.setUsername(username);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(cartId);
        shoppingCart.setCustomer(user);
        return shoppingCart;
    }
}
