package com.example.spring.springboot.cruddemo.service;
import com.example.spring.springboot.cruddemo.dao.EmployeeDao;
import com.example.spring.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
@Autowired
public EmployeeServiceImpl(EmployeeDao theEmployee ){
    employeeDao = theEmployee;
}
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
           employeeDao.deleteById(id);
    }
}
