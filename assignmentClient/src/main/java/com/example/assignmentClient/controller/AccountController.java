package com.example.assignmentClient.controller;

import com.example.assignmentClient.model.Account;
import com.example.assignmentClient.service.AccountService;
import com.example.assignmentClient.service.AccountServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listAccounts", accountService.getAllAccount());
        return "Index";
    }

    @GetMapping("/showNewAccountForm")
    public String showNewAccountForm(Model model) {
        // create model attribute to bind form data
        Account account = new Account();
        model.addAttribute("account", account);
        return "CreateAccount";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account account) {
        // save employee to database
        accountService.saveAccount(account);
        return "redirect:/";
    }

    @GetMapping("/showSearchAccountForm")
    public String showSearchAccountForm(Model model){
        // create model attribute to bind form data
        Account account = new Account();
        model.addAttribute("account", account);
        return "FindAccount";
    }

    @GetMapping("/showData/{id}")
    public Account showData(@PathVariable(value="id") Integer accountNum){
        // get account from the service
        Account account = accountService.getAccountById(accountNum);
        return account;
    }

    @RequestMapping(value = "/searchAccount", method = { RequestMethod.GET, RequestMethod.POST })
    public String searchAccount(@ModelAttribute("account") Account account, Model model){
        account = showData(account.getAccountNum());
        model.addAttribute("account", account);
        return "DetailAccount";
    }
}
