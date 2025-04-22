package com.vpam.picpay.controller.dto;

import com.vpam.picpay.entity.Wallet;
import com.vpam.picpay.entity.WalletType;

public record CreateWalletDto (String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletType.Enum walletType) {

    public Wallet toWallet() {
       return new Wallet(fullName,
                        cpfCnpj,
                        email,
                        password,
                        walletType.get()
        );
    }
}
