package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final TermDao mDao;

        PopulateDbAsync(StudentSuccessDatabase db) {
            mDao = db.termDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAllTerms();
            Term term1 = new Term();
            term1.setTermID(1);
            term1.setTermName("Term One");
            term1.setTermStart("January 1 2018");
            term1.setTermEnd("June 30 2018");
            mDao.insert(term1);
            Term term2 = new Term();
            term2.setTermID(2);
            term2.setTermName("Term Two");
            term2.setTermStart("July 1 2018");
            term2.setTermEnd("December 31 2018");
            mDao.insert(term2);
            return null;
        }
    }


}
