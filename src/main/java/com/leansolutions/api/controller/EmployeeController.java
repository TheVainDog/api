package com.leansolutions.api.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leansolutions.api.model.Employee;
import com.leansolutions.api.model.Position;
import com.leansolutions.api.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> findAll() {
		
		List<Employee> employees = null;
		
		try {
			employees = employeeRepository.findAll();
			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Employee> findById(@PathVariable("id") long id) {
		try {
			Optional<Employee> employeeData = employeeRepository.findById(id);
			if (employeeData.isPresent()) {
				Employee _employee = employeeData.get();
				_employee.setSalary(_employee.getSalary());
				_employee.setPerson(_employee.getPerson());
				return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<List<Employee>> save(@RequestBody Position position) {
		try {
			List<Employee> _employees = position.getEmployees();
			_employees.forEach(_employee -> {
				employeeRepository.save(new Employee(_employee.getSalary(), position.getId(), _employee.getPerson()));
			});
			
			return new ResponseEntity<>(_employees, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateTutorial(@PathVariable("id") long id, @RequestBody Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			Employee _employee = employeeData.get();
			_employee.setSalary(employee.getSalary());
			_employee.setPerson(employee.getPerson());
			return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") long id) {
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
