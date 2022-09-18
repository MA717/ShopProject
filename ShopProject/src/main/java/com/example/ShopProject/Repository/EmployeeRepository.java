package com.example.ShopProject.Repository;


import com.example.ShopProject.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

   Employee findByEmailAndPassword(String email, String password);
}
