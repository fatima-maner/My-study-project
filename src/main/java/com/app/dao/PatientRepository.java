package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
