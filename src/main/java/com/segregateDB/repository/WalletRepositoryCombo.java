package com.segregateDB.repository;

import com.segregateDB.repository.readRepository.WalletReadRepository;
import com.segregateDB.repository.writeRepository.WalletWriteRepository;

public interface WalletRepositoryCombo extends WalletReadRepository, WalletWriteRepository {
}
