package com.infy.employee.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "designation")
    private String designation;
    @Column(name = "joining_date")
    private LocalDate joiningDate;
    @Column(name = "skills")
    private List<String> skills;
    @Column(name = "primary_skills")
    private String primarySkills;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "organization")
    private String organization;
    @Column(name = "unit")
    private String unit;
    @Column(name = "mobile_number")
    private long mobileNumber;
    @Column(name = "address")
    @JdbcTypeCode(SqlTypes.JSON)
    private Address address;

    public boolean isEmpty() {
        return false;
    }
}
