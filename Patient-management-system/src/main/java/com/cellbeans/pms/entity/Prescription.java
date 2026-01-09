package com.cellbeans.pms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "description is required")
    @Column(length = 200)
    private String description;

    // when doctor gave the  prescription
    private LocalDateTime date;

    // Many prescription belong to one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private  Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "patient_id" , nullable = false)
    private  Patient patient;
}
