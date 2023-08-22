package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Instructor;
import com.toekneejin.instructortrackingsystem.model.SubjectComfortabilityObj;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcInstructorSubjectDao implements InstructorSubjectDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcInstructorSubjectDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<SubjectComfortabilityObj> getSubjectInfoByInstructorId(int instructorId) {
        return null;
    }

    @Override
    public List<Instructor> getInstructorInfoBySubjectId(int subjectId) {
        return null;
    }

    @Override
    public SubjectComfortabilityObj addSubjectComfortability(int instructorId, SubjectComfortabilityObj obj) {
        return null;
    }

    @Override
    public SubjectComfortabilityObj updateSubjectComfortability(int instructorId, int subId, SubjectComfortabilityObj obj) {
        return null;
    }

    @Override
    public void deleteSubjectComfortability(int instructorId, int subId) {

    }
}
