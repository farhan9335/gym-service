package com.example.mypack.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.mypack.exception.ObjectNotFoundException;
import com.example.mypack.model.ImageData;
import com.example.mypack.model.Person;
import com.example.mypack.repository.PersonRepository;
import com.example.mypack.utility.ImageUtil;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	private static final String GYM_USER_SEQUENCE = "gym_user_sequence";

	public Person addPerson(Person person, MultipartFile file) {
		person.setPersonId("FF-" + sequenceGeneratorService.generateSequence(GYM_USER_SEQUENCE));
		addImageData(person, file);
		return personRepository.save(person);
	}
	
	public Person update(Person person, MultipartFile file) {
		addImageData(person, file);
		return personRepository.save(person);
	}

	private void addImageData(Person person, MultipartFile file) {
		try {
			ImageData imageData = new ImageData();
			imageData.setName(file.getOriginalFilename());
			imageData.setType(file.getContentType());
			imageData.setImageData(ImageUtil.compressImage(file.getBytes()));
			person.setImageData(imageData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addImageData(Person person) {
		try {
			ImageData imageData = person.getImageData();
			imageData.setImageData(ImageUtil.compressImage(person.getImageData().getImageData()));
			person.setImageData(imageData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	public Person getPersonById(String personId) {
		Optional<Person> person = personRepository.findById(personId);
		if (person.isPresent()) {
			ImageData imageData = person.get().getImageData();
			byte[] decompressImage = ImageUtil.decompressImage(imageData.getImageData());
			imageData.setImageData(decompressImage);
			person.get().setImageData(imageData);
			return person.get();
		}
		throw new ObjectNotFoundException("Object Not Found for given Id : " + personId);
	}

	public void deletePerson(Person person) {
		personRepository.delete(person);
	}

	public void deletePersonById(String personId) {
		personRepository.deleteById(personId);

	}

	public Person updatePerson(Person person) {
		addImageData(person);
		return personRepository.save(person);
	}
}
