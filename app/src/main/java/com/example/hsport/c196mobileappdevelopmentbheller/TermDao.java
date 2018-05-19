package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.Update;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface TermDao {

    @Insert
    void insert (Term term);

    @Delete
    void delete (Term term);

    @Update
    void update (Term term);

    @Query("SELECT * from term_table")
    LiveData<List<Term>> getAllTerms();

}
