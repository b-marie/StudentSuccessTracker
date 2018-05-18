package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class AssessmentViewModel extends AndroidViewModel {
    private AssessmentRepository aRepository;
    private LiveData<List<Assessment>> allAssessments;

    public AssessmentViewModel(Application application) {
        super(application);
        aRepository = new AssessmentRepository(application);
        allAssessments = aRepository.getAllAssessments();
    }

    LiveData<List<Assessment>> getAllAssessments() {
        return allAssessments;
    }

    public void insert(Assessment assessment) {
        aRepository.insert(assessment);
    }
}
