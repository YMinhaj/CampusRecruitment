package com.example.zar.campusrecruitment.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zar.campusrecruitment.R;
import com.example.zar.campusrecruitment.ui.StudentFragment.CompanyList;
import com.example.zar.campusrecruitment.ui.StudentFragment.EditProfile;

public class CompanyDataForStudentActivity extends AppCompatActivity {
    Button stdProfile,companies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_data_for_student);
        initComponent();
        getSupportFragmentManager().beginTransaction().replace(R.id.content1,new CompanyList()).commit();
        setOnClick();
    }

    public void initComponent()
    {
        stdProfile= (Button) findViewById(R.id.frg_std_profil);
        companies= (Button) findViewById(R.id.frg_company_list);
    }
    public void setOnClick()
    {
        stdProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().replace(R.id.content1,new EditProfile()).commit();
            }
        });
        companies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content1,new CompanyList()).commit();
            }
        });
    }
}
