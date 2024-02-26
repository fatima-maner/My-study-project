package com.app.service;
import java.util.List;
import com.app.pojo.Patient;
public interface IPatientService {
	List<Patient> getAllPatientDetails();
	Patient savePatientDetails(Patient patient);
	String deletePatientDetails(int patientId);
	Patient getPatientDetails(int patientId);
    Patient updatePatientDetails(int patientId,Patient updatedInfo);
	
}
