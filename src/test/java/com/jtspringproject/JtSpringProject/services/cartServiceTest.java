package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class cartServiceTest {

    @Mock
    private shoppingCartDao shoppingCartDao;

    @InjectMocks
    private cartService cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addCart_delegatesToShoppingCartDaoAndReturnsCart() {
        Cart cart = new Cart();
        cart.setId(1);
        when(shoppingCartDao.addCart(cart)).thenReturn(cart);

        Cart result = cartService.addCart(cart);

        verify(shoppingCartDao, times(1)).addCart(cart);
        assertEquals(cart, result);
    }

    @Test
    void getCarts_returnsListFromShoppingCartDao() {
        Cart cart1 = new Cart();
        cart1.setId(1);
        Cart cart2 = new Cart();
        cart2.setId(2);
        when(shoppingCartDao.getCarts()).thenReturn(Arrays.asList(cart1, cart2));

        List<Cart> result = cartService.getCarts();

        verify(shoppingCartDao, times(1)).getCarts();
        assertEquals(2, result.size());
    }

    @Test
    void getCarts_returnsEmptyListWhenNoCarts() {
        when(shoppingCartDao.getCarts()).thenReturn(Collections.emptyList());

        List<Cart> result = cartService.getCarts();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void updateCart_delegatesToShoppingCartDao() {
        Cart cart = new Cart();
        cart.setId(3);

        cartService.updateCart(cart);

        verify(shoppingCartDao, times(1)).updateCart(cart);
    }

    @Test
    void deleteCart_delegatesToShoppingCartDao() {
        Cart cart = new Cart();
        cart.setId(4);

        cartService.deleteCart(cart);

        verify(shoppingCartDao, times(1)).deleteCart(cart);
    }
}
