package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.TaskDao;
import com.jbk.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao dao;

	@Override
	public String createTask(Task task) {
		String msg = dao.createTask(task);
		return msg;
	}

	@Override
	public List<Task> getAllTask() {
		try {
			return dao.getAllTask();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve tasks");
		}
	}

	@Override
	public Task getTaskByid(long id) {
		Task task = dao.getTaskById(id);
		return task;
	}

	@Override
	public String updateTask(Task task) {
		String msg = dao.updateTask(task);
		return msg;
	}

	@Override
	public String deleteTask(long id) {
		String msg = dao.deleteTask(id);
		return msg;
	}

	@Override
	public Task updateTask(Long id, Task taskDetails) {

		return dao.updateTask(id, taskDetails);
	}

}
