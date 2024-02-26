package com.app.dto;

import com.app.pojo.Address;
import com.app.pojo.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Patient {
    private String name;
    private Gender gender;
    private Address address;
}