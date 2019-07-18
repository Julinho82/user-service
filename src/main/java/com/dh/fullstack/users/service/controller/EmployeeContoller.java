package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.EmployeeCreateInput;
import com.dh.fullstack.users.service.model.domain.Employee;
import com.dh.fullstack.users.service.service.EmployeeCreateService;
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
        tags = "Employee Rest",
        description = "Operation Over Employee"
)
@RestController
@RequestMapping("/public/employees") //para colocar el path
@RequestScope
public class EmployeeContoller {

    @Autowired
    private EmployeeCreateService employeeCreateService;

    @ApiOperation(
            value = "EndPoint to create employee"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized to create employee"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Not Found Test employee"
            )
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody EmployeeCreateInput input) {

       employeeCreateService.setInput(input);
       employeeCreateService.execute();

       return  employeeCreateService.getEmployee();

    }
}
