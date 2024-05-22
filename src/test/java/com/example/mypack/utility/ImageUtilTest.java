package com.example.mypack.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ImageUtilTest {

	@InjectMocks
	private ImageUtil imageUtil;

	@SuppressWarnings("static-access")
	@Test
	public void decompressImageTest() {
		Integer expectedLength = 0;
		byte[] inputData = new byte[] { 1, 2, 3 };
		byte[] actualOutput = imageUtil.decompressImage(inputData);
		assertEquals(expectedLength, actualOutput.length);

	}

	@SuppressWarnings("static-access")
	@Test
	public void compressImageTest() {
		int expectedLength = 12;
		byte[] inputData = { 1, 23, 113, 34 };
		byte[] actualOutput = imageUtil.compressImage(inputData);
		assertEquals(expectedLength, actualOutput.length);

	}

}
