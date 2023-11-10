package com.infy.employee.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @Email(message = "{employee.emailId.invalid}")
    @NotNull(message = "{employee.emailId.notpresent}")
    private String emailId;

    @NotNull(message = "{employee.password.notpresent}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@-_#!])(?=\\S+$).{8,12}$",message = "{login.password.invalid}")
    private String password;
}
