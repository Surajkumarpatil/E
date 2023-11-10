package com.infy.employee.ServiceImpl;

import com.infy.employee.DTO.LoginDTO;
import com.infy.employee.DTO.RegisterDTO;
import com.infy.employee.Entity.Employee;
import com.infy.employee.Exception.AlreadyExistsException;
import com.infy.employee.Exception.EmployeeException;
import com.infy.employee.Repo.EmployeeRepo;
import com.infy.employee.Service.LoginSignUpService;
import com.infy.employee.Utility.LoginResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LoginSignUpServiceImpl implements LoginSignUpService {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) throws EmployeeException {
        String msg = "";
        Employee employee1 = repo.findByEmailId(loginDTO.getEmailId());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = repo.findOneByEmailIdAndPassword(loginDTO.getEmailId(),encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Successfully", Boolean.TRUE);
                } else {
                    return new LoginResponse("Login Failed", Boolean.FALSE);
                }
            }
            else {
                return new LoginResponse("Password Not Matched", Boolean.FALSE);
            }
        } else {
            return new LoginResponse("EmailId Not Exits", Boolean.FALSE);
        }
    }

    @Override
    public Integer signUp(RegisterDTO registerDTO) {
        Optional<Employee> optional = repo.findById(registerDTO.getEmployeeId());
        if(optional.isPresent())
            throw new AlreadyExistsException("Employee Already Exists");
        Employee employee = new Employee();
        employee.setEmployeeId(registerDTO.getEmployeeId());
        employee.setFirstName(registerDTO.getFirstName());
        employee.setLastName(registerDTO.getLastName());
        employee.setGender(registerDTO.getGender());
        employee.setEmailId(registerDTO.getEmailId());
        employee.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Employee employee1 = repo.save(employee);
        return employee1.getEmployeeId();
    }
}
