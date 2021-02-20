package com.example.Assignment2.Wallet.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransWithoutID {
    public Long payer_phone_number;
    public Long payee_phone_number;
    public int amount;

//    payee_phone_number,amount
}
