package com.infy.employee.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String houseNumber;
    private String streetName;
    private String postalCode;
    private String cityName;
    private String district;
    private String country;
}
