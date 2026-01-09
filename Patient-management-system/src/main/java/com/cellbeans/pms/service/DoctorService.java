package com.cellbeans.pms.service;

import com.cellbeans.pms.entity.Doctor;

import javax.print.Doc;

public interface DoctorService {

    Doctor registerDoctor(Doctor doctor);
    Doctor login(String email, String password);
    Doctor getDoctorById(Long doctorId);

}
