package com.raaghavi.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raaghavi.pma.entities.Employee;
import com.raaghavi.pma.entities.Project;
import com.raaghavi.pma.services.EmployeeService;
import com.raaghavi.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proService;
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("")
	public String displayProjects(Model model) {
		List<Project> projects=proService.getAll();
		model.addAttribute("projects",projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project projectObj=new Project();
		List<Employee> employees=empService.getAll();
		model.addAttribute("project",projectObj);
		model.addAttribute("allEmployees",employees);
		return "projects/new-project";
	}
	
	 @PostMapping("/save") 
	 public String createProject(Project project,@RequestParam List<Long> employees, Model model) {
		 proService.save(project);
				 //use a redirect to prevent duplicate submission
		 return "redirect:/projects/new";
	 }
	 

}
