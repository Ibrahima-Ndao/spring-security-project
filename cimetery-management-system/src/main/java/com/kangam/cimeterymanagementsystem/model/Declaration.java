package com.kangam.cimeterymanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declaration extends PersonDie{
    private String fullNameOfDeclarer;
    private String numberOfDeclarer;
    private String emailOfDeclarer;
}
