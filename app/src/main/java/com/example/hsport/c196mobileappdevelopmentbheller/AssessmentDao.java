package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface AssessmentDao {
    @Insert
    void insert (Assessment assessment);

    @Delete
    void delete (Assessment assessment);

    @Update
    void update (Assessment assessment);

    @Query("SELECT * from assessment_table")
    LiveData<List<Assessment>> getAllAssessments();
}
