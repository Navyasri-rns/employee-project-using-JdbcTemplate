package com.example.SpringTask1.controller;

import com.example.SpringTask1.entity.EmployeeEntity;
import com.example.SpringTask1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService es;
    @PostMapping("/create")
    public void createEmployee(@RequestBody EmployeeEntity e){
        es.createEmployee(e);
    }
    @GetMapping("/{e}")
    public EmployeeEntity getEmployeeById(@PathVariable int e){
        return es.findEmployeeById(e);
    }
    @GetMapping("/listemployees")
    public List<EmployeeEntity> getAllEmployees(){
        return es.getAllEmployees();
    }
    @PutMapping("/update")
    public void updateEmployee(@RequestBody EmployeeEntity e){
        es.updateEmployee(e);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        es.deleteEmployee(id);
    }
}
