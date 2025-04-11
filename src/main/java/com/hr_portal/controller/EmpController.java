package com.hr_portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hr_portal.entity.Employee;
import com.hr_portal.service.EmpService;


import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;

	@GetMapping("/hr_portal")
	public String home(Model m) {
		
		List<Employee> emp = empService.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "hr_portal";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm ()
	{
		return "add_emp";
	}
	
	// ADD AN EMPLOYEE
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session)
	{
	    System.out.println(e);
	    empService.addEmp(e);
	    session.setAttribute("msg", "Employee Added Successfully!");
		return "redirect:/hr_portal";
	}
	
	// GET AN EMPLOYEE DATA
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable long id, Model m) {
		
		Employee e = empService.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	// UPDATE AN EMPLOYEE DATA
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		empService.addEmp(e);
		session.setAttribute("msg", "Employee Data edited Successfully!");
		return "redirect:/hr_portal";
	}
	
	// DELETE AN EMPLOYEE DATA
	@GetMapping("/delete/{id}")
	public String deleteByEmp(@PathVariable long id, HttpSession session) {
		
		empService.deletById(id);
		session.setAttribute("msg", "Employee Data deleted Successfully!");
		return "redirect:/hr_portal";
	}
}
