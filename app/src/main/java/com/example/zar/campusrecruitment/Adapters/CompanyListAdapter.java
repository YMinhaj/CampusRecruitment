package com.example.zar.campusrecruitment.Adapters;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.zar.campusrecruitment.Model.Vecancy;
import com.example.zar.campusrecruitment.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.Query;

/**
 * Created by Zar on 2/12/2017.
 */

public class CompanyListAdapter extends FirebaseListAdapter<Vecancy> {
TextView  title,compName,qulification,age;
    public CompanyListAdapter(Activity activity, Class<Vecancy> modelClass, int modelLayout, Query ref)
    {
        super(activity,modelClass,modelLayout,ref);
        mActivity=activity;
    }
    @Override
    protected void populateView(View v, Vecancy model, int position) {
        title= (TextView) v.findViewById(R.id.comp_list_title);
        compName= (TextView) v.findViewById(R.id.comp_list_name);
        qulification= (TextView) v.findViewById(R.id.comp_list_qulification);
        age= (TextView) v.findViewById(R.id.comp_list_age);

        title.setText(model.getTitle());
        compName.setText(model.getCompanyName());
        qulification.setText(model.getQulification());
        age.setText(model.getAge());
    }
}

