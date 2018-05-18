package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MentorDao {
    @Insert
    void insert (Mentor mentor);

    @Delete
    void delete (Mentor mentor);

    @Update
    void update (Mentor mentor);

    @Query("SELECT * from mentor_table")
    LiveData<List<Mentor>> getAllMentors();

}
