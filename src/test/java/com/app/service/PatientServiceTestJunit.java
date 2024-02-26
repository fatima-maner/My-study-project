package com.app.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PatientServiceTestJunit {
	@BeforeAll
	public static void init()
	{
		System.out.println("Hello");
	}	
     @Test
	public void addNumbers()
	{
		int result=PatientServiceImpl.addNumber(12, 12);
		int Expected=24;
		Assertions.assertEquals(Expected, result,"the fails");
		//Assertions.
	}
     @AfterEach
     public void destry()
 	{
 		System.out.println("Comppletde");
 	}
}
