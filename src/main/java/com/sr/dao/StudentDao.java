package com.sr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sr.entity.Student;

@Repository("std")
public interface StudentDao extends JpaRepository<Student, Integer> {

}
