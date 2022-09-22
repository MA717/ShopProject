package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Employee;
import com.example.ShopProject.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
@Data
@AllArgsConstructor
@Builder
public class EmployeeService {
    @Autowired
    PasswordEncoder passwordEncoder;

    EmployeeRepository employeeRepository ;

    public Employee saveEmployee ( Employee employee )
    {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
          return  employeeRepository.save(employee);
    }

    public Employee getEmployee(String email , String password ) {

        return employeeRepository.findByEmailAndPassword(email , password);


    }
}
