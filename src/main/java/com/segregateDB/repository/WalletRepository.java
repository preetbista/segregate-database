package com.segregateDB.repository;

import com.segregateDB.enums.VerificationStatus;
import com.segregateDB.model.Wallet;
import com.segregateDB.repository.readRepository.WalletReadRepository;
import com.segregateDB.repository.writeRepository.WalletWriteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class WalletRepository implements WalletRepositoryCombo{
    private final WalletReadRepository readRepository;
    private final WalletWriteRepository writeRepository;

    public WalletRepository(WalletReadRepository walletReadRepository, WalletWriteRepository walletWriteRepository) {
        this.readRepository = walletReadRepository;
        this.writeRepository = walletWriteRepository;
    }

    @Override
    public <S extends Wallet> S save(S s){
        return writeRepository.save(s);
    }

    @Override
    public <S extends Wallet> List<S> saveAll(Iterable<S> iterable) {
        return writeRepository.saveAll(iterable);
    }

    @Override
    public Optional<Wallet> findById(Long aLong) {
        return readRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return readRepository.existsById(aLong);
    }

    @Override
    public List<Wallet> findAll() {
        return readRepository.findAll();
    }

    @Override
    public List<Wallet> findAllById(Iterable<Long> iterable) {
        return readRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return readRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        writeRepository.deleteById(aLong);
    }

    @Override
    public void delete(Wallet customer) {
        writeRepository.delete(customer);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Wallet> iterable) {
        writeRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        writeRepository.deleteAll();
    }

    @Override
    public void flush() {
        
    }

    @Override
    public <S extends Wallet> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Wallet> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Wallet> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Wallet getOne(Long aLong) {
        return null;
    }

    @Override
    public Wallet getById(Long aLong) {
        return null;
    }

    @Override
    public Wallet getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Wallet> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Wallet> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Wallet> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Wallet> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Wallet> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Wallet> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Wallet, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Wallet> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Wallet> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Wallet> findByVerificationStatus(VerificationStatus verificationStatus) {
        return readRepository.findByVerificationStatus(verificationStatus);
    }

}
