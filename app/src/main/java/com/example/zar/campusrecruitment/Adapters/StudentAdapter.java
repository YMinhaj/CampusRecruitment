package com.example.zar.campusrecruitment.Adapters;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zar.campusrecruitment.Model.Student;
import com.example.zar.campusrecruitment.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.Query;

/**
 * Created by Zar on 2/12/2017.
 */

public class StudentAdapter extends FirebaseListAdapter<Student> {
    TextView edt_name,edt_qul,edt_expet,edt_age,edt_dep;
    public StudentAdapter(Activity activity, Class<Student> modelClass, int layout, Query ref)
    {
        super(activity,modelClass,layout,ref);
        mActivity=activity;
    }

    @Override
    protected void populateView(View v, Student model, int position) {
        edt_name= (TextView) v.findViewById(R.id.std_list_name);
        edt_age= (TextView) v.findViewById(R.id.std_list_age);
        edt_expet= (TextView) v.findViewById(R.id.std_list_expertis);
        edt_qul= (TextView) v.findViewById(R.id.std_list_qulification);
        edt_dep= (TextView) v.findViewById(R.id.std_list_dept);

        edt_name.setText(model.getName());
        edt_qul.setText(model.getQulif());
        edt_expet.setText(model.getExperties());
        edt_age.setText(model.getAge());
        edt_dep.setText(model.getDepat());


    }
}
