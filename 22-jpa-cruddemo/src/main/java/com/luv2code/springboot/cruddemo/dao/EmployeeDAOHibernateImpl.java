package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		Session currentsession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentsession.createQuery("from Employee", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Session currentsession = entityManager.unwrap(Session.class);

		currentsession.saveOrUpdate(theEmployee);

	}

	@Override
	public void delete(int theId) {

		Session currentsession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentsession.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
		
	}

}
