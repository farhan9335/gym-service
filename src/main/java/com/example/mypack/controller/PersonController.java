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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "GYM", description = "GYM Management API")
@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Operation(summary = "Receive Person Object and Multipart File as headers", description = "Persist person inforamtion in DB with Image", tags = {
			"person", "post" })
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Person.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping(path = "/person", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Person> addPerson(@Valid @RequestPart Person person,
			@RequestPart("file") MultipartFile file) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(person, file));
	}

	@Operation(summary = "Not receive any parameters", description = "Get All Person object which is available in DB", tags = {
			"person", "get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Person.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson() {
		return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPerson());
	}

	@Operation(summary = "Receive personId in argument", description = "Return person object as response if personId is available in DB", tags = {
			"person", "get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Person.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/person/{personId}")
	public ResponseEntity<Person> getPersonById(@PathVariable String personId) {
		return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(personId));
	}

	@Operation(summary = "Receive perosn object as a agrgument", description = "Delete person object from DB", tags = {
			"person", "delete" })
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Person deleted successfully"),

	})
	@DeleteMapping("/person")
	public ResponseEntity<Void> deletePerson(@RequestBody Person person) {
		personService.deletePerson(person);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Receive personId as argument", description = "Delete person from the DB if and only if personId available in DB", tags = {
			"person", "delete" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Person deleted successfully") })
	@DeleteMapping("/person/{personId}")
	public ResponseEntity<Void> deletePersonById(@PathVariable String personId) {
		personService.deletePersonById(personId);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Receive person object", description = "Update person object", tags = { "person", "put" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Person.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping("/person")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		return ResponseEntity.status(HttpStatus.OK).body(personService.updatePerson(person));
	}

	@Operation(summary = "Receive person object and MutltipartFile", description = "Updated person object with updated image", tags = {
			"person", "put" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Person.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping(path = "/person", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Person> updatePerson(@Valid @RequestPart Person person,
			@RequestPart("file") MultipartFile file) {
		return ResponseEntity.status(HttpStatus.OK).body(personService.update(person, file));
	}
}
