package com.example.zar.campusrecruitment.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zar.campusrecruitment.R;
import com.example.zar.campusrecruitment.ui.CompanyFragments.CompanyProfileFragment;
import com.example.zar.campusrecruitment.ui.CompanyFragments.StudentsForCompanyFragment;

public class StudentInUniActivity extends AppCompatActivity {
    Button profile,students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_in_uni);
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new CompanyProfileFragment()).commit();
        intiComponent();
        setClickListner();

    }

    public void intiComponent()
    {
        profile= (Button) findViewById(R.id.frg_vec);
        students= (Button) findViewById(R.id.frg_students);
    }

    public void setClickListner()
    {
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new CompanyProfileFragment()).commit();
            }
        });

        students.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content,new StudentsForCompanyFragment()).commit();
            }
        });
    }




}
