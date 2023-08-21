package com.toekneejin.instructortrackingsystem.model;

public class Subject {
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(int subjectId, String subjectName, String subjectDetails) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDetails = subjectDetails;
    }

    public Subject(){}

    private int subjectId;
    private String subjectName;

    public String getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(String subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    private String subjectDetails;
}
