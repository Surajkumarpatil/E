package com.infy.employee.Service;

import com.infy.employee.DTO.EmployeeDTO;
import com.infy.employee.Exception.AlreadyExistsException;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO getEmployee(Integer employeeId);

    void deleteEmployee(Integer employeeId);

    void UpdateEmployee(Integer employeeId, EmployeeDTO employeeDTO);

}

