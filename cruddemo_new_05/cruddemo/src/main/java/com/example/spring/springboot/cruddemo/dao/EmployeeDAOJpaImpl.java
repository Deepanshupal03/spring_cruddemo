package com.example.spring.springboot.cruddemo.dao;
import com.example.spring.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao {
    //define field for entitymanager
    private EntityManager entityManager;
//set up cosntructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
        //execute query and get result list
        List<Employee> employees = query.getResultList();
        //return the results
        return employees ;
    }
    public Employee findById(int id) {
        //get employee
        Employee employee = entityManager.find(Employee.class, id);
        //return employee
        return employee ;
    }

    @Override
    public Employee save(Employee employee) {
        //save employees
        Employee savedEmployee = entityManager.merge(employee);
        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {
       Employee employee = entityManager.find(Employee.class, id);
       //remove the employee
        entityManager.remove(employee);
    }
}
