package com.jbk.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Task;

import jakarta.persistence.Query;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public String createTask(Task task) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(task);
			session.getTransaction().commit();
			return "data added";
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			throw new RuntimeException("Error creating task", e);
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<Task> getAllTask() {
		Session session = null;
		List<Task> task = null;
		try {
			session = factory.openSession();
			session.beginTransaction();

			// Native SQL Query to fetch all tasks
			String sql = "SELECT * FROM task_info";
			Query query = session.createNativeQuery(sql, Task.class);
			task = query.getResultList();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return task;
	}

	@Override
	public Task getTaskById(long id) {
		Session session = null;
		Task task = null;
		try {
			session = factory.openSession();
			task = session.get(Task.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return task;
	}

	@Override
	public String updateTask(Task task) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();

			// Fetch existing task to verify it exists
			Task existingTask = session.get(Task.class, task.getId());
			if (existingTask == null) {
				throw new NoSuchElementException("Task not found with ID: " + task.getId());
			}

			// Update the task
			existingTask.setTitle(task.getTitle());
			existingTask.setDescription(task.getDescription());
			existingTask.setStatus(task.getStatus());
			existingTask.setDate(task.getDate());

			session.update(existingTask);
			session.getTransaction().commit();

			return "Task updated successfully";
		} catch (NoSuchElementException e) {
			throw e; // Propagate not found exception
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
			throw new RuntimeException("Failed to update task in the database");
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public String deleteTask(long id) {
		Session session = null;
		try {
            session = factory.openSession();
            session.beginTransaction();

            // Fetch existing task to verify it exists
            Task task = session.get(Task.class, id);
            if (task == null) {
                throw new NoSuchElementException("Task not found with ID: " + id);
            }

            // Delete the task
            session.delete(task);
            session.getTransaction().commit();

            return "Task deleted successfully";
        } catch (NoSuchElementException e) {
            throw e; // Propagate not found exception
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete task from the database");
        } finally {
            if (session != null) {
                session.close();
            }
        }
	}

	@Override
	public Task updateTask(Long id, Task taskDetails) {
		Session session = null;
		Task existingTask = null;

		try {
			session = factory.openSession();
			session.beginTransaction();

			existingTask = session.get(Task.class, id);
			if (existingTask != null) {

				existingTask.setTitle(taskDetails.getTitle());
				existingTask.setDescription(taskDetails.getDescription());

				session.update(existingTask);
				session.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return existingTask;
	}

}
