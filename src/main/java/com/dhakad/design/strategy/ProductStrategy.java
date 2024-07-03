package com.dhakad.design.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductStrategy {
    private static final List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }


    public BigDecimal calculateProductsPrice(){
        return products.stream()
                .map(Product::getProductPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void pay(Payment paymentMethod){
        BigDecimal bigDecimal = calculateProductsPrice();
        paymentMethod.pay(bigDecimal);
    }

}
