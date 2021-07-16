package com.leansolutions.api.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "cell_phone")
	private String cellPhone;

	@Column(name = "city_name")
	private String cityName;

	public Person() {

	}

	public Person(String name, String lastName, String address, String cellPhone, String cityName) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.cellPhone = cellPhone;
		this.cityName = cityName;
	}

	public long getId() {return id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String getCellPhone() {return cellPhone;}
	public void setCellPhone(String cellPhone) {this.cellPhone = cellPhone;}

	public String getCityName() {return cityName;}
	public void setCityName(String cityName) {this.cityName = cityName;}

	@Override
	public int hashCode() {
		return Objects.hash(address, cellPhone, cityName, id, lastName, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(cellPhone, other.cellPhone)
				&& Objects.equals(cityName, other.cityName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address=" + address
				+ ", cellPhone=" + cellPhone + ", cityName=" + cityName + "]";
	}
	
}
