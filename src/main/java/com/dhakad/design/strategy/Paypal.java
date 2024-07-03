package com.dhakad.design.strategy;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Paypal implements Payment {
    private String email;
    private String password;

    @Override
    public void pay(BigDecimal amount) {
        System.out.println(amount + " paid using paypal");
    }

}
