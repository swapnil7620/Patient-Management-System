package com.cellbeans.pms.service;

import com.cellbeans.pms.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
    Prescription createPrescription(Long doctorId, Long patientId, String Description);
    List<Prescription> getPrescriptionByPatient(Long patientId);
    List<Prescription> getPrescriptionByDoctor(Long doctorId);

}