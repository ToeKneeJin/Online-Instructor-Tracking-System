package com.toekneejin.instructortrackingsystem.controller;

import com.toekneejin.instructortrackingsystem.dao.SubjectDao;
import com.toekneejin.instructortrackingsystem.model.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


// get subjects
// get subject by id
// add
// update
// delete
@RestController
@CrossOrigin
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectDao subjectDao;

    public SubjectController(SubjectDao subjectDao){this.subjectDao = subjectDao;};

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Subject> getList(){
        return subjectDao.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Subject getSubjectById(@PathVariable int id){
        Subject subject = subjectDao.getById(id);
        if(subject == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The subject with id=%d was not found.", id));
        }
        return subject;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Subject addSubject(@RequestBody Subject subject){
        return subjectDao.addSubject(subject);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Subject updateSubject(@PathVariable int id, @RequestBody Subject subject){
        return subjectDao.updateSubject(id, subject);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteSubject(@PathVariable int id){
        subjectDao.deleteSubject(id);
    }

}
