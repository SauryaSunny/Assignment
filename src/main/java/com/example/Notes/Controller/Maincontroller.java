package com.example.Notes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Notes.entity.Model;
import com.example.Notes.entity.Model_service;

@RestController
@RequestMapping("/Notes")
public class Maincontroller {
	
	@Autowired
	Model_service Service;
	
	//view existing notes
	
	@GetMapping("/view")
	public List<Model> ViewNotes()
	{
		return Service.viewstoreddata();
	}
	
	//search notes by id
	
	@GetMapping("/viewbyid/{id}")
	public Model SearchNotes(@PathVariable int id)
	{
		return Service.searchbyid(id);
	}
	//search by words
	@GetMapping("/viewbywords/{word}")
	public Model SearchNotes(@PathVariable String word)
	{
		return Service.searchbywords(word);
	}
	
	//add or create new notes
	
	@PostMapping("/add")
	public List<Model> AddNotes(@RequestBody List<Model> D)
	{
		System.out.println("Notes Created !");
		return Service.addnewnote(D);	  
	}
	
	//update notes
	
	@PutMapping("/update/{id}")
	public Model UpdateNotes(@PathVariable int id,@RequestBody String content)
	{
		System.out.println("Notes Updated !");
		return Service.updatecontent(id,content);	
	}
	
	//delete a note
	@DeleteMapping("/delete/{id}")
	public String DeleteNotes(@PathVariable int id)
	{
		Service.deletenotes(id);
		return "Notes Deleted!"; 
	}
}
