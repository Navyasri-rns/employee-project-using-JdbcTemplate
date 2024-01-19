package com.example.SpringTask1.repositry;

import com.example.SpringTask1.entity.EmployeeEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeRepositry implements EmployeeReposInt{

    private final JdbcTemplate jt;

    public EmployeeRepositry(JdbcTemplate jt) {
        this.jt = jt;
    }
    @Override
    public void save(EmployeeEntity e) {
        String que = "Insert into employee_entity(id, first_name, last_name, email_id) values (?,?,?,?);";
        jt.update(que,e.getId(),e.getFirstName(),e.getLastName(),e.getEmailId());
    }

    @Override
    public EmployeeEntity findById(int id) {
        String que = "Select * from employee_entity where id=?;";
        return jt.queryForObject(que, BeanPropertyRowMapper.newInstance(EmployeeEntity.class),id);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        String que = "Select * from employee_entity;";
        return jt.query(que, BeanPropertyRowMapper.newInstance(EmployeeEntity.class));
    }

    @Override
    public void update(EmployeeEntity e) {
        String que = "Update employee_entity Set first_name = ?, last_name=?, email_id=? where id=?";
        jt.update(que, e.getFirstName(), e.getLastName(), e.getEmailId(), e.getId());
    }

    @Override
    public void delete(int id) {
        String que = "Delete From employee_entity where id=?";
        jt.update(que, id);
    }
}
