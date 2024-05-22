package com.example.mypack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImageDataTest {

	@InjectMocks
	private ImageData imageData;

	@Test
	public void nameTest() {
		imageData.setName("Farhan.jpg");
		assertEquals("Farhan.jpg", imageData.getName());
	}

	@Test
	public void typeTest() {
		imageData.setType("text/html");
		assertEquals("text/html", imageData.getType());
	}

	@Test
	public void imageDataTest() {
		byte[] imageDataArray = { 1, 2, 33, 122, 111 };
		imageData.setImageData(imageDataArray);
		assertEquals(imageDataArray, imageData.getImageData());
	}
}
