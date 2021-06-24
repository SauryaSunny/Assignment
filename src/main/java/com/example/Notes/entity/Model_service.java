package com.example.Notes.entity;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Notes.Repository.ModelRepo;

@Service
public class Model_service {
	
	@Autowired  
	ModelRepo DatabaseRepo1;  
	
	public List<Model> viewstoreddata()
	{
		return  DatabaseRepo1.findAll();
	}
	
	//search notes by id
	public Model searchbyid(int id)
	{
		return DatabaseRepo1.findById(id).get();  
	}
	
   //add new notes
	public List<Model> addnewnote(List<Model> d) 
	{
		return DatabaseRepo1.saveAll(d); 
	}
	
	//update notes
	public Model updatecontent(int id,String content) 
	{
		Model l=DatabaseRepo1.findById(id).get();
		l.setContent(content);
		return DatabaseRepo1.save(l); 
	}
	
	//delete notes
	public void deletenotes(int id) {
		
		DatabaseRepo1.deleteById(id);  
		
	}

	public Model searchbywords(String word) {
		List<Model> list=new ArrayList<Model>();
		list= DatabaseRepo1.findAll();
		int i=0;
	    for(i=0;i<list.size();i++)
	    { 
	    	int intIndex = list.get(i).getContent().indexOf(word);
			if(intIndex == - 1)
			{
				continue;
			} 
			else 
			{
				break;
			}
		}
	    return list.get(i);
	}
	
}


