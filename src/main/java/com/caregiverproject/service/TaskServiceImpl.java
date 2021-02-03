package com.caregiverproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caregiverproject.dao.TaskRepository;
import com.caregiverproject.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Override
	public Task findById(int theId) {
		Optional<Task> result = taskRepository.findById(theId);
		
		Task task = null;
		if(result.isPresent()) {
			task = result.get();
		}
		
		return task;
	}
	
	@Override
	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public void deleteById(int theId) {
		taskRepository.deleteById(theId);
	}
	
	@Override
	public void delete(Task task) {
		taskRepository.delete(task);
	}
	
	@Override
	public Task findClientTask(int idTask) {
		return this.findById(idTask);
	}
}
