package com.cellbeans.pms.controller;


import com.cellbeans.pms.entity.Patient;
import com.cellbeans.pms.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    // constructor dependency injection
    private  final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    // Patient Register
    @PostMapping("/patientRegister")
    public ResponseEntity<?> registerPatient(@RequestBody @Valid Patient patient) {
        try {
            return ResponseEntity.ok(patientService.registerPatient(patient));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Login
    @PostMapping("/patientLogin")
    public ResponseEntity<?> login(@RequestParam String email,
                                   @RequestParam String password) {
        try {
            Patient patient = patientService.login(email, password);
            return ResponseEntity.ok(patient);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    // Logout
    @GetMapping("/patientLogout/{id}")
    public ResponseEntity<?> logout(@PathVariable Long id) {
        try {
            patientService.logout(id);
            return ResponseEntity.ok("Patient logged out successfully");
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


    // search my Email
    @GetMapping("/patientByEmail")
    public ResponseEntity<?> getPatientByEmail(@RequestParam String email) {
        try {
            Patient patient = patientService.getPatientByEmailID(email)
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            return ResponseEntity.ok(patient);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    // delete patient using id
    @DeleteMapping("/deletePatientBy/{id}")
    public ResponseEntity<?> deletePatientBy(@PathVariable Long id) {
        try {
            patientService.deletePatient(id);
            return ResponseEntity.ok("Patient deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
