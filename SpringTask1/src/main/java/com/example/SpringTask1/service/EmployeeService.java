package com.example.SpringTask1.service;

import com.example.SpringTask1.entity.EmployeeEntity;
import com.example.SpringTask1.repositry.EmployeeReposInt;
import com.example.SpringTask1.repositry.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositry er;

    public EmployeeService(EmployeeRepositry er) {
        this.er = er;
    }

    public void createEmployee(EmployeeEntity e){
        er.save(e);
    }

    public EmployeeEntity findEmployeeById(int id){
        return er.findById(id);
    }

    public List<EmployeeEntity> getAllEmployees(){
        return er.findAll();
    }

    public void updateEmployee(EmployeeEntity e){
        er.update(e);
    }

    public void deleteEmployee(int id){
        er.delete(id);
    }
}
