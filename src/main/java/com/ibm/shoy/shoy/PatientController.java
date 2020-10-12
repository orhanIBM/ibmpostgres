package com.ibm.shoy.shoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patient/{id}")
    public Optional<Patient> getPatient(@PathVariable Long id) {
        return patientService.getOneById(id);
    }

    @GetMapping("/patient")
    public ResponseEntity<Iterable<Patient>> getPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping("/patient")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.saveOnePatient(patient);
    }
}