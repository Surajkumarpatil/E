package com.infy.employee.ServiceImpl;

import com.infy.employee.DTO.EmployeeDTO;
import com.infy.employee.Entity.Employee;
import com.infy.employee.Exception.NotFoundException;
import com.infy.employee.Repo.EmployeeRepo;
import com.infy.employee.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeSerivceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        Iterable<Employee> employees = repo.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);

            employeeDTOS.add(employeeDTO);
        }
        if (employeeDTOS.isEmpty())
            throw new NotFoundException("Employees not found in the List");
        return employeeDTOS;
    }

    @Override
    public EmployeeDTO getEmployee(Integer employeeId) {
        Optional<Employee> optional = repo.findById(employeeId);
        Employee employee = optional.orElseThrow(() -> new NotFoundException("Employee not found with Id: "+ employeeId));

        EmployeeDTO employeeDTO = this.modelMapper.map(employee, EmployeeDTO.class);


        return employeeDTO;
    }


    @Override
    public void deleteEmployee(Integer employeeId) {
        Optional<Employee> optional = repo.findById(employeeId);
        optional.orElseThrow(() -> new NotFoundException("Employee not found with Id: "+ employeeId));
        repo.deleteById(employeeId);
    }

    @Override
    public void UpdateEmployee(Integer employeeId, EmployeeDTO employeeDTO) {
        Optional<Employee> optional = repo.findById(employeeDTO.getEmployeeId());
        optional.orElseThrow(() -> new NotFoundException("Employee not found"));

        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDesignation(employeeDTO.getDesignation());
        employee.setJoiningDate(employeeDTO.getJoiningDate());
        employee.setSkills(Collections.singletonList(employeeDTO.getSkills()));
        employee.setPrimarySkills(employeeDTO.getPrimarySkills());
        employee.setEmailId(employeeDTO.getEmailId());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        employee.setGender(employeeDTO.getGender());
        employee.setOrganization(employeeDTO.getOrganization());
        employee.setUnit(employeeDTO.getUnit());
        employee.setMobileNumber(employeeDTO.getMobileNumber());
        employee.setAddress(employeeDTO.getAddress());

        repo.save(employee);
    }
}

