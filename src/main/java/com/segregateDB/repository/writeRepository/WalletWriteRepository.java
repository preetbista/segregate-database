package com.segregateDB.repository.writeRepository;

import com.segregateDB.enums.VerificationStatus;
import com.segregateDB.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletWriteRepository extends JpaRepository<Wallet, Long> {
    List<Wallet> findByVerificationStatus(VerificationStatus verificationStatus);
}
