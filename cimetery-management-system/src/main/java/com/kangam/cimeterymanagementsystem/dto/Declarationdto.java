package com.kangam.cimeterymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Declarationdto extends PersonDiedto{
    private String fullNameOfDeclarer;
    private String numberOfDeclarer;
    private String emailOfDeclarer;
}
