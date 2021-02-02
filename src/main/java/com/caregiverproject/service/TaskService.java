package com.caregiverproject.service;

import com.caregiverproject.entity.Task;

public interface TaskService {

	Task findById(int theId);
	
	Task findClientTask(int idTask);

}
