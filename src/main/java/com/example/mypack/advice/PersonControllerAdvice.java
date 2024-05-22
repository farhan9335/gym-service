package com.example.mypack.advice;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.mypack.exception.ObjectNotFoundException;

@RestControllerAdvice
public class PersonControllerAdvice {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors().stream().forEach(exp -> {
			errorMap.put(exp.getField(), exp.getDefaultMessage());
		});
		return errorMap;
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> handleObjectFoundException(ObjectNotFoundException exception) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", exception.getMessage());
		return errorMap;
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exp) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", "Provide json not in correct format");
		return errorMap;
	}
}
