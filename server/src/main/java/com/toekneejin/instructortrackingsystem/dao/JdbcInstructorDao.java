package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Instructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInstructorDao implements InstructorDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInstructorDao(DataSource dataSource){this.jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public List<Instructor> getAll() {
        List<Instructor> list = new ArrayList<>();
        String sql = "SELECT * FROM instructor ORDER BY instructor_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Instructor instructor = mapRowtoInstructor(results);
            list.add(instructor);
        }
        return list;
    }

    @Override
    public List<Instructor> find(String searchTerm) {
        List<Instructor> list = new ArrayList<>();
        String newST = '%' + searchTerm + "%";
        String sql = "SELECT * FROM instructor WHERE instructor_name ILIKE ? ORDER BY instructor_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newST);
        while (results.next()) {
            Instructor instructor = mapRowtoInstructor(results);
            list.add(instructor);
        }
        return list;
    }

    @Override
    public Instructor getById(int id) {
        String sql = "SELECT * FROM instructor WHERE instructor_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if(result.next()){
            return mapRowtoInstructor(result);
        }else{
            return null;
        }
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        String sql = "INSERT INTO instructor (instructor_name, instructor_timezone, instructor_rating, instructor_description, is_chinese_speaking)" +
                " VALUES (?, ?, ?, ?, ?) RETURNING instructor_id";
        int ID = jdbcTemplate.queryForObject(sql, int.class, instructor.getInstructorName(), instructor.getInstructorTimeZone(), instructor.getInstructorRating(), instructor.getInstructorDescription(), instructor.isChineseSpeaking());
        return getById(ID);
    }

    @Override
    public Instructor updateInstructor(int id, Instructor instructor) {
        String sql = "UPDATE instructor SET instructor_name = ?, instructor_timezone = ?, instructor_rating = ?, instructor_description = ?, is_chinese_speaking = ?" +
                " WHERE instructor_id = ?";
        jdbcTemplate.update(sql, instructor.getInstructorName(), instructor.getInstructorTimeZone(), instructor.getInstructorRating(), instructor.getInstructorDescription(), instructor.isChineseSpeaking(), id);
        return getById(id);
    }

    @Override
    public void deleteInstructor(int id) {
        String sql = "DELETE FROM instructor WHERE instructor_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private Instructor mapRowtoInstructor(SqlRowSet rs){
        Instructor instructor = new Instructor();
        instructor.setInstructorId(rs.getInt("instructor_id"));
        instructor.setInstructorName(rs.getString("instructor_name"));
        instructor.setInstructorTimeZone(rs.getString("instructor_timezone"));
        instructor.setInstructorRating(rs.getInt("instructor_rating"));
        instructor.setInstructorDescription(rs.getString("instructor_description"));
        instructor.setChineseSpeaking(rs.getBoolean("is_chinese_speaking"));
        return instructor;
    }
}
