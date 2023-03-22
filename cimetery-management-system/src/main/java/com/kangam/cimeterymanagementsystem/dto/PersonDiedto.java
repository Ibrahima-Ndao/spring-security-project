package com.kangam.cimeterymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDiedto {
    private Long id;
    private String defunctName;
    private String gender;
    private String dateOfDie;
    private String code_ref;
    private String lieu;
    private String card_number;
}
