package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSubjectDao implements SubjectDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcSubjectDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Subject> getAll() {
        List<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM subjects ORDER BY subject_id";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Subject subject = mapRowToSubject(result);
            list.add(subject);
        }
        return list;
    }

    @Override
    public Subject getById(int id) {
        String sql = "SELECT * FROM subjects WHERE subject_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            return mapRowToSubject(result);
        } else {
            return null;
        }
    }

    @Override
    public Subject addSubject(Subject subject) {
        String sql = "INSERT INTO subjects (subject_name, subject_details) VALUES (?, ?) RETURNING subject_id";
        int ID = jdbcTemplate.queryForObject(sql, int.class, subject.getSubjectName(), subject.getSubjectDetails());
        return getById(ID);
    }

    @Override
    public Subject updateSubject(int id, Subject subject) {
        String sql = "UPDATE subjects SET subject_name = ?, subject_details = ? WHERE subject_id = ?";
        jdbcTemplate.update(sql, subject.getSubjectName(), subject.getSubjectDetails(), subject.getSubjectId());
        return getById(id);
    }

    @Override
    public void deleteSubject(int id) {
        String sql = "DELETE FROM subjects WHERE subject_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Subject mapRowToSubject(SqlRowSet row){
        Subject subject = new Subject();
        subject.setSubjectId(row.getInt("subject_id"));
        subject.setSubjectName(row.getString("subject_name"));
        subject.setSubjectDetails(row.getString("subject_details"));
        return subject;
    }
}
