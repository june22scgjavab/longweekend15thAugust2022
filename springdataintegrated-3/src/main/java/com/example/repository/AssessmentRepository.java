package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Assessment;

public interface AssessmentRepository extends CrudRepository<Assessment,Integer> {

}
