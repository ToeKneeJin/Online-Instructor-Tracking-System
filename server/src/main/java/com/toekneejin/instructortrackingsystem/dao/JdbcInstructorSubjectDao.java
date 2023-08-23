package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.controller.InstructorController;
import com.toekneejin.instructortrackingsystem.model.Instructor;
import com.toekneejin.instructortrackingsystem.model.SubjectComfortabilityObj;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInstructorSubjectDao implements InstructorSubjectDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcInstructorSubjectDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<SubjectComfortabilityObj> getSubjectInfoByInstructorId(int instructorId) {
        List<SubjectComfortabilityObj> list = new ArrayList<>();
        String sql = "SELECT * FROM instructor_subject WHERE instructor_id = ? ORDER BY subject_id";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, instructorId);
        while ((result.next())){
            SubjectComfortabilityObj obj = mapRowToSubjectComfortabilityObject(result);
            list.add(obj);
        }
        return list;
    }

    @Override
    public List<Instructor> getInstructorInfoBySubjectId(int subjectId) {
        List<Integer> instructorIdList = new ArrayList<>();
        String sql = "SELECT instructor_id FROM instructor_subject WHERE subject_id = ? ORDER BY instructor_id";
        SqlRowSet initialResult = jdbcTemplate.queryForRowSet(sql, subjectId);
        while(initialResult.next()){
            instructorIdList.add(initialResult.getInt("instructor_id"));
        }
        List<Instructor> instructorList = new ArrayList<>();
        for(Integer id: instructorIdList){
            instructorList.add(instructorController.getInstructorById(id));
        }

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

    private SubjectComfortabilityObj mapRowToSubjectComfortabilityObject(SqlRowSet row){
        SubjectComfortabilityObj obj = new SubjectComfortabilityObj();
        obj.setEntryId(row.getInt("entry_id"));
        obj.setInstructorId(row.getInt("instructor_id"));
        obj.setSubjectId(row.getInt("subject_id"));
        obj.setComfortabilityLevel(row.getInt("comfortability_level"));
        return obj;
    }
}
