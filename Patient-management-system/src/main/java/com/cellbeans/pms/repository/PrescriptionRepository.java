package com.cellbeans.pms.repository;

import com.cellbeans.pms.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    List<Prescription> findByPatient_Id(Long patientId);
    List<Prescription> findByDoctor_Id(Long doctorId);

}
