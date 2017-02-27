package com.example.zar.campusrecruitment.Model;

/**
 * Created by Zar on 2/12/2017.
 */

public class Vecancy {
    String title,sal,age,qulification,companyName;
    public Vecancy()
    {}

    public Vecancy(String title,String sal,String age,String qulification,String companyName)
    {
        this.title=title;
        this.sal=sal;
        this.age=age;
        this.qulification=qulification;
        this.companyName=companyName;
    }

    public String getTitle() {
        return title;
    }

    public String getAge() {
        return age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getQulification() {
        return qulification;
    }

    public String getSal() {
        return sal;
    }

}

