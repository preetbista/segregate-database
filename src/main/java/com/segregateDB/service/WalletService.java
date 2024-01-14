package com.segregateDB.service;

import com.segregateDB.model.Wallet;

import java.util.Optional;

public interface WalletService {
    Optional<Wallet> getWallet(Long id);
    Wallet createWallet(Wallet wallet);
    Wallet updateWallet(Wallet wallet);
    void transferData();
}
