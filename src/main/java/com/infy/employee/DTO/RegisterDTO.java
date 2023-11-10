package com.infy.employee.DTO;


import com.infy.employee.Entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    @NotNull(message = "{employee.empId.notpresent}")
    private int employeeId;

    @NotNull(message = "{employee.firstname.notpresent}")
    private String firstName;

    @NotNull(message = "{employee.lastname.notpresent}")
    private String lastName;

    @NotNull(message = "{employee.gender.notpresent}")
    @Pattern(regexp = "(Male|Female|Other)", message = "{employee.gender.invalid}")
    private String gender;

    @NotNull(message = "{employee.emailId.notpresent}")
    @Email(message = "{employee.emailId.invalid}")
    private String emailId;

    @NotNull(message = "{employee.password.notpresent}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@-_#!])(?=\\S+$).{8,12}$",message = "{employee.password.invalid}")
    private String password;
    @NotNull(message = "{employee.mobileNumber.notpresent}")
    private long mobileNumber;
    private Address address;
}



