package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Patient;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/api/patients")

@Validated
public class PatientController {

	@Autowired
	private IPatientService patientService;

	public PatientController() {
		System.out.println("in ctor of " + getClass());
		System.out.println("Started");
	}

	@GetMapping
	public ResponseEntity<?> listAllPatients() {
		System.out.println("in list patients");
		List<Patient> list = patientService.getAllPatientDetails();

		if (list.isEmpty())
			return new ResponseEntity<>("Empty Patient List !!!!", HttpStatus.OK);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Patient> savePatientDetails(@RequestBody @Valid Patient patient)

	{
		System.out.println("in save patient " + patient);
		return new ResponseEntity<>(patientService.savePatientDetails(patient), HttpStatus.CREATED);
	}

	@DeleteMapping("/{patientId}")

	public String deletePatientDetails(@PathVariable int patientId) {
		System.out.println("in del patient " + patientId);
		return patientService.deletePatientDetails(patientId);
	}

	@GetMapping("/{id}")
	// @PathVariable => a binding between a path var to method arg.
	public ResponseEntity<?> getPatientDetails(@PathVariable int id) {
		System.out.println("in get patient " + id);

		try {
			return ResponseEntity.ok(patientService.getPatientDetails(id));
		} catch (RuntimeException e) {
			System.out.println("err in get patient dtls " + e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping("/{patientId}")
	public Patient updatePatientInfoDetails(@PathVariable int patientId, @RequestBody Patient patient) {
		System.out.println("in update patient " + patient);
		return patientService.updatePatientDetails(patientId, patient);
	}
}
