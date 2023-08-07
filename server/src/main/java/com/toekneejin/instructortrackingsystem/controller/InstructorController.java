package com.toekneejin.instructortrackingsystem.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/instructor")
public class InstructorController {
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<instructor> getList(@RequestParam(required = false) String searchTerm) {
        if (searchTerm == null) {
            return instructorDao.getAll();
        } else {
            return instructorDao.find(searchTerm);
        }
    }
}
