package com.example.zar.campusrecruitment.Model;

/**
 * Created by Zar on 2/12/2017.
 */

public class Student {

    private String name,experties,age,qulif,depat;
public  Student(){}
    public Student(String name,String experties,String age,String qulif,String depat)
    {
        this.name=name;
        this.experties=experties;
        this.age=age;
        this.qulif=qulif;
        this.depat=depat;
    }

    public String getAge() {
        return age;
    }

    public String getDepat() {
        return depat;
    }

    public String getExperties() {
        return experties;
    }

    public String getName() {
        return name;
    }

    public String getQulif() {
        return qulif;
    }


}
