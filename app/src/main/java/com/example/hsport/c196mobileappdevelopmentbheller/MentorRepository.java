package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MentorRepository {
    private MentorDao mentorDao;
    private LiveData<List<Mentor>> allMentors;

    MentorRepository(Application application) {
        StudentSuccessDatabase db = StudentSuccessDatabase.getDatabase(application);
        mentorDao = db.mentorDao();
        allMentors = mentorDao.getAllMentors();
    }

    LiveData<List<Mentor>> getAllMentors() {
        return allMentors;
    }

    public void insert (Mentor mentor) {
        new MentorRepository.insertAsyncTask(mentorDao).execute(mentor);
    }

    private static class insertAsyncTask extends AsyncTask<Mentor, Void, Void> {

        private MentorDao mAsyncTaskDao;

        insertAsyncTask(MentorDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Mentor... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
