package com.leansolutions.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leansolutions.api.model.Employee;
import com.leansolutions.api.model.Position;
import com.leansolutions.api.repository.PositionRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/position")
public class PositionController {

	private PositionRepository positionRepository;

	@Autowired
	public PositionController(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Position>> findAll() {
		List<Position> positions;
		try {
			positions = new ArrayList<Position>();
			positions = positionRepository.findAll();

			if (positions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(positions, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findbypositionorname")
	public ResponseEntity<List<Position>> findByPositionOrName(@RequestParam(required = false) String name, @RequestParam(required = false) String employee) {
		List<Position> positions = null;
		try {
			
			positions = new ArrayList<Position>();
			
			if (name == null & employee == null ) {
				positions = positionRepository.findAll();
			}else if (name != null) {
				positions = positionRepository.findByName(name);
			}
			else {
				positions = positionRepository.findByEmployeesPersonName(employee);
				
				positions.forEach(p -> {
					List<Employee> employees = 
							p.getEmployees().stream()
							.filter( e -> e.getPerson().getName().equals(employee))
							.collect(Collectors.toList());
					p.setEmployees(employees);
				});
			}

			if (positions.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(positions, HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
