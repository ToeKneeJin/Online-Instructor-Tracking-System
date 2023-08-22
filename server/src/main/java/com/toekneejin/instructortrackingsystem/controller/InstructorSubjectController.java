package com.toekneejin.instructortrackingsystem.controller;

import com.toekneejin.instructortrackingsystem.dao.InstructorSubjectDao;
import com.toekneejin.instructortrackingsystem.model.Instructor;
import com.toekneejin.instructortrackingsystem.model.Subject;
import com.toekneejin.instructortrackingsystem.model.SubjectComfortabilityObj;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
// get subjects and comfortability by instructor id
// get instructors by subject id
// add comfortability and subject by instructor id
// update comfortability by instructor id and subject id
// delete comfortability and subject by instructor id
 */

@RestController
@CrossOrigin
public class InstructorSubjectController {
    private InstructorSubjectDao instructorSubjectDao;
    public InstructorSubjectController(InstructorSubjectDao instructorSubjectDao){this.instructorSubjectDao = instructorSubjectDao;}

    @RequestMapping(path = "/instructor/{id}/subjects", method = RequestMethod.GET)
    public List<SubjectComfortabilityObj> getSubjectInfoByInstructorId(@PathVariable int instructorId){
        List<SubjectComfortabilityObj> list = instructorSubjectDao.getSubjectInfoByInstructorId(instructorId);
        if(list == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Instructor ID not found"));
        }
        return list;
    }

    @RequestMapping(path = "/subjects/{id}", method = RequestMethod.GET)
    public List<Instructor> getInstructorsBySubjectId(@PathVariable int subjectId){
        List<Instructor> list = instructorSubjectDao.getInstructorInfoBySubjectId(subjectId);
        if(list == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Subject ID not found"));
        }
        return list;
    }

    @RequestMapping(path = "/instructor/{id}/subjects", method = RequestMethod.POST)
    public SubjectComfortabilityObj addSubjectComfortability(@PathVariable int instructorId, @RequestBody SubjectComfortabilityObj obj){
        return instructorSubjectDao.addSubjectComfortability(instructorId, obj);
    }

    @RequestMapping(path = "/instructor/{id}/subjects/{subId}", method = RequestMethod.PUT)
    public SubjectComfortabilityObj updateSubjectComfortability(@PathVariable int instructorId, @RequestBody int subId, @RequestBody SubjectComfortabilityObj obj){
        return instructorSubjectDao.updateSubjectComfortability(instructorId, subId, obj);
    }

    @RequestMapping(path = "/instructor/{id}/subjects/{subId}", method = RequestMethod.DELETE)
    public void deleteSubjectComfortability(@PathVariable int instructorId, @RequestBody int subId){
        instructorSubjectDao.deleteSubjectComfortability(instructorId, subId);
    }
}
