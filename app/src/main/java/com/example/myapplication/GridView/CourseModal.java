package com.example.myapplication.GridView;

// Modal Class is the JAVA Class that handles data to be added in each GridView item of GridView
public class CourseModal {

    // string course_name for storing course_name
    // and imgid for storing image id.
    private String course_name;
    private int imgid;

    public CourseModal(String course_name, int imgid) {
        this.course_name = course_name;
        this.imgid = imgid;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getIbid() {
        return imgid;
    }

    public void setIbid(int ibid) {
        this.imgid = ibid;
    }
}
