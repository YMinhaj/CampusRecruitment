package com.example.zar.campusrecruitment.ui.CompanyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zar.campusrecruitment.Model.Vecancy;
import com.example.zar.campusrecruitment.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Zar on 2/12/2017.
 */

public class CompanyProfileFragment extends Fragment {


    Button create;
    EditText title,sal,age,qul,name;
    String sTitle,sSal,sAge,sQul,sName;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.company_profile_fragment,container,false);
        databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://shoppingfirebase-99540.firebaseio.com/companies");
        intiComp(rootView);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sTitle=title.getText().toString();
                sSal=sal.getText().toString();
                sAge=age.getText().toString();
                sQul=qul.getText().toString();
                sName=name.getText().toString();
                Vecancy vecancy=new Vecancy(sTitle,sSal,sAge,sQul,sName);
                databaseReference.push().setValue(vecancy);

                Toast.makeText(getActivity()," vecancy added ",Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    public  void intiComp(View v)
    {
        title= (EditText) v.findViewById(R.id.vec_title_edit_name);
        sal= (EditText) v.findViewById(R.id.vec_salary);
        age= (EditText) v.findViewById(R.id.vec_age_req);
        name= (EditText) v.findViewById(R.id.vec_comp_name);
        qul= (EditText) v.findViewById(R.id.vec_qulification);
        create= (Button) v.findViewById(R.id.frg_vec_create);


    }



}
