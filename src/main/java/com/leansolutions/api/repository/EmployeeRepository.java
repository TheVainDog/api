package com.leansolutions.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leansolutions.api.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
