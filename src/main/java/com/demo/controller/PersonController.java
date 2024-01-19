package com.demo.controller;

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

import com.demo.model.Person;
import com.demo.service.PersonService;

@RestController
@RequestMapping("/")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping
	public List<Person> getData(){
		return service.getData();
	}
	
	@GetMapping("{id}")
	public Person getDataByID(@PathVariable int id) {
		return service.getdataById(id);
	}
	
	
	@PostMapping
	public void setData(@RequestBody Person p) {
		service.setData(p);
	}
	
	@DeleteMapping("{id}")
	public void deleteData(@PathVariable int id) {
		service.deleteData(id);
	}
	
	@PutMapping
	public void updateData(@RequestBody Person p) {
		service.updateData(p);
	}
	
	
	

}
