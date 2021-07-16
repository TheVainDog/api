package com.leansolutions.api.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "Position")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "position", referencedColumnName = "id")
	@OrderBy(value = "salary DESC")
	private List<Employee> employees;
	
	public Position () {
		
	}
	
	public Position(long id, String name, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.employees = employees;
	}

	public long getId() {return id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public List<Employee> getEmployees() {return employees;}
	public void setEmployees(List<Employee> employees) {this.employees = employees;}

	@Override
	public int hashCode() {
		return Objects.hash(employees, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return Objects.equals(employees, other.employees) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}

}
