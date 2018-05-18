package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CourseDao {
    @Insert
    void insert (Course course);

    @Delete
    void delete (Course course);

    @Update
    void update (Course course);

    @Query("SELECT * from course_table")
    LiveData<List<Course>> getAllCourses();
}
