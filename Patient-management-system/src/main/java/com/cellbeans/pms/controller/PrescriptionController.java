package com.cellbeans.pms.controller;


import com.cellbeans.pms.entity.Prescription;
import com.cellbeans.pms.service.PrescriptionService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // Doctor create prescription for patient

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestParam Long doctorId,
            @RequestParam Long patientId,
            @RequestParam String description) {

        try {
            Prescription prescription =
                    prescriptionService.createPrescription(doctorId, patientId, description);
            return ResponseEntity.status(HttpStatus.CREATED).body(prescription);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // get prescription by patient
    @GetMapping("/getByPatient/{patientId}")
    public ResponseEntity<?> getByPatient(@PathVariable Long patientId) {
        try {
            List<Prescription> prescriptions =
                    prescriptionService.getPrescriptionByPatient(patientId);
            return ResponseEntity.ok(prescriptions);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
    // get prescription by Doctor

    @GetMapping("/getByDoctor/{doctorId}")
    public ResponseEntity<?> getByDoctor(@PathVariable Long doctorId) {
        try {
            List<Prescription> prescriptions =
                    prescriptionService.getPrescriptionByDoctor(doctorId);
            return ResponseEntity.ok(prescriptions);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


}
