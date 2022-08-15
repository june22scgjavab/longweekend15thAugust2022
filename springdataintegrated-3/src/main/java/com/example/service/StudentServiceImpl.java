package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.AssessmentDTO;
import com.example.dto.StudentDTO;
import com.example.entity.Assessment;
import com.example.entity.Student;
import com.example.exception.AssessmentException;
import com.example.repository.AssessmentRepository;
import com.example.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AssessmentRepository assessmentRepository;

	@Override
	public List<StudentDTO> findAll() throws AssessmentException {
		List<StudentDTO> studentDTOList = new ArrayList<>();
		Iterable<Student> studentList = studentRepository.findAll();
		studentList.forEach(student -> {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setStudentId(student.getStudentId());
			studentDTO.setName(student.getName());
			studentDTO.setMarksScored(student.getMarksScored());
			studentDTO.setDateOfBirth(student.getDateOfBirth());
			Assessment assessment = student.getAssessment();
			AssessmentDTO assessmentDTO = new AssessmentDTO();
			assessmentDTO.setAssessmentId(assessment.getAssessmentId());
			assessmentDTO.setAssessmentName(assessment.getAssessmentName());
			assessmentDTO.setMaxMarks(assessment.getMaxMarks());
			assessmentDTO.setPassingMarks(assessment.getPassingMarks());
			studentDTO.setAssessmentDTO(assessmentDTO);
			studentDTOList.add(studentDTO);

		});
		if (studentDTOList.isEmpty()) {
			throw new AssessmentException("Service.STUDENTS_NOT_FOUND");
		}

		return studentDTOList;
	}

	@Override
	public void addStudent(StudentDTO studentDTO, Integer assessmentId) throws AssessmentException {

		Optional<Assessment> assessmentOptional = assessmentRepository.findById(assessmentId);
		Assessment assessment = assessmentOptional
				.orElseThrow(() -> new AssessmentException("Service.ASSESSMENT_NOT_FOUND"));
		if (studentDTO.getMarksScored() < 0 || studentDTO.getMarksScored() > 100) {
			throw new AssessmentException("Service.INVALID_MARKS");
		}
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setDateOfBirth(studentDTO.getDateOfBirth());
		student.setMarksScored(studentDTO.getMarksScored());
		student.setAssessment(assessment);
		studentRepository.save(student);

	}

	@Override
	public StudentDTO getStudent(Integer studentId) throws AssessmentException {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		Student student = studentOptional.orElseThrow(() -> new AssessmentException("Service.STUDENT_NOT_FOUND"));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(student.getStudentId());
		studentDTO.setName(student.getName());
		studentDTO.setDateOfBirth(student.getDateOfBirth());
		studentDTO.setMarksScored(student.getMarksScored());
		AssessmentDTO assessmentDTO = new AssessmentDTO();
		Assessment assessment = student.getAssessment();
		assessmentDTO.setAssessmentId(assessment.getAssessmentId());
		assessmentDTO.setAssessmentName(assessment.getAssessmentName());
		assessmentDTO.setMaxMarks(assessment.getMaxMarks());
		assessmentDTO.setPassingMarks(assessment.getPassingMarks());
		studentDTO.setAssessmentDTO(assessmentDTO);
		return studentDTO;
	}

	@Override
	public void deleteStudent(Integer studentId) throws AssessmentException {
		Optional<Student> studentOptional = studentRepository.findById(studentId);
		Student student = studentOptional.orElseThrow(() -> new AssessmentException("Service.STUDENT_NOT_FOUND"));
		student.setAssessment(null);
		studentRepository.deleteById(studentId);

	}

}
