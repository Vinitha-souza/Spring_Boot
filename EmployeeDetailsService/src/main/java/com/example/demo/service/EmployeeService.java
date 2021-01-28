package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	public Employee saveEmployee(Employee emp)
	{
		return repo.save(emp);
	
	}
	public Optional<Employee> findsingleEmployee(int id)
	{
		return repo.findById(id);
	}
	 public List <Employee> findAllEmployees() {
	        return repo.findAll();
	    }
	
	public void deleteEmployee(Employee emp)
	{
		repo.delete(emp);
	}
	
}
