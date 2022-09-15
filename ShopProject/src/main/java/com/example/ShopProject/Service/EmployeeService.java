package com.example.ShopProject.Service;

import com.example.ShopProject.Entity.Employee;
import com.example.ShopProject.Repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@Builder
public class EmployeeService {
    EmployeeRepository employeeRepository ;

    public Employee saveEmployee ( Employee employee )
    {
          return  employeeRepository.save(employee);
    }

}