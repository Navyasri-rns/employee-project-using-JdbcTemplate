package com.example.SpringTask1.repositry;

import com.example.SpringTask1.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeReposInt {

    public void save(EmployeeEntity e);

    public EmployeeEntity findById(int id);

    public List<EmployeeEntity> findAll();

    public void update(EmployeeEntity e);

    public void delete(int id);
}
