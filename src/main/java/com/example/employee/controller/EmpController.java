package com.example.employee.controller;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.employee.model.Dept;
import com.example.employee.model.Employee;
import com.example.employee.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		ArrayList<Employee> list = service.getAllEmp();
		m.addAttribute("emp",list);//emp is the by which the index page refer the list object
		return "index";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e = service.getById(id);
		m.addAttribute("emp",e);
		return "edit";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		
		
		service.deleteEmp(id);
		return "redirect:/";
		
	}
	
	@GetMapping("/add_emp")
	public String add_Emp()
	{
		return "add_emp";
		
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e)
	{
		service.addEmp(e);
		return "redirect:/";
	}
	
	
	@PostMapping("/register")
	public String addEmp(@ModelAttribute Employee e)
	{	
		service.addEmp(e);
		
		return "redirect:/";
	}
	
	@ModelAttribute("departments")
	public ArrayList<Dept> getDepartments()
	{
		ArrayList<Dept> list =new ArrayList<Dept>();
		list.add(new Dept("Sales"));
		list.add(new Dept("HR"));
		list.add(new Dept("Development"));
		list.add(new Dept("Marketing"));
		return list;
		
		
		
	}

}
