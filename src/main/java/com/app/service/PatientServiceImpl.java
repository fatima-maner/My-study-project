package com.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.PatientRepository;
import com.app.pojo.Patient;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	public static int addNumber(int a,int b)
	{
		return a+b;
	}
	@Autowired
	private PatientRepository patientRepo;

	@Override
	@Cacheable("patients")
	public List<Patient> getAllPatientDetails() {

		return patientRepo.findAll();

	}

	@Override
	@Cacheable(value = "patients", key = "#pId")
	public Patient getPatientDetails(int pId) {

		return patientRepo.findById((long) pId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid patient id !!!!!!" + pId));
	}

	@Override
	@CacheEvict(value = "patients", allEntries = true)
	public Patient savePatientDetails(Patient temppatient) {

		return patientRepo.save(temppatient);
	}

	@Override
	@CacheEvict(value = "patients", key = "#patientId")
	public String deletePatientDetails(int patientId) {
		String mesg = "Deletion of patient details failed!!!!!!!!!!!";

		if (patientRepo.existsById((long) patientId)) {
			patientRepo.deleteById((long) patientId);
			mesg = "patients details deleted successfully , for patient id :" + patientId;
		}

		return mesg;
	}

	@Override
	@CacheEvict(value = "patients", allEntries = true)
	public Patient updatePatientDetails(int patientId, Patient updatedInfo) {
		if (patientRepo.existsById((long) patientId)) {
			patientRepo.save(updatedInfo);

		}

		return updatedInfo;
	}
}
