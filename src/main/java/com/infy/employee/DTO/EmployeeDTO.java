package com.infy.employee.DTO;

import com.infy.employee.Entity.Address;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    @NotNull(message = "{employee.empId.notpresent}")
    private int employeeId;

    @NotNull(message = "{employee.firstname.notpresent}")
    private String firstName;

    @NotNull(message = "{employee.lastname.notpresent}")
    private String lastName;

    //@NotNull(message = "{employee.designation.notpresent}")
    @Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{employee.designation.invalid}")
    private String designation;

    //@NotNull(message = "{employee.joiningDate.notpresent}")
    private LocalDate joiningDate;

    //@NotNull(message = "{employee.skills.notpresent}")
    private String skills;

    //@NotNull(message = "{employee.primaryskill.notpresent}")
    private String primarySkills;

    @NotNull(message = "{employee.emailId.notpresent}")
    @Email(message = "{employee.emailId.invalid}")
    private String emailId;

    @NotNull(message = "{employee.password.notpresent}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@-_#!])(?=\\S+$).{8,12}$",message = "{login.password.invalid}")
    private String password;

    @NotNull(message = "{employee.gender.notpresent}")
    @Pattern(regexp = "(Male|Female|Other)", message = "{employee.gender.invalid}")
    private String gender;
    private String organization;
    private String unit;
    @NotNull(message = "{employee.mobileNumber.notpresent}")
    private long mobileNumber;
    private Address address;

}
