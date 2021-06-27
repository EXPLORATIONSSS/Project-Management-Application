package com.raaghavi.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raaghavi.pma.dao.EmployeeRepository;
import com.raaghavi.pma.dto.EmployeeProject;
import com.raaghavi.pma.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}

	public Employee findByEmployeeId(long id) {
		// TODO Auto-generated method stub
		return empRepo.findByEmployeeId(id);
	}

	public void delete(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.delete(emp);
	}

}
