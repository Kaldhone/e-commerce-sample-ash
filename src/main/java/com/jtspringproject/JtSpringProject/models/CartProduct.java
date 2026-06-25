package com.jtspringproject.JtSpringProject.models;

import javax.persistence.*;

@Entity
@Table(name = "CART_PRODUCT")
public class CartProduct {

    @EmbeddedId
    private CartProductId id;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart shoppingCart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public CartProduct() {}

    public CartProduct(Cart shoppingCart, Product product) {
        this.shoppingCart = shoppingCart;
        this.product = product;
        this.id = new CartProductId(shoppingCart.getId(), product.getId());
    }

    public CartProductId getId() {
        return id;
    }

    public void setId(CartProductId id) {
        this.id = id;
    }

    public Cart getCart() {
        return shoppingCart;
    }

    public void setCart(Cart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
