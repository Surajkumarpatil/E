package com.infy.employee.Controller;

import com.infy.employee.DTO.EmployeeDTO;
import com.infy.employee.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    //...List of Employees..//
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
            List<EmployeeDTO> employeeDTOList = service.getAllEmployee();
            return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
        }

    //...Get Employee by Id...//
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("employeeId") Integer employeeId) {
        EmployeeDTO employeeDTO = service.getEmployee(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    //...update Employee by Id...//
    @PutMapping("/update/{employeeId}")
    public ResponseEntity<String> updateEmployee(@Valid @PathVariable Integer employeeId, @RequestBody EmployeeDTO employeeDTO) {
        service.UpdateEmployee(employeeId, employeeDTO);
        return new ResponseEntity<>("Employee Updated Successfully with: "+ employeeId, HttpStatus.OK);
    }

    //...delete Employee by Id...//
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        service.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully with id: "+ employeeId, HttpStatus.OK);
    }
}
