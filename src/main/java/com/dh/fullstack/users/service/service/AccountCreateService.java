package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.config.UsersProperties;
import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.repositories.AccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service
public class AccountCreateService {

    private AccountInput input;

    @Autowired
    private UsersProperties usersProperties;

    @Autowired
    private AccountRespository accountRespository;

    public Account save(){
        return accountRespository.save(composeAccountInstance());
    }

    private Account composeAccountInstance(){
        AccountState state=AccountState.DEACTIVATED;
        Boolean isPermit =isPermit();

        if (isPermit) {
            state= AccountState.ACTIVATED;
        }

        Account instance= new Account();
        instance.setState(state);
        instance.setEmail(input.getEmail());

        return instance;
    }

    private Boolean isPermit(){
        return input.getAge()>=usersProperties.getPermitAge();
    }

    public void setInput (AccountInput input){
    this.input=input;
    }

}
