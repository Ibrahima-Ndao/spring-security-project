package com.kangam.cimeterymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PersonDiedto {
    private Long id;
    private String defunctName;
    private String sexe;
    private String dateOfDie;
    private String codeRef;
    private String lieu;
    private String card_number;
}
