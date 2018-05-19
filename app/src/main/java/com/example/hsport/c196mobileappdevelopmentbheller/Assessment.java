package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "assessment_table")
public class Assessment {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "assessment_id")
    private int assessmentID;

    @NonNull
    @ColumnInfo(name = "assessment_name")
    private String assessmentName;

    @NonNull
    @ColumnInfo(name = "assessment_type")
    private String assessmentType;

    @NonNull
    @ColumnInfo(name = "assessment_due_date")
    private String assessmentDueDate;

    public Assessment() {}

    public Assessment(@NonNull int aID, @NonNull String aName, @NonNull String aType, @NonNull String aDueDate) {
        this.assessmentID = aID;
        this.assessmentName = aName;
        this.assessmentType = aType;
        this.assessmentDueDate = aDueDate;
    }

    public int getAssessmentID() {
        return this.assessmentID;
    }

    public String getAssessmentName() {
        return this.assessmentName;
    }

    public String getAssessmentType() {
        return this.assessmentType;
    }

    public String getAssessmentDueDate() {
        return this.assessmentDueDate;
    }

    public void setAssessmentID(int aID) {
        this.assessmentID = aID;
    }

    public void setAssessmentName(String aName) {
        this.assessmentName = aName;
    }

    public void setAssessmentType(String aType) {
        this.assessmentType = aType;
    }

    public void setAssessmentDueDate(String aDueDate) {
        this.assessmentDueDate = aDueDate;
    }

}
