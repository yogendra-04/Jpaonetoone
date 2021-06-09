package com.example.OneToOne.controllers;

import com.example.OneToOne.Repositories.EmpAddRepo;
import com.example.OneToOne.Repositories.EmpRepo;
import com.example.OneToOne.model.Employee;
import com.example.OneToOne.model.EmployeeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmpRepo empRepo;
    @Autowired
    EmpAddRepo eaRepo;

    @PostConstruct
    public void init(){
        EmployeeAddress ea1 = new EmployeeAddress("street1","city1",101);
        EmployeeAddress ea2 = new EmployeeAddress("street2","city2",102);

        Employee e1 = new Employee("name1","dev",ea1);
        empRepo.save(e1);

        Employee e2 = new Employee("name2","dev",ea2);
        empRepo.save(e2);

        eaRepo.save(ea1);
        eaRepo.save(ea2);

        System.out.println("initialized");
    }

    @GetMapping("/all")
    public Iterable<Employee> allEmployees(){

        return empRepo.findAll();
    }


    @PostMapping("/")
    public Employee getEmployees(@RequestBody Employee employee){
        return empRepo.save(employee);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchStudent(@PathVariable(value = "id") int id){
        Employee temp = null;
        if(empRepo.findById(id).isPresent()) {
            temp = empRepo.findById(id).get();
        }


        if(temp == null){
            return new ResponseEntity<>("no id found ", HttpStatus.NOT_FOUND);
        }
        System.out.println(temp.toString());
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity deleteCourse(@PathVariable(value = "id") int id){
        Employee temp = null;
        if(empRepo.findById(id).isPresent()) {
            temp = empRepo.findById(id).get();
        }

        if(temp == null){
            return new ResponseEntity("no id found to delete", HttpStatus.NOT_FOUND);
        }
        empRepo.delete(temp);
        return new ResponseEntity( "deleted successfully", HttpStatus.OK);

    }
}
