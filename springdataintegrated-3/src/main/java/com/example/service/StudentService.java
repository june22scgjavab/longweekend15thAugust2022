package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.dto.StudentDTO;
import com.example.exception.AssessmentException;


public interface StudentService {

	public void addStudent(StudentDTO studentDTO,Integer assessmentId)throws AssessmentException;
	public StudentDTO getStudent(Integer studentId) throws AssessmentException;
	public List<StudentDTO> findAll() throws AssessmentException;
	public void deleteStudent(Integer voterId)throws AssessmentException;

}
