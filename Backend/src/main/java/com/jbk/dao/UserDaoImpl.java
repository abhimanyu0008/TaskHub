package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    private SessionFactory factory;

    @Override
    public Object loginUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(username + " " + password);

        Session session = null;
        try {
            session = factory.openSession();
            User foundUser = session.get(User.class, username);
            if (foundUser == null) {
                return "User not found";
            }
            if (!foundUser.getPassword().equals(password)) {
                return "Invalid username or password";
            }
            return foundUser;
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred during login";
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Override
    public User registerUser(User user) {
        Session session = null;
        User existingUser = null;
        try {
            session = factory.openSession();
            existingUser = session.get(User.class, user.getUsername());
            if (existingUser == null) {
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
	@Override
	public boolean changePassword(String username, String newPassword) {
		Session session = null;
        User existingUser = null;
        try {
            session = factory.openSession();
            existingUser = session.get(User.class, username);
            if (existingUser != null) {
                session.beginTransaction();
                existingUser.setPassword(newPassword);
                session.update(existingUser);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }
	}

