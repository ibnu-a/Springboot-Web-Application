package com.example.assignmentClient.service;

import com.example.assignmentClient.model.Account;
import com.example.assignmentClient.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplement implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Integer id) {
        Optional<Account> optional = accountRepository.findById(id);
        Account account = null;
        if (optional.isPresent()) {
            account = optional.get();
        } else {
            throw new RuntimeException(" Account not found for id :: " + id);
        }
        return account;
    }
}
