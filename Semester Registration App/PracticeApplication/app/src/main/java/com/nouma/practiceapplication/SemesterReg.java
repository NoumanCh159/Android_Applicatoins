package com.nouma.practiceapplication;

public class SemesterReg extends MainParent{

    private String Religion;
    private long PhoneNo;
    private String Gender;

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public long getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public SemesterReg(String stuName, String fatName, String religion, long phoneNo) {
        super(stuName, fatName);
        Religion = religion;
        PhoneNo = phoneNo;
    }
}
