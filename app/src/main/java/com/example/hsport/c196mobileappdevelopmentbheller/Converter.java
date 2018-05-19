package com.example.hsport.c196mobileappdevelopmentbheller;

import android.arch.persistence.room.TypeConverter;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Converter implements Serializable {
    @TypeConverter
    public String fromCoursesList(ArrayList<Course> courses) {
        if (courses == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Course>>() {
        }.getType();
        String jsonString = gson.toJson(courses, type);
        return jsonString;
    }

    @TypeConverter
    public ArrayList<Course> toCoursesList(String courseString) {
        if (courseString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Course>>() {
        }.getType();
        ArrayList<Course> coursesList = gson.fromJson(courseString, type);
        return coursesList;
    }

    @TypeConverter
    public String fromMentorsList(ArrayList<Mentor> mentors) {
        if (mentors == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Mentor>>() {
        }.getType();
        String jsonString = gson.toJson(mentors, type);
        return jsonString;
    }

    @TypeConverter
    public ArrayList<Mentor> toMentorsList(String mentorString) {
        if (mentorString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Mentor>>() {
        }.getType();
        ArrayList<Mentor> mentorsList = gson.fromJson(mentorString, type);
        return mentorsList;
    }

    @TypeConverter
    public String fromAssessmentsList(ArrayList<Assessment> assessments) {
        if (assessments == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Assessment>>() {
        }.getType();
        String jsonString = gson.toJson(assessments, type);
        return jsonString;
    }

    @TypeConverter
    public ArrayList<Assessment> toAssessmentsList(String assessmentString) {
        if (assessmentString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Assessment>>() {
        }.getType();
        ArrayList<Assessment> assessmentsList = gson.fromJson(assessmentString, type);
        return assessmentsList;
    }


}
