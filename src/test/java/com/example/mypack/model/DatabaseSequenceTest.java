package com.example.mypack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DatabaseSequenceTest {

	@InjectMocks
	private DatabaseSequence databaseSequence;
	
	@Test
	public void IdTest() {
		databaseSequence.setId("user_sequence");
		assertEquals("user_sequence", databaseSequence.getId());
	}
	
	@Test
	public void seqTest() {
		databaseSequence.setSeq(5l);
		assertEquals(5l, databaseSequence.getSeq());
	}
}
