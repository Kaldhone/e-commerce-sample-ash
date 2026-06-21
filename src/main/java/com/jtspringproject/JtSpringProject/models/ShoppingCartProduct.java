package com.jtspringproject.JtSpringProject.models;

import javax.persistence.*;

@Entity
@Table(name = "CART_PRODUCT")
public class ShoppingCartProduct {

    @EmbeddedId
    private ShoppingCartProductId id;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public ShoppingCartProduct() {}

    public ShoppingCartProduct(ShoppingCart shoppingCart, Product product) {
        this.shoppingCart = shoppingCart;
        this.product = product;
        this.id = new ShoppingCartProductId(shoppingCart.getId(), product.getId());
    }

    public ShoppingCartProductId getId() {
        return id;
    }

    public void setId(ShoppingCartProductId id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
