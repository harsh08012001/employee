package com.example.employee.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmpRepo;

import java.util.Optional;



@Service
public class EmpService {

	 @Autowired
	private EmpRepo repo;
	 
	public void addEmp(Employee e)
	{
		repo.save(e);
		
	}
	
    public Employee getById(int id)
    {
    	Optional<Employee> e = repo.findById(id);
		
    	return e.get();
		
    }

	public ArrayList<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return (ArrayList<Employee>) repo.findAll();
	}
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
	}
}
