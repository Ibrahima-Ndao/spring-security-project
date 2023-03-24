package com.kangam.cimeterymanagementsystem.mapper;

import com.kangam.cimeterymanagementsystem.dto.Declarationdto;
import com.kangam.cimeterymanagementsystem.dto.PersonDiedto;
import com.kangam.cimeterymanagementsystem.model.Declaration;
import com.kangam.cimeterymanagementsystem.model.PersonDie;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConvertDeclaration {
    public Declaration toPersonDie(Declarationdto declarationdto){
        Declaration declaration = new Declaration();

        declaration.setEmailOfDeclarer(declarationdto.getEmailOfDeclarer());
        declaration.setNumberOfDeclarer(declarationdto.getNumberOfDeclarer());
        declaration.setFullNameOfDeclarer(declarationdto.getFullNameOfDeclarer());
        declaration.setDateOfDie(LocalDateTime.parse(declarationdto.getDateOfDie()));
        declaration.setSexe(declarationdto.getSexe());
        declaration.setLieu(declarationdto.getLieu());
        declaration.setCard_number(declarationdto.getCard_number());
        declaration.setCodeRef(declarationdto.getCodeRef());
        declaration.setDefunctName(declarationdto.getDefunctName());
        return declaration;
    }

    public static Declarationdto toPersonDieDTO(Declaration declaration){
        Declarationdto declarationdto = new Declarationdto();
        declarationdto.setId(declaration.getId());
        declarationdto.setEmailOfDeclarer(declaration.getEmailOfDeclarer());
        declarationdto.setNumberOfDeclarer(declaration.getNumberOfDeclarer());
        declarationdto.setFullNameOfDeclarer(declaration.getFullNameOfDeclarer());
        declarationdto.setDateOfDie(declaration.getDateOfDie().toString());
        declarationdto.setSexe(declaration.getSexe());
        declarationdto.setLieu(declaration.getLieu());
        declarationdto.setCard_number(declaration.getCard_number());
        declarationdto.setCodeRef(declaration.getCodeRef());
        declarationdto.setDefunctName(declaration.getDefunctName());
        return declarationdto;
    }
}
