package com.example.zar.campusrecruitment.ui.StudentFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zar.campusrecruitment.Model.Student;
import com.example.zar.campusrecruitment.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zar on 2/12/2017.
 */

public class EditProfile extends Fragment {
    EditText stdName,stdExperties,stdAge,stdQul,stdDept;
    Button update;
    DatabaseReference databaseReference;
    String sName,sExpert,sAge,sQul,sDepart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.edit_std_profile_fragment,container,false);
        initComponent(rootView);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://shoppingfirebase-99540.firebaseio.com/student");
               DatabaseReference db=databaseReference.push();
                sName=stdName.getText().toString();
                sAge=stdAge.getText().toString();
                sExpert=stdExperties.getText().toString();
                sQul=stdQul.getText().toString();
                sDepart=stdDept.getText().toString();
                Student student=new Student(sName,sExpert,sAge,sQul,sDepart);
                HashMap<String,Object> stdUpdate=(HashMap<String,Object>)new ObjectMapper().convertValue(student,Map.class);
                db.updateChildren(stdUpdate);
                Toast.makeText(getActivity(),"Profile updated",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public void initComponent(View view)
    {
        stdName= (EditText) view.findViewById(R.id.std_pro_edit_name);
        stdExperties= (EditText) view.findViewById(R.id.std_pro_edit_experties);
        stdAge= (EditText) view.findViewById(R.id.std_pro_age);
        stdQul= (EditText) view.findViewById(R.id.std_pro_qulification);
        stdDept= (EditText) view.findViewById(R.id.std_pro_dept);
        update= (Button) view.findViewById(R.id.update_std);

    }

}

