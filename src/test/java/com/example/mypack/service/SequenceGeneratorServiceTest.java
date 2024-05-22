package com.example.mypack.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.example.mypack.model.DatabaseSequence;

@ExtendWith(MockitoExtension.class)
public class SequenceGeneratorServiceTest {

	@InjectMocks
	private SequenceGeneratorService generatorService;

	@Mock
	private MongoOperations mongoOperations;

	@Test
	public void generateSequenceTest() {
		DatabaseSequence databaseSequence = new DatabaseSequence();
		databaseSequence.setId("user_sequence");
		databaseSequence.setSeq(4l);
		Mockito.when(mongoOperations.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class),
				any())).thenReturn(databaseSequence);
		assertEquals(4l, generatorService.generateSequence("user_sequence"));
	}
}
