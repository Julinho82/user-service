package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.input.EmployeeCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.domain.Employee;
import com.dh.fullstack.users.service.model.repositories.AccountRespository;
import com.dh.fullstack.users.service.model.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

@Scope("prototype")
@Service
public class EmployeeCreateService {

    private EmployeeCreateInput input;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccountRespository accountRespository;

    private Employee employee;

    public void execute (){

        Account account = composeAccountInstance();
        account = accountRespository.save(account);

        Employee employeeInstance =composeEmployeeInstance(account);
        employee = employeeRepository.save(employeeInstance);

    }

    private Account composeAccountInstance() {
        Account instance= new Account();

        instance.setState(AccountState.DEACTIVATED);
        instance.setEmail(input.getEmail());

        return instance;

    }

    private Employee composeEmployeeInstance(Account account) {

        Employee instance =new Employee();
        instance.setFirstName(input.getFirstName());
        instance.setLastName(input.getLastName());
        instance.setEmail(input.getEmail());
        instance.setPassword(input.getPasword());
        instance.setActive(Boolean.TRUE);
        instance.setCreatedDate(new Date());
        instance.setAccount(account);

        return instance;
    }



    public Employee getEmployee() {
        return employee;
    }


    public void setInput(EmployeeCreateInput input) {
        this.input = input;
    }
}
