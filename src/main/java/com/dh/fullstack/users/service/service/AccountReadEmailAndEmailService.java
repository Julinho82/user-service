package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Scope("prototype")
@Service
public class AccountReadEmailAndEmailService {

    private String email;

    private AccountState state;

    private Account account;

    @Autowired
    private AccountRepository accountRepository;


    public void excute(){
        account=findAccountByEmailAndState(email,state);
    }

    public Account findAccountByEmailAndState(String email, AccountState state){

        return accountRepository.findByEmailAndStateOrderByEmailAsc(email,state).orElse(null) ;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
