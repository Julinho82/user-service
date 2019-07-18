package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.repositories.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class AccountCreateService {

    private AccountInput input;

    @Autowired
    private AccountRespository accountRespository;

    public Account save(){
        return accountRespository.save(composeAccountInstance());
    }

    private Account composeAccountInstance(){
        Account instance= new Account();
        instance.setState(input.getState());
        instance.setEmail(input.getEmail());

        return instance;
    }

    public void setInput (AccountInput input){
    this.input=input;
    }

}
