package com.cellbeans.pms.service.serviceImplimentation;

import com.cellbeans.pms.entity.Doctor;
import com.cellbeans.pms.entity.Patient;
import com.cellbeans.pms.entity.Prescription;
import com.cellbeans.pms.repository.DoctorRepository;
import com.cellbeans.pms.repository.PatientRepository;
import com.cellbeans.pms.repository.PrescriptionRepository;
import com.cellbeans.pms.service.PrescriptionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrescriptionServiceImp implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final DoctorRepository doctorRepository;
    private  final PatientRepository patientRepository;

    public PrescriptionServiceImp(PrescriptionRepository prescriptionRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public Prescription createPrescription(Long doctorId, Long patientId, String description) {

        Doctor doctor = doctorRepository.findById(doctorId).
                orElseThrow(()-> new RuntimeException("doctor  not found"));

        Patient patient = patientRepository.findById(patientId).
                orElseThrow(()->new RuntimeException("patient not found"));

        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setDescription(description);
        prescription.setDate(LocalDateTime.now());
        return prescriptionRepository.save(prescription);
    }


    @Override
    public List<Prescription> getPrescriptionByPatient(Long patientId) {

        if (!patientRepository.existsById(patientId)) {
            throw new RuntimeException("Patient not found");
        }

        return prescriptionRepository.findByPatient_Id(patientId);
    }



    @Override
    public List<Prescription> getPrescriptionByDoctor(Long doctorId) {

        if (!doctorRepository.existsById(doctorId)) {
            throw new RuntimeException("Doctor not found");
        }

        return prescriptionRepository.findByDoctor_Id(doctorId);
    }


}
