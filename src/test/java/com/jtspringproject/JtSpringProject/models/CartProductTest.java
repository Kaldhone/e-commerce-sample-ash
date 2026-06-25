package com.jtspringproject.JtSpringProject.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartProductTest {

    @Test
    void testConstructorAndGetters() {
        // Mocking simple Cart and Product objects with IDs
        Cart shoppingCart = new Cart();
        shoppingCart.setId(1);

        Product product = new Product();
        product.setId(100);

        CartProduct cartProduct = new CartProduct(shoppingCart, product);

        assertNotNull(cartProduct.getId(), "CartProductId should not be null");
        assertEquals(1, cartProduct.getId().getCartId(), "Cart ID should match");
        assertEquals(100, cartProduct.getId().getProductId(), "Product ID should match");

        assertEquals(shoppingCart, cartProduct.getCart(), "Cart should match");
        assertEquals(product, cartProduct.getProduct(), "Product should match");
    }

    @Test
    void testSetters() {
        CartProduct cartProduct = new CartProduct();

        Cart shoppingCart = new Cart();
        shoppingCart.setId(2);

        Product product = new Product();
        product.setId(200);

        cartProduct.setCart(shoppingCart);
        cartProduct.setProduct(product);
        cartProduct.setId(new CartProductId(shoppingCart.getId(), product.getId()));

        assertEquals(2, cartProduct.getId().getCartId());
        assertEquals(200, cartProduct.getId().getProductId());
        assertEquals(shoppingCart, cartProduct.getCart());
        assertEquals(product, cartProduct.getProduct());
    }
}
