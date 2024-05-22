package com.example.mypack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.mypack.model.Person;
import com.example.mypack.service.PersonService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class PersonController {

	@Autowired
	private PersonService personService;


	@PostMapping(path = "/person",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Person> addPerson(@Valid @RequestPart Person person,@RequestPart("file") MultipartFile file ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(person,file));
	}

	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson() {
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPerson());
	}

	@GetMapping("/person/{personId}")
	public ResponseEntity<Person> getPersonById(@PathVariable String personId) {
		return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(personId));
	}

	@DeleteMapping("/person")
	public ResponseEntity<Void> deletePerson(@RequestBody Person person) {
		personService.deletePerson(person);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/person/{personId}")
	public ResponseEntity<Void> deletePersonById(@PathVariable String personId) {
		personService.deletePersonById(personId);
		return ResponseEntity.ok().build();
	}
	

	@PutMapping("/person")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(person));
	}
	
	@PutMapping(path = "/person",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Person> updatePerson(@Valid @RequestPart Person person,@RequestPart("file") MultipartFile file ) {
		return ResponseEntity.status(HttpStatus.OK).body(personService.update(person,file));
	}
}
