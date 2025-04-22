package com.vpam.picpay.service;

import com.vpam.picpay.controller.dto.CreateWalletDto;
import com.vpam.picpay.entity.Wallet;
import com.vpam.picpay.exception.WalletDataAlreadyExistsException;
import com.vpam.picpay.reposittory.WalletRepository;
import com.vpam.picpay.reposittory.WalletTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("cpfCnpj or Email already exists");
        }
        return walletRepository.save(dto.toWallet());
    }
}
