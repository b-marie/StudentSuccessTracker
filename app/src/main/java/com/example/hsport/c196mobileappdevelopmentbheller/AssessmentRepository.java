package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AssessmentRepository {
    private AssessmentDao assessmentDao;
    private LiveData<List<Assessment>> allAssessments;

    AssessmentRepository(Application application) {
        StudentSuccessDatabase db = StudentSuccessDatabase.getDatabase(application);
        assessmentDao = db.assessmentDao();
        allAssessments = assessmentDao.getAllAssessments();
    }

    LiveData<List<Assessment>> getAllAssessments() {
        return allAssessments;
    }

    public void insert (Assessment assessment) {
        new AssessmentRepository.insertAsyncTask(assessmentDao).execute(assessment);
    }

    private static class insertAsyncTask extends AsyncTask<Assessment, Void, Void> {

        private AssessmentDao mAsyncTaskDao;

        insertAsyncTask(AssessmentDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Assessment... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
