package com.example.ShopProject.Controller;

import com.example.ShopProject.Entity.Employee;
import com.example.ShopProject.Entity.User;
import com.example.ShopProject.Service.EmployeeService;
import com.example.ShopProject.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;
    UserService  userService ;
    //
    @PostMapping("/employee/signup")
    String addEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        User user = User.builder().username(employee.getEmail())
                .password(employee.getPassword())
                .Role("Employee")
                .name(employee.getFirstName())
                .build();
        userService.saveUser(user);

        return "Create Employee Account Successfully" ;
    }

    // to do Employee login
    @GetMapping("/employee/login")
    Employee login(@RequestBody Map<String, String> e_credential) {
        return employeeService.getEmployee(e_credential.get("email"), e_credential.get("password"));

    }

}
