package com.jtspringproject.JtSpringProject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void testDefaultConstructor() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertNotNull(shoppingCart, "ShoppingCart instance should not be null");
    }

    @Test
    void testSetAndGetId() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(42);
        assertEquals(42, shoppingCart.getId(), "ID should match the value that was set");
    }

    @Test
    void testSetAndGetCustomer() {
        ShoppingCart shoppingCart = new ShoppingCart();
        User customer = new User();
        customer.setId(10);
        customer.setUsername("testuser");

        shoppingCart.setCustomer(customer);

        assertNotNull(shoppingCart.getCustomer(), "Customer should not be null");
        assertEquals(10, shoppingCart.getCustomer().getId(), "Customer ID should match");
        assertEquals("testuser", shoppingCart.getCustomer().getUsername(), "Customer username should match");
    }

    @Test
    void testCustomerDefaultsToNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertNull(shoppingCart.getCustomer(), "Customer should default to null");
    }

    @Test
    void testSetCustomerToNull() {
        ShoppingCart shoppingCart = new ShoppingCart();
        User customer = new User();
        shoppingCart.setCustomer(customer);
        shoppingCart.setCustomer(null);
        assertNull(shoppingCart.getCustomer(), "Customer should be null after being set to null");
    }
}
