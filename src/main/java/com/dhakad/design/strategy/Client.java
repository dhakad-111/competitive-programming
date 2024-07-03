package com.dhakad.design.strategy;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {


        
        

        ProductStrategy strategy = new ProductStrategy();

        Product build = Product.builder().productName("Mobile Phone")
                .productDescription("Best mobile phone")
                .upcCode("123bac")
                .productPrice(BigDecimal.valueOf(56000))
                .build();

        strategy.addProduct(build);

        Paypal paypal = Paypal.builder()
                .email("dsurendradhakad@gmail.com")
                .password("dhakad@123")
                .build();

        CreditCard creditCard = CreditCard.builder()
                .cardHolderName("Surendra Dhakad")
                .cardNumber("1234567")
                .cvv("1234")
                .dateOfExpiry("04-09-2028")
                .build();
        strategy.pay(creditCard);
        strategy.pay(paypal);
    }
}
