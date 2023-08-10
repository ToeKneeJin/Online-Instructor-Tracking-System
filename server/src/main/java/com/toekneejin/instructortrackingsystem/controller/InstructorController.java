package com.toekneejin.instructortrackingsystem.controller;

import com.toekneejin.instructortrackingsystem.dao.InstructorDao;
import com.toekneejin.instructortrackingsystem.model.Instructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/* 
// get instructors
// get instructor by id
// add instructor
// update instructor
// delete instructor
*/

/*
// get subjects and comfortability by instructor
// get instructors by subject
*/

@RestController
@CrossOrigin
@RequestMapping("/instructor")
public class InstructorController {

    private InstructorDao instructorDao;

    public InstructorController(InstructorDao instructorDao){this.instructorDao = instructorDao;}


    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Instructor> getList(@RequestParam(required = false) String searchTerm) {
        if (searchTerm == null) {
            return instructorDao.getAll();
        } else {
            return instructorDao.find(searchTerm);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Instructor getInstructorById(@PathVariable int id){
        Instructor instructor = instructorDao.getById(id);
        if(instructor == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The instructor with id=%d was not found.", id));
        }
        return instructor;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Instructor addInstructor(@RequestBody Instructor instructor){
        return instructorDao.addInstructor(instructor);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Instructor updateInstructor(@PathVariable int id, @RequestBody Instructor instructor){
        return instructorDao.updateInstructor(id, instructor);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteInstructor(@PathVariable int id){
        instructorDao.deleteInstructor(id);
    }
}
