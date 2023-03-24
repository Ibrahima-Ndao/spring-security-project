package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.dto.Declarationdto;

import java.util.List;

public interface IDeclarationService {
    Declarationdto create(Declarationdto declarationdto);

    Declarationdto findDeclarationById(Long id);

    Declarationdto update(Declarationdto declarationdto, Long id);

    List<Declarationdto> read();

    void delete(Long id);
}
