package com.caregiverproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caregiverproject.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
