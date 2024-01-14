package com.segregateDB.service.impl;

import com.segregateDB.enums.VerificationStatus;
import com.segregateDB.model.Wallet;
import com.segregateDB.repository.WalletRepository;
import com.segregateDB.repository.readRepository.WalletReadRepository;
import com.segregateDB.repository.writeRepository.WalletWriteRepository;
import com.segregateDB.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final WalletWriteRepository walletWriteRepository;
    private final WalletReadRepository walletReadRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository, WalletWriteRepository walletWriteRepository, WalletReadRepository walletReadRepository) {
        this.walletRepository = walletRepository;
        this.walletWriteRepository = walletWriteRepository;
        this.walletReadRepository = walletReadRepository;
    }

    @Override
    public Optional<Wallet> getWallet(Long id) {
        log.info("Getting wallet information for wallet ID: {}", id);
        return walletRepository.findById(id);
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        log.info("Creating wallet for user");
        Assert.notNull(wallet, "Invalid customer");
        Assert.isNull(wallet.getId(), "customer id should be null");
        Assert.notNull(wallet.getFirstName(), "FirstName cannot be null");
        Assert.notNull(wallet.getLastName(), "LastName cannot be null");
        Assert.notNull(wallet.getPhoneNumber(), "Phone number cannot be null");
        Assert.notNull(wallet.getAddress(), "Address cannot be null");
        Assert.notNull(wallet.getGender(), "Gender must be defined");
        wallet.setVerificationStatus(VerificationStatus.UNVERIFIED);
        log.info("Wallet created successfully for user: {}", wallet.getFirstName());
        return walletWriteRepository.save(wallet);
    }

    @Override
    public Wallet updateWallet(Wallet wallet) {

        Assert.notNull(wallet, "Invalid customer");
        Assert.notNull(wallet.getId(), "Invalid customer id");

        return walletRepository.save(wallet);
    }

    @Override
    public void transferData() {
        log.info("Initiating data transfer request");
        List<Wallet> dataToTransfer = walletWriteRepository.findByVerificationStatus(VerificationStatus.VERIFIED);

        for (Wallet entity : dataToTransfer) {
            if (entity.getVerificationStatus() == VerificationStatus.UNVERIFIED) {
                continue;
            }
            Wallet wallet = new Wallet();

            wallet.setFirstName(entity.getFirstName());
            wallet.setLastName(entity.getLastName());
            wallet.setPhoneNumber(entity.getPhoneNumber());
            wallet.setAddress(entity.getAddress());
            wallet.setGender(entity.getGender());
            wallet.setVerificationStatus(VerificationStatus.VERIFIED);

            log.info("Data successfully transferred to another instance ");
            walletReadRepository.save(wallet);
        }
    }


}
