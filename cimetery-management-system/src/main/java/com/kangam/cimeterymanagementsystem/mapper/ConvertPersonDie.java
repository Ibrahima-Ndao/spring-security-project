package com.kangam.cimeterymanagementsystem.mapper;

import com.kangam.cimeterymanagementsystem.dto.PersonDiedto;
import com.kangam.cimeterymanagementsystem.model.PersonDie;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConvertPersonDie {
    public static PersonDie toPersonDie(PersonDiedto personDiedto){
        PersonDie pd = new PersonDie();
        pd.setDateOfDie(LocalDateTime.parse(personDiedto.getDateOfDie()));
        pd.setSexe(personDiedto.getSexe());
        pd.setLieu(personDiedto.getLieu());
        pd.setCard_number(personDiedto.getCard_number());
        pd.setDefunctName(personDiedto.getDefunctName());
        pd.setCodeRef(personDiedto.getCodeRef());
        return pd;
    }
    public static PersonDiedto toPersonDieDTO(PersonDie personDie){
        PersonDiedto personDiedto = new PersonDiedto();
        personDiedto.setId(personDie.getId());
        personDiedto.setSexe(personDie.getSexe());
        personDiedto.setLieu(personDie.getLieu());
        personDiedto.setDateOfDie(personDie.getDateOfDie().toString());
        personDiedto.setCodeRef(personDie.getCodeRef());
        personDiedto.setDefunctName(personDie.getDefunctName());
        personDiedto.setCard_number(personDie.getCard_number());
        return personDiedto;
    }
}
