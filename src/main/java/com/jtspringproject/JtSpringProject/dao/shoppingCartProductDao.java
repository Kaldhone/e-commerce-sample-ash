package com.jtspringproject.JtSpringProject.dao;

import java.util.Collections;
import java.util.List;

import com.jtspringproject.JtSpringProject.models.ShoppingCartProduct;
import com.jtspringproject.JtSpringProject.models.Product;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class shoppingCartProductDao {

    private final SessionFactory sessionFactory;

    public shoppingCartProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public ShoppingCartProduct addShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        this.sessionFactory.getCurrentSession().save(shoppingCartProduct);
        return shoppingCartProduct;
    }

    @Transactional
    public List<ShoppingCartProduct> getShoppingCartProducts() {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from CART_PRODUCT", ShoppingCartProduct.class)
                .list();
    }

    @Transactional
    public List<Product> getProductByShoppingCartId(Integer shoppingCartId) {
        String sql = "SELECT product_id FROM cart_product WHERE cart_id = :cart_id";
        List<Integer> productIds = this.sessionFactory.getCurrentSession()
                .createNativeQuery(sql)
                .setParameter("cart_id", shoppingCartId)
                .list();

        if (productIds.isEmpty()) {
            return Collections.emptyList();
        }

        sql = "SELECT * FROM product WHERE id IN (:product_ids)";
        return this.sessionFactory.getCurrentSession()
                .createNativeQuery(sql, Product.class)
                .setParameterList("product_ids", productIds)
                .list();
    }

    @Transactional
    public void updateShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        this.sessionFactory.getCurrentSession().update(shoppingCartProduct);
    }

    @Transactional
    public void deleteShoppingCartProduct(ShoppingCartProduct shoppingCartProduct) {
        this.sessionFactory.getCurrentSession().delete(shoppingCartProduct);
    }
}
