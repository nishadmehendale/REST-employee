package com.demo.rest.hello;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.hello.customer.ServiceImpl;
import com.demo.rest.pojo.Employee;


@RestController

public class Hello{
	@Autowired
	private ServiceImpl service /*= new ServiceImpl()*/; 
	
	@RequestMapping("/employees")
	public List<Employee> viewAll() {
		List<Employee> tempEmployees = service.viewAll();
		return tempEmployees;
	}
	
	@SuppressWarnings({ "null", "rawtypes" })
	@RequestMapping("/employees/{start}/{count}")
	public Resources viewBetween(@PathVariable int start, @PathVariable int count) {
		List<Employee> tempEmployees = viewAll();
		tempEmployees.forEach(System.out::println);
		List<Employee> employees = new ArrayList<>();
		for (int i=0; i<service.getSize(); i++)
			System.out.println(tempEmployees.get(i));
		for(int i=start-1;i<start+count-1;i++) {
			employees.add((Employee)tempEmployees.get(i));
		}
		Link previous = linkTo(methodOn(this.getClass()).viewBetween(start-count>0?start-count:1, count)).withRel("previous");
		Link next = linkTo(methodOn(this.getClass()).viewBetween(start+count>service.getSize()?service.getSize()-count+1:start+count, start+count>service.getSize()?1:count)).withRel("next");
		return new Resources<>(employees, previous, next);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/employees/{id}")
	public Resource view(@PathVariable int id) {
		Link link = linkTo(methodOn(this.getClass()).viewAll()).withRel("View All Employees");
		return new Resource(service.view(id),link);
	}
}
