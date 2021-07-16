package com.leansolutions.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leansolutions.api.model.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {
		
	List<Position> findByName(String name);
	
	List<Position> findByEmployeesPersonName(String name);
		
}
