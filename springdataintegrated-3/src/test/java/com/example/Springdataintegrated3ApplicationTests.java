package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.StudentDTO;
import com.example.entity.Assessment;
import com.example.entity.Student;
import com.example.exception.AssessmentException;
import com.example.repository.AssessmentRepository;
import com.example.repository.StudentRepository;
import com.example.service.StudentServiceImpl;

@SpringBootTest
class Springdataintegrated3ApplicationTests {

	@Mock
	private StudentRepository  studentRepository;

	@Mock
	private AssessmentRepository assessmentRepository;
	@InjectMocks
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	@Test
	void addStudentInvalidAssessmentTest() {
		int assessmentId = 111;
		Optional optional = Optional.empty();
		StudentDTO studentDTO = new StudentDTO();
		
		Mockito.when(assessmentRepository.findById(assessmentId)).thenReturn(optional);
		AssessmentException exception = Assertions.assertThrows(AssessmentException.class,
				() ->studentServiceImpl.addStudent(studentDTO, assessmentId));
		Assertions.assertEquals("Service.ASSESSMENT_NOT_FOUND", exception.getMessage());
	}

	@Test
	void addStudentInvalidAssessmentMarksTest() {
		int assessmentId = 111;
		
	    Assessment assessment=new Assessment();
		assessment.setAssessmentId(assessmentId);
		assessment.setAssessmentName("CSS3");
		assessment.setMaxMarks(100);
		assessment.setPassingMarks(60);
		
		
		
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setStudentId(1);
		studentDTO.setName("Roger");
		studentDTO.setDateOfBirth(LocalDate.of(1990,12,12));
		studentDTO.setMarksScored(-90);
		Optional optional = Optional.of(assessment);
		
		
		
		
		
		Mockito.when(assessmentRepository.findById(assessmentId)).thenReturn(optional);
		AssessmentException exception = Assertions.assertThrows(AssessmentException.class,
				() ->studentServiceImpl.addStudent(studentDTO, assessmentId));
		Assertions.assertEquals("Service.INVALID_MARKS", exception.getMessage());
	}
	
	@Test
	void addStudentInvalidAssessmentMarksTest2() {
		int assessmentId = 111;
		
	    Assessment assessment=new Assessment();
		assessment.setAssessmentId(assessmentId);
		assessment.setAssessmentName("CSS3");
		assessment.setMaxMarks(100);
		assessment.setPassingMarks(60);
		
		
		
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setStudentId(1);
		studentDTO.setName("Roger");
		studentDTO.setDateOfBirth(LocalDate.of(1990,12,12));
		studentDTO.setMarksScored(2000);
		Optional optional = Optional.of(assessment);
		
		
		
		
		
		Mockito.when(assessmentRepository.findById(assessmentId)).thenReturn(optional);
		AssessmentException exception = Assertions.assertThrows(AssessmentException.class,
				() ->studentServiceImpl.addStudent(studentDTO, assessmentId));
		Assertions.assertEquals("Service.INVALID_MARKS", exception.getMessage());
	}
	
	@Test
	void getVoterInvalidVoterTest() {
		int studentId = 0;
		Optional optional = Optional.empty();
		Mockito.when(studentRepository.findById(studentId)).thenReturn(optional);
		AssessmentException exception = Assertions.assertThrows(AssessmentException.class,
				() ->studentServiceImpl.getStudent(studentId));
		Assertions.assertEquals("Service.STUDENT_NOT_FOUND", exception.getMessage());
	}
	
	@Test
	void findAllInvalidTest() {
		Iterable<Student>studentList=new ArrayList<>();
		Mockito.when(studentRepository.findAll()).thenReturn(studentList);
		AssessmentException exception = Assertions.assertThrows(AssessmentException.class,
				() -> studentServiceImpl.findAll());
		Assertions.assertEquals("Service.STUDENTS_NOT_FOUND", exception.getMessage());
	}

	@Test
	void deleteVoterInvalidTest() {
		int studentId = 0;
		Optional optional = Optional.empty();
		Mockito.when(studentRepository.findById(studentId)).thenReturn(optional);
		AssessmentException exception = Assertions.assertThrows(AssessmentException.class,
				() -> studentServiceImpl.deleteStudent(studentId));
		Assertions.assertEquals("Service.STUDENT_NOT_FOUND", exception.getMessage());
	}

}
