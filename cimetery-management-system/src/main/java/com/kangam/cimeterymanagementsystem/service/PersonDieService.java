package com.kangam.cimeterymanagementsystem.service;

import com.kangam.cimeterymanagementsystem.dto.PersonDiedto;
import com.kangam.cimeterymanagementsystem.mapper.ConvertPersonDie;
import com.kangam.cimeterymanagementsystem.model.PersonDie;
import com.kangam.cimeterymanagementsystem.repository.PersonDieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonDieService implements IPersonDieService{
    @Autowired
    private PersonDieRepository personDieRepository;
    @Autowired
    private ConvertPersonDie convertPersonDie;
    @Override
    public PersonDiedto create(PersonDiedto personDiedto){
        PersonDie personDie = convertPersonDie.toPersonDie(personDiedto);
         personDie = personDieRepository.save(personDie);
         personDiedto = convertPersonDie.toPersonDieDTO(personDie);
        return personDiedto;
    }
    @Override
    public List<PersonDiedto> read(){
        List<PersonDiedto> personDiedtos = personDieRepository.findAll().stream()
                .map(ConvertPersonDie::toPersonDieDTO)
                .collect(Collectors.toList());
        return personDiedtos;
    }
    @Override
    public PersonDiedto findById(Long id){
        PersonDie personDie = personDieRepository.findById(id).orElse(null);
        if (personDie == null){
            return null;
        }
        PersonDiedto dto = convertPersonDie.toPersonDieDTO(personDie);
        return dto;
    }
    @Override
    public PersonDiedto update(PersonDiedto personDiedto, Long id){
        Optional<PersonDie> personDie = personDieRepository.findById(id);
        PersonDiedto dto = null;
        if (personDie.isPresent()){
            PersonDie pd = personDie.get();
            pd.setDateOfDie(LocalDateTime.parse(personDiedto.getDateOfDie()));
            pd.setSexe(personDiedto.getSexe());
            pd.setLieu(personDiedto.getLieu());
            pd.setCard_number(personDiedto.getCard_number());
            pd.setDefunctName(personDiedto.getDefunctName());
            pd.setCodeRef(personDiedto.getCodeRef());
            dto = convertPersonDie.toPersonDieDTO(pd);
            personDieRepository.save(pd);

        }
        return dto;
    }
    @Override
    public void  delete(Long id){
        personDieRepository.deleteById(id);
    }
    @Override
    public List<PersonDiedto> findPersonDieByCode_ref(String code){
        List<PersonDie> personDies = personDieRepository.findByCodeRef(code);
        return personDies.stream()
                .map(ConvertPersonDie::toPersonDieDTO)
                .collect(Collectors.toList());
    }
}
