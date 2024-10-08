package com.hospitalaccounting.patientservice.patient.entity;


import com.hospitalaccounting.patientservice.common.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PATIENT")
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SURNAME")
    private String surname;

    @Column(name="AGE")
    private int age;

    @Column(name="IDENTITY_NUM")
    private String identityNum;

    @Column(name="GENDER")
    private String gender;

    @Column(name="PHONE_NUM")
    private String phoneNum;

    @Column(name="ADDRESS")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;


}
