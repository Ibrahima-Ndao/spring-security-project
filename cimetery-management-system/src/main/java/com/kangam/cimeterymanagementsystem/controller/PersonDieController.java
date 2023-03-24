package com.kangam.cimeterymanagementsystem.controller;

import com.kangam.cimeterymanagementsystem.dto.PersonDiedto;
import com.kangam.cimeterymanagementsystem.service.IPersonDieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personDie")
public class PersonDieController {
    @Autowired
    private IPersonDieService personDieService;
    @PostMapping
    public ResponseEntity<PersonDiedto> save(@RequestBody PersonDiedto personDiedto){
        return new ResponseEntity<PersonDiedto>(personDieService.create(personDiedto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PersonDiedto>> read(){
        return new ResponseEntity<>(personDieService.read(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDiedto> read(@PathVariable Long id){
        return new ResponseEntity<>(personDieService.findById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PersonDiedto> update(@RequestBody PersonDiedto personDiedto,@PathVariable Long id){
        return new ResponseEntity<>(personDieService.update(personDiedto, id), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        personDieService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/code_ref/{code}")
    public ResponseEntity<List<PersonDiedto>> findByCode_ref(@PathVariable String code){
        return  new ResponseEntity<>(
                personDieService.findPersonDieByCode_ref(code),
                HttpStatus.OK
        );
    }
}
