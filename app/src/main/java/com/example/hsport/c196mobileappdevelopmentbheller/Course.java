package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity(tableName = "course_table")
public class Course {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "course_id")
    private int courseID;

    @NonNull
    @ColumnInfo(name = "course_name")
    private String courseName;

    @NonNull
    @ColumnInfo(name = "course_start")
    private String courseStart;

    @NonNull
    @ColumnInfo(name = "course_end")
    private String courseEnd;

    @NonNull
    @ColumnInfo(name = "course_status")
    private String courseStatus;

    @ColumnInfo(name = "course_mentor_ids")
    private ArrayList<Mentor> mentorIDs;

    @ColumnInfo(name = "course_assessment_ids")
    private ArrayList<Assessment> assessmentIDs;

    @ColumnInfo(name = "course_notes")
    private String courseNotes;

    public Course(@NonNull int cID, @NonNull String cName, @NonNull String cStart, @NonNull String cEnd, @NonNull String cStatus, String cNotes, ArrayList<Mentor> mIDs, ArrayList<Assessment> aIDs) {
        this.courseID = cID;
        this.courseName = cName;
        this.courseStart = cStart;
        this.courseEnd = cEnd;
        this.courseStatus = cStatus;
        this.courseNotes = cNotes;
        this.mentorIDs = mIDs;
        this.assessmentIDs = aIDs;
    }

    public int getCourseID() {
        return this.courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseStart() {
        return this.courseStart;
    }

    public String getCourseEnd() {
        return this.courseEnd;
    }

    public String getCourseStatus() {
        return this.courseStatus;
    }

    public String getCourseNotes() {
        return this.courseNotes;
    }

    public ArrayList<Mentor> getMentorIDs() {
        return this.mentorIDs;
    }

    public ArrayList<Assessment> getAssessmentIDs() {
        return this.assessmentIDs;
    }


}
