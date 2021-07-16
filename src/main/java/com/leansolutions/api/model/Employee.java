package com.leansolutions.api.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "salary")
	private long salary;
	
	@Column(name = "position")
	private long position;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person", referencedColumnName = "id")
	private Person person;
	
	public Employee() {
		
	}

	public Employee(long salary, long position, Person person) {
		this.salary = salary;
		this.position = position;
		this.person = person;
	}

	public long getId() {return id;}

	public long getSalary() {return salary;}
	public void setSalary(long salary) {this.salary = salary;}
	
	public long getPosition() {return position;}
	public void setPosition(long position) {this.position = position;}

	public Person getPerson() {return person;}
	public void setPerson(Person person) {this.person = person;}

	@Override
	public int hashCode() {
		return Objects.hash(id, person, position, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(person, other.person) && position == other.position
				&& salary == other.salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", position=" + position + ", person=" + person + "]";
	}
	
}
