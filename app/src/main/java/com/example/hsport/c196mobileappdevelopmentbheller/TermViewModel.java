package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class TermViewModel extends AndroidViewModel {
    private TermRepository tRepository;
    private LiveData<List<Term>> allTerms;

    public TermViewModel(Application application) {
        super(application);
        tRepository = new TermRepository(application);
        allTerms = tRepository.getAllTerms();
    }

    LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }

    public void insert(Term term) {
        tRepository.insert(term);
    }

}
