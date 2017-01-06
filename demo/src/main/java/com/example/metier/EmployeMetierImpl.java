package com.example.metier;

import java.util.List;

import com.example.dao.EmployeRepository;
import com.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class EmployeMetierImpl implements EmployeMetier{
	@Autowired
	private EmployeRepository employerepository;

	@Override
	public Employee saveemploye( Employee e) {
		// TODO Auto-generated method stub
		return employerepository.save(e);
	}

	@Override
	public List<Employee> listemploye() {
		// TODO Auto-generated method stub
		return employerepository.findAll();
	}

}
