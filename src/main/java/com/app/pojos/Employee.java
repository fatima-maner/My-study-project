package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="emps")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer empId;
    @NotEmpty(message="First name must be supplied")
    @Length(min=4,max=30,message=" Invalid First name length")
	@Column(length = 30)
	private String name;
	@Column(length = 30)
	private String lastName;
	@Email(message="Invalid Email")
	@Column(length = 30)
	private String email;
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	@Column(length = 30)
	private String password;
	@NotBlank(message="department is required")
	@Column(length = 30)
	private String department;
	@NotBlank(message="work location is required")
	@JsonProperty("location")
	@Column(length = 30)
	private String workLocation;
	@Range(min=10000,max=50000,message="Invalid salary")
	private double salary;
	//@Future(message="join date must be in future")
	private LocalDate joinDate;
		
}
