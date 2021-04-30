package com.example.assignmentClient.service;

import com.example.assignmentClient.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    void saveAccount(Account account);
    Account getAccountById(Integer id);
}
