package com.example.zar.campusrecruitment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zar.campusrecruitment.ui.AdminLoginActivity;
import com.example.zar.campusrecruitment.ui.CompanyLoginActivity;
import com.example.zar.campusrecruitment.ui.StudentLoginActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCompany,btnAdmin,btnStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        setClickListner();
    }

    public void setClickListner()
    {
        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CompanyLoginActivity.class);
                startActivity(intent);
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, StudentLoginActivity.class);
                startActivity(intent);
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AdminLoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initComponent()
    {
        btnCompany= (Button) findViewById(R.id.main_btn_company);
        btnAdmin= (Button) findViewById(R.id.main_btn_admin);
        btnStudent= (Button) findViewById(R.id.main_btn_student);
    }
}
