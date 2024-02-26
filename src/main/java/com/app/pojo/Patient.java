package com.app.pojo;
import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
	@NotBlank
    private String fullname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private int age;
    @Pattern(regexp = "\\d{10}")
    private String phoneNo;
    private Gender gender;
    @Embedded
    private Address address;
    @NotBlank
    private String disease;
    private String history;
}
