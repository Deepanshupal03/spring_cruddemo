package com.example.spring.springboot.cruddemo.dao;

import com.example.spring.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

}
