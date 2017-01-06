package com.example.metier;

import java.util.List;

import com.example.entities.Employee;

public interface EmployeMetier {
	
	public Employee saveemploye(Employee e);
	public List<Employee> listemploye();

}
