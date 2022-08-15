package com.example.dto;

import java.util.Objects;

import javax.persistence.Id;

import com.example.entity.Assessment;





public class AssessmentDTO {

	

	private int assessmentId;
	private String assessmentName;
	private Integer maxMarks;
	private Integer passingMarks;
	public int getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public Integer getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(Integer maxMarks) {
		this.maxMarks = maxMarks;
	}
	public Integer getPassingMarks() {
		return passingMarks;
	}
	public void setPassingMarks(Integer passingMarks) {
		this.passingMarks = passingMarks;
	}
	@Override
	public int hashCode() {
		return Objects.hash(assessmentId, assessmentName, maxMarks, passingMarks);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssessmentDTO other = (AssessmentDTO) obj;
		return assessmentId == other.assessmentId && Objects.equals(assessmentName, other.assessmentName)
				&& maxMarks == other.maxMarks && passingMarks == other.passingMarks;
	}
	@Override
	public String toString() {
		return "AssessmentDTO [assessmentId=" + assessmentId + ", assessmentName=" + assessmentName + ", maxMarks="
				+ maxMarks + ", passingMarks=" + passingMarks + "]";
	}



}