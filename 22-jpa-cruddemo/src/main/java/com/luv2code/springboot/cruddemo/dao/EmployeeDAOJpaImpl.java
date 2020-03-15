package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee emp = entityManager.find(Employee.class,theId);
		return emp;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Employee emp = entityManager.merge(theEmployee);
		
		theEmployee.setId(emp.getId());
		
		

	}

	@Override
	public void delete(int theId) {
	Query query = 	entityManager.createQuery("delete from Employee where id=:employeeId");
	query.setParameter("employeeId",theId);
	query.executeUpdate();
		
		
	}

}
