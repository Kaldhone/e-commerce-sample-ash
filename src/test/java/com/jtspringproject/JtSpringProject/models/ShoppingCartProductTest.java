package com.jtspringproject.JtSpringProject.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartProductTest {

    @Test
    void testDefaultConstructor() {
        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();
        assertNotNull(shoppingCartProduct, "ShoppingCartProduct instance should not be null");
        assertNull(shoppingCartProduct.getId(), "ID should default to null");
        assertNull(shoppingCartProduct.getShoppingCart(), "ShoppingCart should default to null");
        assertNull(shoppingCartProduct.getProduct(), "Product should default to null");
    }

    @Test
    void testParameterisedConstructorSetsIdCorrectly() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);

        Product product = new Product();
        product.setId(100);

        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(shoppingCart, product);

        assertNotNull(shoppingCartProduct.getId(), "ShoppingCartProductId should not be null");
        assertEquals(1, shoppingCartProduct.getId().getCartId(), "Cart ID in composite key should match");
        assertEquals(100, shoppingCartProduct.getId().getProductId(), "Product ID in composite key should match");
    }

    @Test
    void testParameterisedConstructorSetsReferencesCorrectly() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);

        Product product = new Product();
        product.setId(100);

        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(shoppingCart, product);

        assertEquals(shoppingCart, shoppingCartProduct.getShoppingCart(), "ShoppingCart reference should match");
        assertEquals(product, shoppingCartProduct.getProduct(), "Product reference should match");
    }

    @Test
    void testSetters() {
        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(2);

        Product product = new Product();
        product.setId(200);

        ShoppingCartProductId id = new ShoppingCartProductId(shoppingCart.getId(), product.getId());

        shoppingCartProduct.setShoppingCart(shoppingCart);
        shoppingCartProduct.setProduct(product);
        shoppingCartProduct.setId(id);

        assertEquals(2, shoppingCartProduct.getId().getCartId(), "cartId should be 2");
        assertEquals(200, shoppingCartProduct.getId().getProductId(), "productId should be 200");
        assertEquals(shoppingCart, shoppingCartProduct.getShoppingCart(), "ShoppingCart should match");
        assertEquals(product, shoppingCartProduct.getProduct(), "Product should match");
    }

    @Test
    void testCompositeKeyMatchesEntities() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(7);

        Product product = new Product();
        product.setId(77);

        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct(shoppingCart, product);

        assertEquals(shoppingCart.getId(), shoppingCartProduct.getId().getCartId(),
                "Composite key cartId must match ShoppingCart id");
        assertEquals(product.getId(), shoppingCartProduct.getId().getProductId(),
                "Composite key productId must match Product id");
    }
}
