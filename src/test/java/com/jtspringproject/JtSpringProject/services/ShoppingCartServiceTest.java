package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.shoppingCartDao;
import com.jtspringproject.JtSpringProject.models.ShoppingCart;
import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceTest {

    @Mock
    private shoppingCartDao shoppingCartDao;

    private shoppingCartService shoppingCartService;

    @BeforeEach
    void setUp() {
        shoppingCartService = new shoppingCartService(shoppingCartDao);
    }

    // -------------------------------------------------------------------------
    // addShoppingCart
    // -------------------------------------------------------------------------

    @Test
    void addShoppingCart_delegatesToDaoAndReturnsCart() {
        ShoppingCart shoppingCart = buildCart(1, "alice");
        when(shoppingCartDao.addShoppingCart(shoppingCart)).thenReturn(shoppingCart);

        ShoppingCart result = shoppingCartService.addShoppingCart(shoppingCart);

        assertNotNull(result, "Result should not be null");
        assertEquals(shoppingCart, result, "Returned cart should be the same object");
        verify(shoppingCartDao, times(1)).addShoppingCart(shoppingCart);
    }

    @Test
    void addShoppingCart_returnsNullWhenDaoReturnsNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        when(shoppingCartDao.addShoppingCart(shoppingCart)).thenReturn(null);

        ShoppingCart result = shoppingCartService.addShoppingCart(shoppingCart);

        assertNull(result, "Result should be null when DAO returns null");
    }

    // -------------------------------------------------------------------------
    // getShoppingCarts
    // -------------------------------------------------------------------------

    @Test
    void getShoppingCarts_returnsListFromDao() {
        List<ShoppingCart> carts = Arrays.asList(buildCart(1, "alice"), buildCart(2, "bob"));
        when(shoppingCartDao.getShoppingCarts()).thenReturn(carts);

        List<ShoppingCart> result = shoppingCartService.getShoppingCarts();

        assertEquals(2, result.size(), "Should return 2 shopping carts");
        assertEquals(carts, result, "Returned list should match DAO list");
        verify(shoppingCartDao, times(1)).getShoppingCarts();
    }

    @Test
    void getShoppingCarts_returnsEmptyListWhenNoneExist() {
        when(shoppingCartDao.getShoppingCarts()).thenReturn(Collections.emptyList());

        List<ShoppingCart> result = shoppingCartService.getShoppingCarts();

        assertNotNull(result, "Result should not be null");
        assertTrue(result.isEmpty(), "Result list should be empty");
    }

    // -------------------------------------------------------------------------
    // updateShoppingCart
    // -------------------------------------------------------------------------

    @Test
    void updateShoppingCart_delegatesToDao() {
        ShoppingCart shoppingCart = buildCart(1, "alice");
        doNothing().when(shoppingCartDao).updateShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        verify(shoppingCartDao, times(1)).updateShoppingCart(shoppingCart);
    }

    // -------------------------------------------------------------------------
    // deleteShoppingCart
    // -------------------------------------------------------------------------

    @Test
    void deleteShoppingCart_delegatesToDao() {
        ShoppingCart shoppingCart = buildCart(1, "alice");
        doNothing().when(shoppingCartDao).deleteShoppingCart(shoppingCart);

        shoppingCartService.deleteShoppingCart(shoppingCart);

        verify(shoppingCartDao, times(1)).deleteShoppingCart(shoppingCart);
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
