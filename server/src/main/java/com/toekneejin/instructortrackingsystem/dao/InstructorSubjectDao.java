package com.toekneejin.instructortrackingsystem.dao;

import com.toekneejin.instructortrackingsystem.model.Instructor;
import com.toekneejin.instructortrackingsystem.model.SubjectComfortabilityObj;

import java.util.List;

public interface InstructorSubjectDao {
    List<SubjectComfortabilityObj> getSubjectInfoByInstructorId(int instructorId);
    List<Instructor> getInstructorInfoBySubjectId(int subjectId);
    SubjectComfortabilityObj addSubjectComfortability(int instructorId, SubjectComfortabilityObj obj);
    SubjectComfortabilityObj updateSubjectComfortability(int instructorId, int subId, SubjectComfortabilityObj obj);
    void deleteSubjectComfortability(int instructorId, int subId);
}
