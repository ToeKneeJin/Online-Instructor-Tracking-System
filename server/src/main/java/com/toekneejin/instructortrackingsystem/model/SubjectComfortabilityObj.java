package com.toekneejin.instructortrackingsystem.model;

public class SubjectComfortabilityObj {
    private int entryId;
    private int subjectId;
    private int instructorId;
    private int comfortabilityLevel;

    public SubjectComfortabilityObj(int entryId, int subjectId, int instructorId, int comfortabilityLevel) {
        this.entryId = entryId;
        this.subjectId = subjectId;
        this.instructorId = instructorId;
        this.comfortabilityLevel = comfortabilityLevel;
    }

    public SubjectComfortabilityObj(){};

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getComfortabilityLevel() {
        return comfortabilityLevel;
    }

    public void setComfortabilityLevel(int comfortabilityLevel) {
        this.comfortabilityLevel = comfortabilityLevel;
    }
}
