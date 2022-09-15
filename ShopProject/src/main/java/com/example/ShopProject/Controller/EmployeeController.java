package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Customer;
import com.example.ShopProject.Entity.Employee;
import com.example.ShopProject.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService ;

    @PostMapping("/Employee/SignUp")
    Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
}
