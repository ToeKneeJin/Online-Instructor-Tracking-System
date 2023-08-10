package com.toekneejin.instructortrackingsystem.model;

public class Instructor {

    public Instructor(int instructorId, String instructorName, String instructorTimeZone, int instructorRating, String instructorDescription, boolean isChineseSpeaking) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorTimeZone = instructorTimeZone;
        this.instructorRating = instructorRating;
        this.instructorDescription = instructorDescription;
        this.isChineseSpeaking = isChineseSpeaking;
    }

    public Instructor(){
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorTimeZone() {
        return instructorTimeZone;
    }

    public void setInstructorTimeZone(String instructorTimeZone) {
        this.instructorTimeZone = instructorTimeZone;
    }

    public int getInstructorRating() {
        return instructorRating;
    }

    public void setInstructorRating(int instructorRating) {
        this.instructorRating = instructorRating;
    }

    public String getInstructorDescription() {
        return instructorDescription;
    }

    public void setInstructorDescription(String instructorDescription) {
        this.instructorDescription = instructorDescription;
    }

    public boolean isChineseSpeaking() {
        return isChineseSpeaking;
    }

    public void setChineseSpeaking(boolean chineseSpeaking) {
        isChineseSpeaking = chineseSpeaking;
    }

    private int instructorId;
    private String instructorName;
    private String instructorTimeZone;
    private int instructorRating;
    private String instructorDescription;
    private boolean isChineseSpeaking;



}
