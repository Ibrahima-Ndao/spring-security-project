package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.dto.Declarationdto;
import com.kangam.cimeterymanagementsystem.mapper.ConvertDeclaration;
import com.kangam.cimeterymanagementsystem.model.Declaration;
import com.kangam.cimeterymanagementsystem.repository.DeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarationService implements IDeclarationService{
    @Autowired
    private DeclarationRepository declarationRepository;
    @Autowired
    private ConvertDeclaration convertDeclaration;
    @Override
    public Declarationdto create(Declarationdto declarationdto){
        Declaration declaration = convertDeclaration.toPersonDie(declarationdto);
        declaration = declarationRepository.save(declaration);
        declarationdto = convertDeclaration.toPersonDieDTO(declaration);
        return declarationdto;
    }
    @Override
    public Declarationdto findDeclarationById(Long id){
        Declaration declaration = declarationRepository.findById(id).orElse(null);
        if (declaration == null){
            return null;
        }
        Declarationdto declarationdto = convertDeclaration.toPersonDieDTO(declaration);
        return declarationdto;
    }
    @Override
    public Declarationdto update(Declarationdto declarationdto, Long id){
        Declaration declaration = declarationRepository.findById(id).orElse(null);
        if (declaration == null){
            return null;
        }
        declaration.setEmailOfDeclarer(declarationdto.getEmailOfDeclarer());
        declaration.setNumberOfDeclarer(declarationdto.getNumberOfDeclarer());
        declaration.setFullNameOfDeclarer(declarationdto.getFullNameOfDeclarer());
        declaration.setDateOfDie(LocalDateTime.parse(declarationdto.getDateOfDie()));
        declaration.setSexe(declarationdto.getSexe());
        declaration.setLieu(declarationdto.getLieu());
        declaration.setCard_number(declarationdto.getCard_number());
        declaration.setCodeRef(declarationdto.getCodeRef());
        declaration.setDefunctName(declarationdto.getDefunctName());
        declarationRepository.save(declaration);
        Declarationdto dto = convertDeclaration.toPersonDieDTO(declaration);
        return dto;
    }
    @Override
    public List<Declarationdto> read(){
        List<Declaration> declarations = declarationRepository.findAll();
        return declarations.stream().map(ConvertDeclaration::toPersonDieDTO).collect(Collectors.toList());
    }
    @Override
    public void delete(Long id){
        declarationRepository.deleteById(id);
    }
}
