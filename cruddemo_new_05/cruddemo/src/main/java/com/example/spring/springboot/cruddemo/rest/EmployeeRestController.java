package com.example.spring.springboot.cruddemo.rest;
import com.example.spring.springboot.cruddemo.dao.EmployeeDao;
import com.example.spring.springboot.cruddemo.entity.Employee;
import com.example.spring.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //private EmployeeDao employeeDao;
  private EmployeeService employeeService;
    //quick and dirty inject employee dao above m jo h
@Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
   /* public EmployeeRestController(EmployeeDao theEmployeeDAO)
    {

        employeeDao=theEmployeeDAO;
    }
    //expose "/employees" and return a list of employees*/
@GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
}
@GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
//@PathVariable is used to retreive user with the given ID from the database...
Employee theEmployee= employeeService.findById(employeeId);
if(theEmployee==null){
    throw new RuntimeException("Employee not found"+employeeId);
}
return theEmployee;
}

// add mapping for post /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
         // @RequestBody annotation is used to bind the HTTP request body to a method parameter in a controller
        // It allows you to deserialize the request body,
        // typically in JSON or XML format, into a Java object
    theEmployee.setId(0);// in json set the id equal to zero ...
    Employee dbEmployee = employeeService.save(theEmployee);
    return dbEmployee;
      }
      @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
    Employee dbEmployee = employeeService.save(theEmployee);
    return dbEmployee;
      }
      //add mapping dor delete("/employees/{employeeId}"}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
    Employee theEmployee = employeeService.findById(employeeId);
    //throw a exception if null
        if(theEmployee==null)
        {
            throw new RuntimeException("Employee not found"+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee deleted"+employeeId;
    }
}
