package com.hr_portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr_portal.entity.Employee;
import com.hr_portal.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	// to save data in database
	public void addEmp(Employee e) {
	    empRepository.save(e)	;
	}
	
	// get all employee
	public List<Employee> getAllEmp(){
		return empRepository.findAll();
	}
	
	// get employee by id
	public Employee getEmpById(long id)
	{
		Optional<Employee> e =  empRepository.findById(id);
		if (e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	// delete an employee
	public void deletById(long id) {
		empRepository.deleteById(id);
	}
}
