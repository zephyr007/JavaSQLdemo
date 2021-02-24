package com.example.Assignment2.Wallet.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransWithoutID {
    public Long payer_phone_number;
    public Long payee_phone_number;
    public int amount;

    public Long getPayer_phone_number() {
        return payer_phone_number;
    }

    public Long getPayee_phone_number() {
        return payee_phone_number;
    }

    public int getAmount() {
        return amount;
    }

    //    payee_phone_number,amount
}
