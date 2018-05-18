package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {
    private CourseRepository cRepository;
    private LiveData<List<Course>> allCourses;

    public CourseViewModel(Application application) {
        super(application);
        cRepository = new CourseRepository(application);
        allCourses = cRepository.getAllCourses();
    }

    LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public void insert(Course course) {
        cRepository.insert(course);
    }
}
