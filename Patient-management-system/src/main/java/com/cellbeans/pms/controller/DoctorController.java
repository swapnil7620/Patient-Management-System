package com.cellbeans.pms.controller;


import com.cellbeans.pms.entity.Doctor;
import com.cellbeans.pms.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {


    /* constructor dependency injection */
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Register Doctor

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid Doctor doctor) {
        try {
            return ResponseEntity.ok(doctorService.registerDoctor(doctor));
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Doctor Login
    @PostMapping("/loginDoctor")
    public ResponseEntity<?> loginDoctor(@RequestParam String email,
                                   @RequestParam String password) {
        try {
            Doctor doctor = doctorService.login(email, password);
            return ResponseEntity.ok(doctor);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    // Get Doctor By id
    @GetMapping("/doctorByUsingId/{id}")
    public ResponseEntity<?> getDoctorByUsingId(@PathVariable Long id) {
        try {
            Doctor doctor = doctorService.getDoctorById(id);
            return ResponseEntity.ok(doctor);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


}
