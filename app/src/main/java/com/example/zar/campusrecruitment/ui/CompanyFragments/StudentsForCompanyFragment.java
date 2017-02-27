package com.example.zar.campusrecruitment.ui.CompanyFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.zar.campusrecruitment.Adapters.StudentAdapter;
import com.example.zar.campusrecruitment.Model.Student;
import com.example.zar.campusrecruitment.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Zar on 2/12/2017.
 */

public class StudentsForCompanyFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.students_for_company_fragment,container,false);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://shoppingfirebase-99540.firebaseio.com/student");
        ListView listView= (ListView) rootView.findViewById(R.id.list_view_student);
        StudentAdapter adapter=new StudentAdapter(getActivity(),Student.class,R.layout.student_list_item,databaseReference);
        listView.setAdapter(adapter);
        return rootView;
    }
}
