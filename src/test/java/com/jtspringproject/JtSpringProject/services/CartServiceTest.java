package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.Cart;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private shoppingCartDao cartDao;

    @InjectMocks
    private cartService cartService;

    @Test
    void addCart_delegatesToDao() {
        Cart cart = new Cart();
        when(cartDao.addCart(cart)).thenReturn(cart);

        Cart result = cartService.addCart(cart);

        assertEquals(cart, result);
        verify(cartDao).addCart(cart);
    }

    @Test
    void getCarts_returnsFromDao() {
        List<Cart> carts = List.of(new Cart(), new Cart());
        when(cartDao.getCarts()).thenReturn(carts);

        List<Cart> result = cartService.getCarts();

        assertEquals(carts, result);
        verify(cartDao).getCarts();
    }

    @Test
    void updateCart_delegatesToDao() {
        Cart cart = new Cart();

        cartService.updateCart(cart);

        verify(cartDao).updateCart(cart);
    }

    @Test
    void deleteCart_delegatesToDao() {
        Cart cart = new Cart();

        cartService.deleteCart(cart);

        verify(cartDao).deleteCart(cart);
    }
}
