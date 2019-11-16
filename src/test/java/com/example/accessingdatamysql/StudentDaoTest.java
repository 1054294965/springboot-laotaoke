package com.example.accessingdatamysql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.accessingdatamysql.entity.Student;
import com.example.accessingdatamysql.entity.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {
	@Autowired
	private StudentRepository StudentRepository;

	@Test
	public void query() {
		List<Sort.Order> orders = new ArrayList<>();
		orders.add(new Sort.Order(Sort.Direction.ASC, "name")); // 根据name排序
        Sort sort = Sort.by(orders);
        
		Page<Student> page = StudentRepository.findAll(PageRequest.of(1,5,sort));
		Stream<Student> stream = page.get();
		for (Student student : page) {
			System.out.println(student);
		}
		
		
		
        
		
	}
	
	@Test
	public void now() {
		List<Sort.Order> orders = new ArrayList<>();
		orders.add(new Sort.Order(Sort.Direction.ASC, "name")); // 根据name排序
        Sort sort = Sort.by(orders);
        
		Page<Student> page = StudentRepository.findAll(PageRequest.of(1,5,sort));
		Stream<Student> stream = page.get();
		for (Student student : page) {
			System.out.println(student);
		}
	}
	
	@Test
	public void old() {
		List<Sort.Order> orders = new ArrayList<>();
		orders.add(new Sort.Order(Sort.Direction.ASC, "name")); // 根据name排序
        Sort sort = new Sort(orders);     
        
		Page<Student> page = StudentRepository.findAll(new PageRequest(1, 5,sort));
		Stream<Student> stream = page.get();
		for (Student student : page) {
			System.out.println(student);
		}
	}
	 
}
