package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Subject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcSubjectDao implements SubjectDao{
    @Override
    public List<Subject> getAll() {
        return null;
    }

    @Override
    public Subject getById(int id) {
        return null;
    }

    @Override
    public Subject addSubject(Subject subject) {
        return null;
    }

    @Override
    public Subject updateSubject(int id, Subject subject) {
        return null;
    }

    @Override
    public void deleteSubject(int id) {

    }
}
