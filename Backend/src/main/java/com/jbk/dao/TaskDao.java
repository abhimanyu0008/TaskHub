package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Task;

public interface TaskDao {

	String createTask(Task task);

	List<Task> getAllTask();

	Task getTaskById(long id);

	String updateTask(Task task);

	String deleteTask(long id);

	Task updateTask(Long id, Task taskDetails);

}
