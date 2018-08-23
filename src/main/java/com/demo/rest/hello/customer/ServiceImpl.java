package com.demo.rest.hello.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rest.dao.DAO;
import com.demo.rest.pojo.Employee;

@Service
public class ServiceImpl{
	@Autowired
	private DAO dao/*= new DAO()*/;
	
	/* (non-Javadoc)
	 * @see com.demo.customer.model.Service#create(java.lang.String)
	 */
	public List<Employee> viewAll() {
		return dao.findAll();
	}
	
	public Employee view(int id) {
		return dao.findById(id).get();
	}
	public void save(Employee employee) {
		dao.save(employee);
		
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return (int) dao.count();
	}
}
