package com.raaghavi.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raaghavi.pma.entities.Employee;
import com.raaghavi.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@GetMapping("")
	public String displayEmployees(Model model) {
		List<Employee> employees=empService.getAll();
		model.addAttribute("employees",employees);
		return "employees/list-employees";
	}

	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employee",emp);
		return "employees/new-employee";
	}
	@PostMapping("/save")
	public String createEmployee(Model model,@Valid Employee emp,Errors errors) {
		if(errors.hasErrors())
		{
			return "employees/new-employee";
		}
		
		empService.save(emp);
		return "redirect:/employees";
	}
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
		Employee emp=empService.findByEmployeeId(id);
		model.addAttribute("employee",emp);
		return "employees/new-employee";
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") long id,Model model) {
		Employee emp=empService.findByEmployeeId(id);
		empService.delete(emp);
		return "redirect:/employees";
	}
	
}
