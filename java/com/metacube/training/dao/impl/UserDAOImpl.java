package com.metacube.training.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.metacube.training.interfaces.UserDAO;
import com.metacube.training.log.MyLogFile;
import com.metacube.training.model.User;
import com.metacube.training.model.UserCredential;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean add(User user) {
		try {
			sessionFactory.openSession().save(user);

		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");
			return false;
		}
		return true;
	}

	@Override
	public User get(Integer id) {
		try {
			Criteria criteria=sessionFactory.openSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("id", id));
			User user=(User)criteria.uniqueResult();
			System.out.println(user.getFirstName());
			return user;
		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");

		}
		return null;
	}

	@Override
	public boolean update(User user) {
		try {
			System.out.println(user.getLastName());
			sessionFactory.openSession().update(user);
		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");

		}
		return true;
	}

	@Override
	public List<User> getAll() {
		try {

			Criteria criteria = sessionFactory.openSession().createCriteria(
					User.class);
			List<User> users = criteria.list();
			return users;
		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");
			return null;
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			User user=new User();
			user.setId(id);
			sessionFactory.openSession().delete(user);
			return true;
		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");
			return false;
		}
	}

	@Override
	public List<User> getByAttribute(String attribute, String value) {
		try {
			Criteria criteria=sessionFactory.openSession().createCriteria(User.class);
			criteria.add(Restrictions.eq(attribute, value));
			List<User> users=criteria.list();
			return users;
		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");
			return null;
		}
	}

	@Override
	public boolean getUsersCredentials(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Criteria criteria=sessionFactory.openSession().createCriteria(UserCredential.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("password", password));
			List<User> users=criteria.list();
			if(users.isEmpty()){
				sessionFactory.openSession().save(new UserCredential(username, password));
			}
			return false;
		} catch (DataAccessException e) {
			MyLogFile.writeToFile("Mesage:" + e.getMessage() + "Time:"
					+ new Date() + "\n");
			return false;
		}

	}

}
