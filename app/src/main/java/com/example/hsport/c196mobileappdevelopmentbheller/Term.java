package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.ArrayList;

@Entity(tableName = "term_table")
public class Term {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "term_id")
    private int termID;

    @NonNull
    @ColumnInfo(name = "term_name")
    private String termName;

    @NonNull
    @ColumnInfo(name = "term_start")
    private String termStart;

    @NonNull
    @ColumnInfo(name = "term_end")
    private String termEnd;

    @TypeConverters(Converter.class)
    @ColumnInfo(name = "term_course_ids")
    private ArrayList<Course> courseIDs;

    public Term() {}

    public Term(@NonNull String tName, @NonNull String tStart, @NonNull String tEnd, ArrayList<Course> cIDs) {
        this.termName = tName;
        this.termStart = tStart;
        this.termEnd = tEnd;
        this.courseIDs = cIDs;
    }

    public int getTermID() {
        return this.termID;
    }

    public String getTermName() {
        return this.termName;
    }

    public String getTermStart() {
        return this.termStart;
    }

    public String getTermEnd() {
        return this.termEnd;
    }

    public ArrayList<Course> getCourseIDs() {
        return this.courseIDs;
    }

    public void setTermID(int tID) {
        this.termID = tID;
    }

    public void setTermName(String tName) {
        this.termName = tName;
    }

    public void setTermStart(String tStart) {
        this.termStart = tStart;
    }

    public void setTermEnd(String tEnd) {
        this.termEnd = tEnd;
    }

    public void setCourseIDs(ArrayList<Course> cIDs) {
        this.courseIDs = cIDs;
    }


}
