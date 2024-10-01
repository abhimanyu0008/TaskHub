package com.jbk.service;

import java.util.List;

import com.jbk.entity.Task;

public interface TaskService{

	String createTask(Task task);

	List<Task> getAllTask();

	Task getTaskByid(long id);

	String updateTask(Task task);

	String deleteTask(long id);

	Task updateTask(Long id, Task taskDetails);
	
}
