package com.kangam.cimeterymanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_die")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String defunctName;
    private String gender;
    private LocalDateTime dateOfDie;
    private String code_ref;
    private String lieu;
    @Column(name = "card_number", unique = true, nullable = false, length = 12)
    private String card_number;
}
