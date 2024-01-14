package com.segregateDB.controller;

import com.segregateDB.handler.ResourceNotFoundException;
import com.segregateDB.model.Wallet;
import com.segregateDB.service.WalletService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(path = "/wallet/{id}")
    public Wallet getWallet(@PathVariable("id") Long id){
        return walletService.getWallet(id).orElseThrow(() -> new ResourceNotFoundException("Invalid walletId"));
    }

    @PostMapping(path = "/wallet")
    public Wallet createWallet(@RequestBody Wallet wallet){
        return walletService.createWallet(wallet);
    }

    @PutMapping(path = "/wallet")
    public Wallet updateWallet(@RequestBody Wallet wallet){
        return  walletService.updateWallet(wallet);
    }

    @PostMapping(path = "/transfer_data")
    public void transferData(){
        walletService.transferData();
    }
}
