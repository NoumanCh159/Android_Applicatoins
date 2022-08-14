package com.nouma.practiceapplication;

import android.app.Application;

public class MainParent extends Application {

    private double FormNo;
    private String StuName;
    private String FatName;
    private long StuCNIC;
    private int Semester;

    public double getFormNo() {
        return FormNo;
    }

    public void setFormNo(double formNo) {
        FormNo = formNo;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getFatName() {
        return FatName;
    }

    public void setFatName(String fatName) {
        FatName = fatName;
    }

    public long getStuCNIC() {
        return StuCNIC;
    }

    public void setStuCNIC(long stuCNIC) {
        StuCNIC = stuCNIC;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }

    public MainParent(String stuName, String fatName) {

        StuName = stuName;
        FatName = fatName;
    }
}
