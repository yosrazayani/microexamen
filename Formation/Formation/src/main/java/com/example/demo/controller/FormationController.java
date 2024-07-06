package com.example.demo.controller;


import com.example.demo.entity.Formation;
import com.example.demo.service.FormationService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/formation")
public class FormationController {
 
    @Autowired
    private FormationService formationService;
 
    @GetMapping
    public List<Formation> getAllFormation() {
        return formationService.findAll();
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable String id) {
        Optional<Formation> formation = formationService.findById(id);
        if (formation.isPresent()) {
            return ResponseEntity.ok(formation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    @PostMapping
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.save(formation);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable String id, @RequestBody Formation formationDetails) {
        Optional<Formation> formation = formationService.findById(id);
        if (formation.isPresent()) {
        	Formation existingFormation = formation.get();
            existingFormation.setId(formationDetails.getId());
            existingFormation.setName(formationDetails.getName());
            existingFormation.setPrix(formationDetails.getPrix());
            final Formation updatedFormation = formationService.save(existingFormation);
            return ResponseEntity.ok(updatedFormation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable String id) {
        Optional<Formation> formation = formationService.findById(id);
        if (formation.isPresent()) {
        	formationService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}