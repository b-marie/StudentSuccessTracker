package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class MentorViewModel extends AndroidViewModel {
    private MentorRepository mRepository;
    private LiveData<List<Mentor>> allMentors;

    public MentorViewModel(Application application) {
        super(application);
        mRepository = new MentorRepository(application);
        allMentors = mRepository.getAllMentors();
    }

    LiveData<List<Mentor>> getAllMentors() {
        return allMentors;
    }

    public void insert(Mentor mentor) {
        mRepository.insert(mentor);
    }
}
