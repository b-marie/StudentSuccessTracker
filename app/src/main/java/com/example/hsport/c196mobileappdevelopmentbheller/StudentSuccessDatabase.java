package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {Term.class, Course.class, Mentor.class, Assessment.class}, version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class StudentSuccessDatabase extends RoomDatabase {
    public abstract TermDao termDao();
    public abstract CourseDao courseDao();
    public abstract MentorDao mentorDao();
    public abstract AssessmentDao assessmentDao();

    private static StudentSuccessDatabase INSTANCE;

    public static StudentSuccessDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (StudentSuccessDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            StudentSuccessDatabase.class, "student_success_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
