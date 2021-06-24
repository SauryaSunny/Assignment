package com.example.Notes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Notes.Repository.ModelRepo;
import com.example.Notes.entity.Model;
import com.example.Notes.entity.Model_service;

@RunWith(SpringRunner.class)
@SpringBootTest
class NotesApplicationTests {

	@Autowired
	private Model_service Service;
	@MockBean
	private ModelRepo DatabaseRepo1;
	@Test
	public void ViewNotesTest()
	{
		when(DatabaseRepo1.findAll()).thenReturn(Stream.of(new Model(1,"sunny","saurya"),new Model(2,"prodapt","solutions"))
				.collect(Collectors.toList()));
		assertEquals(2,Service.viewstoreddata().size());
	}
	
	@Test
	public void addTest()
	{
		List<Model> m=Arrays.asList(new Model(3,"good","morning"));
		when(DatabaseRepo1.saveAll(m)).thenReturn((m));
		assertEquals(m,Service.addnewnote(m));
	}
	
	

}
