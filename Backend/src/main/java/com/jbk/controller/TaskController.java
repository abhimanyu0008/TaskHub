package com.jbk.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Task;
import com.jbk.service.TaskService;

@RestController
//@RequestMapping("/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/tasks")
	public ResponseEntity<String> createTask(@RequestBody Task task) {
		try {
			String msg = taskService.createTask(task);
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error creating task", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<Task>> getAllTasks() {
		try {
			List<Task> tasks = taskService.getAllTask();
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/tasks/{id}")
	public Task getTaskById(@PathVariable long id) {
		Task task = taskService.getTaskByid(id);
		return task;
	}

	@PutMapping("/tasks")
	public ResponseEntity updateTask(@RequestBody Task task) {
		try {
			String msg = taskService.updateTask(task);
			return ResponseEntity.ok(msg);
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update task");
		}
	}

	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
		return taskService.updateTask(id, taskDetails);
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity deleteTask(@PathVariable long id) {
		try {
			String msg = taskService.deleteTask(id);
			return ResponseEntity.ok(msg);
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete task");
		}
	}
}
