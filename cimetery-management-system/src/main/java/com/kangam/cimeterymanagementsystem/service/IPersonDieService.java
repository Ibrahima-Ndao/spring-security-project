package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.dto.PersonDiedto;

import java.util.List;

public interface IPersonDieService {
    PersonDiedto create(PersonDiedto personDiedto);

    List<PersonDiedto> read();

    PersonDiedto findById(Long id);

    PersonDiedto update(PersonDiedto personDiedto, Long id);

    void delete(Long id);

    List<PersonDiedto> findPersonDieByCode_ref(String code);
}
