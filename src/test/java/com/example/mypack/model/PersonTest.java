package com.example.mypack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonTest {

	@InjectMocks
	private Person person;

	@Test
	public void personIdTest() {
		person.setPersonId("FF-1");
		assertEquals("FF-1", person.getPersonId());
	}

	@Test
	public void firstNameTest() {
		person.setFirstName("Farhan");
		assertEquals("Farhan", person.getFirstName());
	}

	@Test
	public void lastNameTest() {
		person.setLastName("Khan");
		assertEquals("Khan", person.getLastName());
	}

	@Test
	public void emailTest() {
		person.setEmail("abc@gmail.com");
		assertEquals("abc@gmail.com", person.getEmail());
	}

	@Test
	public void mobileTest() {
		person.setMobile("9839550950");
		assertEquals("9839550950", person.getMobile());
	}

	@Test
	public void weightTest() {
		person.setWeight(56.0);
		assertEquals(56.0, person.getWeight());
	}

	@Test
	public void heightTest() {
		person.setHeight(121d);
		assertEquals(121d, person.getHeight());
	}

	@Test
	public void bmiTest() {
		person.setBmi(0.2345612);
		assertEquals(0.2345612, person.getBmi());
	}

	@Test
	public void bmiResultTest() {
		person.setBmiResult("Normal");
		assertEquals("Normal", person.getBmiResult());
	}

	@Test
	public void genderTest() {
		person.setGender("Male");
		assertEquals("Male", person.getGender());
	}

	@Test
	public void isTrainerRequireTest() {
		person.setIsTrainerRequire("Yes");
		assertEquals("Yes", person.getIsTrainerRequire());
	}

	@Test
	public void trainingPackageTest() {
		person.setTrainingPackage("Monthly");
		assertEquals("Monthly", person.getTrainingPackage());
	}

	@Test
	public void motivationsTest() {
		Set<String> motivations = new HashSet<>();
		motivations.add("Test1");
		motivations.add("Test2");
		person.setMotivations(motivations);
		assertEquals(2, person.getMotivations().size());
	}

	@Test
	public void hasBeenToGymTest() {
		person.setHasBeenToGym("Yes");
		assertEquals("Yes", person.getHasBeenToGym());
	}

	@Test
	public void enquiryDateTest() {
		person.setEnquiryDate("2024-02-12");
		assertEquals("2024-02-12", person.getEnquiryDate());
	}

	@Test
	public void ageTest() {
		person.setAge(30);
		assertEquals(30, person.getAge());
	}

	@Test
	public void imageDataTest() {
		ImageData imageData = new ImageData();
		imageData.setImageData(new byte[] { 22, 44, 55, 111 });
		imageData.setName("Farhan.jpg");
		imageData.setType("image/jpeg");
		person.setImageData(imageData);
		assertEquals("Farhan.jpg", person.getImageData().getName());
	}

	@Test
	public void referFromTest() {
		person.setReferFrom("Advertisment");
		assertEquals("Advertisment", person.getReferFrom());
	}
}
