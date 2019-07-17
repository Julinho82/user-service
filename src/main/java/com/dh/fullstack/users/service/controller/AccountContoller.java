package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.repositories.AccountRespository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@Api(
        tags = "Account Rest",
        description = "Operation Over Accounts"
)
@RestController
@RequestMapping("/accounts") //para colocar el path
@RequestScope
public class AccountContoller {

    @Autowired
    private AccountRespository accountRespository;

    @ApiOperation(
            value = "EndPoint to create account"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized to create account"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Not Found Test Account"
            )
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Account createAccount(@RequestBody AccountInput input) {

        Account account = new Account();

        account.setEmail(input.getEmail());
        account.setState(input.getState());
        return accountRespository.save(account);

    }
}
