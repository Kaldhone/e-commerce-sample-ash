package com.jtspringproject.JtSpringProject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartProductIdTest {

    @Test
    void testDefaultConstructor() {
        ShoppingCartProductId id = new ShoppingCartProductId();
        assertNotNull(id, "ShoppingCartProductId instance should not be null");
        assertNull(id.getCartId(), "cartId should default to null");
        assertNull(id.getProductId(), "productId should default to null");
    }

    @Test
    void testParameterisedConstructorAndGetters() {
        ShoppingCartProductId id = new ShoppingCartProductId(1, 2);

        assertEquals(1, id.getCartId(), "cartId should be 1");
        assertEquals(2, id.getProductId(), "productId should be 2");
    }

    @Test
    void testSetters() {
        ShoppingCartProductId id = new ShoppingCartProductId();
        id.setCartId(5);
        id.setProductId(10);

        assertEquals(5, id.getCartId(), "cartId should be 5 after setter");
        assertEquals(10, id.getProductId(), "productId should be 10 after setter");
    }

    @Test
    void testEquals_sameValues() {
        ShoppingCartProductId id1 = new ShoppingCartProductId(1, 2);
        ShoppingCartProductId id2 = new ShoppingCartProductId(1, 2);

        assertEquals(id1, id2, "Two IDs with the same values should be equal");
    }

    @Test
    void testEquals_differentValues() {
        ShoppingCartProductId id1 = new ShoppingCartProductId(1, 2);
        ShoppingCartProductId id2 = new ShoppingCartProductId(2, 3);

        assertNotEquals(id1, id2, "Two IDs with different values should not be equal");
    }

    @Test
    void testEquals_sameInstance() {
        ShoppingCartProductId id = new ShoppingCartProductId(1, 2);
        assertEquals(id, id, "An ID should equal itself");
    }

    @Test
    void testEquals_null() {
        ShoppingCartProductId id = new ShoppingCartProductId(1, 2);
        assertNotEquals(null, id, "An ID should not equal null");
    }

    @Test
    void testEquals_differentType() {
        ShoppingCartProductId id = new ShoppingCartProductId(1, 2);
        assertNotEquals("string", id, "An ID should not equal an object of a different type");
    }

    @Test
    void testHashCode_equalObjects() {
        ShoppingCartProductId id1 = new ShoppingCartProductId(1, 2);
        ShoppingCartProductId id2 = new ShoppingCartProductId(1, 2);

        assertEquals(id1.hashCode(), id2.hashCode(), "Equal objects must have equal hash codes");
    }

    @Test
    void testHashCode_differentObjects() {
        ShoppingCartProductId id1 = new ShoppingCartProductId(1, 2);
        ShoppingCartProductId id2 = new ShoppingCartProductId(3, 4);

        assertNotEquals(id1.hashCode(), id2.hashCode(), "Different objects should typically have different hash codes");
    }
}
