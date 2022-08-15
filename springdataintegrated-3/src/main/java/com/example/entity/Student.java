package com.example.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	@Column(name = "student_name", length = 20, nullable = false)
	private String name;
	private LocalDate dateOfBirth;
    private Integer marksScored;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "assessment_id")
	private Assessment assessment;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Integer getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(Integer marksScored) {
		this.marksScored = marksScored;
	}
	public Assessment getAssessment() {
		return assessment;
	}
	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
	@Override
	public int hashCode() {
		return Objects.hash(assessment, dateOfBirth, marksScored, name, studentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(assessment, other.assessment) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(marksScored, other.marksScored) && Objects.equals(name, other.name)
				&& Objects.equals(studentId, other.studentId);
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", marksScored="
				+ marksScored + ", assessment=" + assessment + "]";
	}

	
}
