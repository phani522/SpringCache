package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.dao.PersonDao;
import com.demo.model.Person;

@Service
public class PersonService {
	
	@Autowired
	PersonDao dao;
	
	
	public List<Person> getData() {
		return dao.findAll();
	}
	
	public void setData(Person p) {
		dao.save(p);
	}
	
	@CacheEvict(cacheNames = "persons", key="#id")
	public void deleteData(int id) {
		System.out.println("DB hit");
		dao.deleteById(id);
	}
	
	@CachePut(cacheNames = "persons", key="#p.id")
	public void updateData(Person p) {
		System.out.println("DB hit");
		dao.save(p);
	}
	

	@Cacheable(cacheNames = "persons", key = "#id")
	public Person getdataById(int id) {
		// TODO Auto-generated method stub
		System.out.println("DB hit");
		
		Person p=  dao.findById(id).get();
		return p;
	}

}
