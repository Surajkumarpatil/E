package com.infy.employee.Service;

import com.infy.employee.DTO.LoginDTO;
import com.infy.employee.DTO.RegisterDTO;
import com.infy.employee.Exception.AlreadyExistsException;
import com.infy.employee.Utility.LoginResponse;

public interface LoginSignUpService {

    LoginResponse loginEmployee(LoginDTO loginDTO) throws AlreadyExistsException;

    Integer signUp(RegisterDTO registerDTO) throws AlreadyExistsException;
}
