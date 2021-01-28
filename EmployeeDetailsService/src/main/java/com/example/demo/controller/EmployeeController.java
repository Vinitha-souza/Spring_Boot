package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@PostMapping("/Employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			employee = empService.saveEmployee(employee);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.EXPECTATION_FAILED);
		}
		System.out.println("added employees are" + employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/Employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		try {
			Optional<Employee> empOptional = empService.findsingleEmployee(id);
			if (!empOptional.isPresent())
				return ResponseEntity.notFound().build();
			employee.setId(id);
			//employee.setAddress(empOptional.get().getAddress());     ///set address
			employee=empService.saveEmployee(employee);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.EXPECTATION_FAILED);
		}
		System.out.println("updated employees are" + employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/Employees")
	public ResponseEntity<Object> getEmployeeDetails(Employee employee) {
		List<Employee> emp;
		try {

			emp = empService.findAllEmployees();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED);
		}
		System.out.println("All  Employees-->" + emp);
		return new ResponseEntity<Object>(emp, HttpStatus.OK);

	}

	@GetMapping("/Employees/{id}")
	public ResponseEntity<Object> geteachemployee(@PathVariable("id") Integer id, Employee employee) {
		Optional<Employee> emp;
		try {
			emp = empService.findsingleEmployee(id);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED);
		}
		System.out.println("Each empEmployees-->" + emp);
		return new ResponseEntity<Object>(emp, HttpStatus.OK);

	}

	@DeleteMapping("/Employees/{id}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable("id") Integer id, Employee employee) {
		try {
			empService.deleteEmployee(employee);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.EXPECTATION_FAILED);
		}

		return new ResponseEntity<Employee>(HttpStatus.OK);

	}

}
