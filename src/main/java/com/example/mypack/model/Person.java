package com.example.mypack.model;

import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.mypack.utility.MobileNumber;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "person")
public class Person {

	@Id
	private String personId;
	@NotBlank(message = "firstName Should not be blank")
	private String firstName;
	@NotBlank(message = "lastName Should not be blank")
	private String lastName;
	@NotBlank(message = "email Should not be blank")
	@Email(message = "email should be in proper format")
	private String email;
	@NotBlank(message = "mobile Should not be blank")
	@MobileNumber
	private String mobile;
	@NotNull(message = "Weight must not be null")
	@DecimalMin(value = "0.1", message = "Weight Value must be greater than zero")
	private Double weight;
	@NotNull(message = "Height must not be null")
	@DecimalMin(value = "0.1", message = "Height Value must be greater than zero")
	private Double height;
	@NotNull(message = "BMI must not be null")
	private Double bmi;
	@NotBlank(message = "bmiResult Should not be blank")
	private String bmiResult;
	@NotBlank(message = "gender Should not be blank")
	@Pattern(regexp = "^(Male|Female)$", message = "Value must be 'Male' or 'Female'")
	private String gender;
	@NotBlank(message = "isTrainerRequire Should not be blank")
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be 'Yes' or 'No'")
	private String isTrainerRequire;
	@NotBlank(message = "trainingPackage Should not be blank")
	@Pattern(regexp = "^(Monthly|Quaterly|Yearly)$", message = "Value must be 'Monthly','Quaterly' or 'Yearly'")
	private String trainingPackage;
	@NotEmpty(message = "motivations Should not be empty")
	private Set<@NotBlank(message = "motivation Should not be blank or null") String> motivations;
	@NotBlank(message = "hasBeenToGym Should not be blank")
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be 'Yes' or 'No'")
	private String hasBeenToGym;
	@NotBlank(message = "enquiryDate Should not be blank")
	private String enquiryDate;
	@NotNull(message = "Age should not be null")
	@Min(value = 18, message = "Age must be greater than or equal to 18")
	private Integer age;
	private ImageData imageData;
	@NotBlank(message = "referFrom should not be blank")
	private String referFrom;
}
