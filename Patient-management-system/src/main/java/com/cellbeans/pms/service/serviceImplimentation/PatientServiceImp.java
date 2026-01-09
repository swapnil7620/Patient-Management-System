package com.cellbeans.pms.service.serviceImplimentation;

import com.cellbeans.pms.entity.Patient;
import com.cellbeans.pms.repository.PatientRepository;
import com.cellbeans.pms.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientServiceImp implements PatientService {

    private  final PatientRepository patientRepository;

    // here we use constructor Dependency
    public PatientServiceImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // patient registration
    @Override
    public Patient registerPatient(Patient patient) {

        if (patientRepository.existsByPhoneNumber(patient.getPhoneNumber())) {
            throw new RuntimeException("Patient already registered with this phone number");
        }

        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new RuntimeException("Patient already registered with this email");
        }

        return patientRepository.save(patient);
    }


    // Patient Login
    @Override
    public Patient login(String email, String password) {

        Patient patient = patientRepository.findByEmail(email).
                orElseThrow(()-> new RuntimeException("patient not found"));

        if (!patient.getPassword().equals(password)){
            throw  new RuntimeException("Invalid credential");
        }

        patient.setLoginDateTime(LocalDateTime.now());
        return patientRepository.save(patient);

    }

    @Override
    public void logout(Long patientId) {
        Patient patient = patientRepository.findById(patientId).
                orElseThrow(()->new RuntimeException("patient not found"));

        patient.setLoginDateTime(null);
        patientRepository.save(patient);
    }


    @Override
    public Optional<Patient> getPatientByEmailID(String email) {
        return  patientRepository.findByEmail(email);
    }

    @Override
    public void deletePatient(Long patient_Id) {
          if(!patientRepository.existsById(patient_Id)){
              throw new RuntimeException("Patient not found with id: " + patient_Id);
          }
        patientRepository.deleteById(patient_Id);

    }
}
