package com.example.mypack.advice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.mypack.exception.ObjectNotFoundException;

@ExtendWith(MockitoExtension.class)
public class PersonControllerAdviceTest {

	@InjectMocks
	private PersonControllerAdvice personControllerAdvice;

	@Test
	public void handleMethodArgumentNotValidExceptionTest() {
		MethodArgumentNotValidException exp = mock(MethodArgumentNotValidException.class);
		BindingResult bindingResult = mock(BindingResult.class);
		FieldError error1 = new FieldError("ob1", "field1", "Error Message 1");
		FieldError error2 = new FieldError("ob2", "field2", "Error Message 2");
		Mockito.when(bindingResult.getFieldErrors()).thenReturn(Arrays.asList(error1, error2));
		Mockito.when(exp.getBindingResult()).thenReturn(bindingResult);
		Map<String, String> errorMap = personControllerAdvice.handleMethodArgumentNotValidException(exp);
		assertEquals(2, errorMap.size());
		assertEquals("Error Message 1", errorMap.get("field1"));
		assertEquals("Error Message 2", errorMap.get("field2"));
	}

	@Test
	public void handleObjectFoundExceptionTest() {
		ObjectNotFoundException exp = new ObjectNotFoundException("Object Not Found for given Id : FF-127");
		Map<String, String> errorMap = personControllerAdvice.handleObjectFoundException(exp);
		assertEquals("Object Not Found for given Id : FF-127", errorMap.get("error"));

	}

	@Test
	public void handleHttpMessageNotReadableExceptionTest() {
		HttpMessageNotReadableException exp = mock(HttpMessageNotReadableException.class);
		Map<String, String> errorMap = personControllerAdvice.handleHttpMessageNotReadableException(exp);
		assertEquals("Provide json not in correct format", errorMap.get("error"));

	}
}
