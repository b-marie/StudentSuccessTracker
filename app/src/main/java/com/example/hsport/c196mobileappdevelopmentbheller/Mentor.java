package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "mentor_table")
public class Mentor {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "mentor_id")
    private int mentorID;

    @NonNull
    @ColumnInfo(name = "mentor_name")
    private String mentorName;

    @NonNull
    @ColumnInfo(name = "mentor_phone_number")
    private String mentorPhoneNumber;

    @NonNull
    @ColumnInfo(name = "mentor_email")
    private String mentorEmail;

    public Mentor() {}

    public Mentor(@NonNull int mID, @NonNull String mName, @NonNull String mPhone, @NonNull String mEmail) {
        this.mentorID = mID;
        this.mentorName = mName;
        this.mentorPhoneNumber = mPhone;
        this.mentorEmail = mEmail;
    }

    public int getMentorID() {
        return this.mentorID;
    }

    public String getMentorName() {
        return this.mentorName;
    }

    public String getMentorPhoneNumber() {
        return this.mentorPhoneNumber;
    }

    public String getMentorEmail() {
        return this.mentorEmail;
    }

    public void setMentorID(int mID) {
        this.mentorID = mID;
    }

    public void setMentorName(String mName) {
        this.mentorName = mName;
    }

    public void setMentorPhoneNumber(String mPhoneNumber) {
        this.mentorPhoneNumber = mPhoneNumber;
    }

    public void setMentorEmail(String mEmail) {
        this.mentorEmail = mEmail;
    }

}
