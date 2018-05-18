package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class TermRepository {
    private TermDao termDao;
    private LiveData<List<Term>> allTerms;

    TermRepository(Application application) {
        StudentSuccessDatabase db = StudentSuccessDatabase.getDatabase(application);
        termDao = db.termDao();
        allTerms = termDao.getAllTerms();
    }

    LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }

    public void insert (Term term) {
        new insertAsyncTask(termDao).execute(term);
    }

    private static class insertAsyncTask extends AsyncTask<Term, Void, Void> {

        private TermDao mAsyncTaskDao;

        insertAsyncTask(TermDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Term... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
