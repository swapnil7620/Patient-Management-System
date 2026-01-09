package com.cellbeans.pms.service;

import com.cellbeans.pms.entity.Patient;

import java.util.Optional;

public interface PatientService {

    Patient registerPatient(Patient patient);
    Patient login(String email, String password);
    void logout(Long patientId);
    Optional<Patient> getPatientByEmailID(String email);
    void  deletePatient(Long patientId);
}

