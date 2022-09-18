package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Employee;
import com.example.ShopProject.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService ;

    @PostMapping("/employee/SignUp")
    Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // to do Employee login
    @GetMapping( "/employee/login")
    Employee login (@RequestBody Map<String , String> e_credential){
        return employeeService.getEmployee(e_credential.get("email") , e_credential.get("password")) ;

    }

}
