package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Instructor;

import java.util.List;

public interface InstructorDao {

    List<Instructor> getAll();

    List<Instructor> find(String searchTerm);

    Instructor getById(int id);

    Instructor addInstructor(Instructor instructor);

    Instructor updateInstructor(int id, Instructor instructor);

    void deleteInstructor(int id);
}
