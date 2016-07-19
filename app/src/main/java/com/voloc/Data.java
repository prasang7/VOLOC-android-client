package com.voloc;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private String courseName;
    private String courseFaculty;
    private int photoId;

    public Data() {

    }

    public Data(String courseName, String courseFaculty, int photoId) {
        this.courseName = courseName;
        this.courseFaculty = courseFaculty;
        this.photoId = photoId;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName ) {
        this.courseName = courseName;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getCourseFaculty() {
        return courseFaculty;
    }

    public void setCourseFaculty(String courseFaculty) {
        this.courseFaculty = courseFaculty;
    }


}
