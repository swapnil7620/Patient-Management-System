package com.cellbeans.pms.service.serviceImplimentation;

import com.cellbeans.pms.entity.Doctor;
import com.cellbeans.pms.entity.Patient;
import com.cellbeans.pms.repository.DoctorRepository;
import com.cellbeans.pms.repository.PatientRepository;
import com.cellbeans.pms.service.DoctorService;
import com.cellbeans.pms.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DoctorServiceImp implements DoctorService {


private final DoctorRepository doctorRepository;

    public DoctorServiceImp(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        if (doctorRepository.existsByPhoneNumber(doctor.getPhoneNumber())) {
            throw new RuntimeException("Doctor already registered with this phone number");
        }

        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new RuntimeException("Doctor already registered with this email");
        }
       return doctorRepository.save(doctor);

    }

    @Override
    public Doctor login(String email, String password) {

        Doctor doctor = doctorRepository.findByEmail(email).
                orElseThrow(()->new RuntimeException("doctor not found"));

        if(!doctor.getPassword().equals(password)){
            throw new RuntimeException("Invalid credential");
        }
        return doctor;
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).
                orElseThrow(()-> new RuntimeException("doctor not found at this Id"));
    }
}
