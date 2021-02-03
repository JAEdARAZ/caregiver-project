package com.caregiverproject.service;

import com.caregiverproject.entity.Task;

public interface TaskService {

	Task findById(int theId);
	
	Task save(Task task);
	
	Task findClientTask(int idTask);

	void deleteById(int theId);

	void delete(Task task);

}
