package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Subject;

import java.util.List;

public interface SubjectDao {
    List<Subject> getAll();
    Subject getById(int id);
    Subject addSubject(Subject subject);
    Subject updateSubject(int id, Subject subject);
    void deleteSubject(int id);

}
