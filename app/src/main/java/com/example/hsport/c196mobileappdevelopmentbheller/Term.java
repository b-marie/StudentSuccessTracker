package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
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

    @NonNull
    @ColumnInfo(name = "term_course_ids")
    private ArrayList<Course> courseIDs;

    public Term(@NonNull int tID, @NonNull String tName, @NonNull String tStart, @NonNull String tEnd, ArrayList<Course> cIDs) {
        this.termID = tID;
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


}
