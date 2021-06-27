package com.raaghavi.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.raaghavi.pma.dto.EmployeeProject;
import com.raaghavi.pma.entities.Employee;

@RepositoryRestResource(collectionResourceRel="apiemployees",path="apiemployees")
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	

	@Query(nativeQuery=true, value="select  e.first_name as firstName, e.last_name as lastName,COUNT(pe.employee_id) as projectCount "+
			"from employee e left join project_employee pe ON pe.employee_id=e.employee_id "+ 
			"GROUP BY e.first_name,e.last_name ORDER BY 3 DESC")
	public List<EmployeeProject> employeeProjects();

	public Employee findByEmail(String value);
	
	@Override
	public List<Employee> findAll();

	public Employee findByEmployeeId(long id);
}
