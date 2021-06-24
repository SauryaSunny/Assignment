package com.example.Notes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Notes.entity.Model;  

public interface ModelRepo extends JpaRepository<Model, Integer>  
{

}  

