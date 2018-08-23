package com.demo.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.rest.pojo.Employee;

@Repository
public interface DAO extends JpaRepository<Employee,Integer>{

}
