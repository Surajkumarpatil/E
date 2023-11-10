package com.infy.employee.Repo;

import com.infy.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

   // Optional<Employee> findByEmailId(String emailId);

    Optional<Employee> findOneByEmailIdAndPassword(String emailId, String password);

    Employee findByEmailId(String emailId);
}
