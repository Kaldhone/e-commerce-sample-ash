package com.jtspringproject.JtSpringProject.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartProductTest {

    @Test
    void testConstructorAndGetters() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);

        Product product = new Product();
        product.setId(100);

        CartProduct cartProduct = new CartProduct(shoppingCart, product);

        assertNotNull(cartProduct.getId(), "CartProductId should not be null");
        assertEquals(1, cartProduct.getId().getCartId(), "Cart ID should match");
        assertEquals(100, cartProduct.getId().getProductId(), "Product ID should match");

        assertEquals(shoppingCart, cartProduct.getShoppingCart(), "ShoppingCart should match");
        assertEquals(product, cartProduct.getProduct(), "Product should match");
    }

    @Test
    void testSetters() {
        CartProduct cartProduct = new CartProduct();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(2);

        Product product = new Product();
        product.setId(200);

        cartProduct.setShoppingCart(shoppingCart);
        cartProduct.setProduct(product);
        cartProduct.setId(new CartProductId(shoppingCart.getId(), product.getId()));

        assertEquals(2, cartProduct.getId().getCartId());
        assertEquals(200, cartProduct.getId().getProductId());
        assertEquals(shoppingCart, cartProduct.getShoppingCart());
        assertEquals(product, cartProduct.getProduct());
    }
}
