package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Formation;
import com.example.demo.repository.FormationRepository;

@Service
public class FormationService {


 
    @Autowired
    private FormationRepository formationRepository;
 
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }
 
    public Optional<Formation> findById(String id) {
        return formationRepository.findById(id);
    }
 
    public Formation save(Formation formation) {
        return formationRepository.save(formation);
    }
 
    public void deleteById(String id) {
    	formationRepository.deleteById(id);
    }}