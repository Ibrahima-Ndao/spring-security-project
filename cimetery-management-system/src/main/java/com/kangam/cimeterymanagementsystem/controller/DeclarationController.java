package com.kangam.cimeterymanagementsystem.controller;

import com.kangam.cimeterymanagementsystem.dto.Declarationdto;
import com.kangam.cimeterymanagementsystem.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/declaration")
public class DeclarationController {
    @Autowired
    private IDeclarationService declarationService;
    @PostMapping
    public ResponseEntity<Declarationdto> create(@RequestBody Declarationdto declarationdto){
        ResponseEntity<Declarationdto> declarationdtoResponseEntity
                = new ResponseEntity<>(declarationService.create(declarationdto), HttpStatus.CREATED);
        return declarationdtoResponseEntity;
    }
    @GetMapping
    public ResponseEntity<List<Declarationdto>> read(){
        return new ResponseEntity<>(declarationService.read(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Declarationdto> findById(@PathVariable Long id){
        return new ResponseEntity<>(declarationService.findDeclarationById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Declarationdto> update(@RequestBody Declarationdto declarationdto, @PathVariable Long id){
        ResponseEntity<Declarationdto> declarationdtoResponseEntity
                = new ResponseEntity<>(declarationService.update(declarationdto, id), HttpStatus.CREATED);
        return declarationdtoResponseEntity;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        declarationService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
