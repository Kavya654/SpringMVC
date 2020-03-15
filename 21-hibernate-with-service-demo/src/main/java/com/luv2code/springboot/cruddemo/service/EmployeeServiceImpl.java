package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeDAO theEmployeeDao;
	
	@Autowired
	public  EmployeeServiceImpl(EmployeeDAO theEmployeeDao) {
		this.theEmployeeDao = theEmployeeDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return theEmployeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return theEmployeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		theEmployeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void delete(int theId) {
		theEmployeeDao.delete(theId);
	}

}
