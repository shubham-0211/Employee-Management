package com.sr.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sr.entity.Student;
import com.sr.service.StudentService;


@Controller
@RequestMapping("/emp")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/register")
	public String registerNav() {
		return "registration";
	}
	
	@GetMapping("/")
	public String welcomePage() {	
		return "index";
	}
	
	
	@PostMapping("/register")
	public String manageStudent(@ModelAttribute("std") Student std,RedirectAttributes redirectAttributes) throws Exception {
		std=service.saveStudent(std);
		redirectAttributes.addFlashAttribute("msg", "Student Registered Successfully....");
		redirectAttributes.addFlashAttribute("std", std);
		return "redirect:success";
	}
	
	@GetMapping("/edit")
	public String editStudentForm(@RequestParam("sno") int sno,Map<String,Object> map) {
		map.put("std",service.getStudentById(sno));
		return "edit";
	}
	
	@PostMapping("/edit")
	public String editStudent(@ModelAttribute("std") Student std,RedirectAttributes redirectAttributes) throws Exception {
		redirectAttributes.addFlashAttribute("msg", "Student Updated Successfully...");
		redirectAttributes.addFlashAttribute("std", service.saveStudent(std));
		return "redirect:success";
	}
	
	@GetMapping("/display")
	public String displayStuds(Map<String,Object> map)throws Exception {
		map.put("studs",service.getAllStudents()); 
		return "display_student";
	}
	
	@GetMapping("/actions")
	public String editStudent(Map<String, Object> map)throws Exception {
		map.put("studs", service.getAllStudents());
		return "actions";		
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("sno")int sno){
		service.deleteStudent(sno);
		return "forward:actions";
		//return "actions";
	}
	 
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
}
