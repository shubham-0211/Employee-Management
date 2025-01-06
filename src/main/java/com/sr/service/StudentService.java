package com.sr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.StudentDao;
import com.sr.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	
	public Student saveStudent(Student std)throws Exception {
		return dao.save(std);
	}

	public Iterable<Student> getAllStudents()throws Exception{
		if(dao==null)
			return null;
		return dao.findAll();
	}
	
	public int deleteStudent(int sno) {

		try {
		dao.deleteById(sno);
		}
		catch (Exception e) {
			return 0;
		}
			return 1;
	}
	
	public Student getStudentById(int sno) {
		return dao.findById(sno).get();
	}
	
}
