package com.example.zar.campusrecruitment.ui.StudentFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.zar.campusrecruitment.Adapters.CompanyListAdapter;
import com.example.zar.campusrecruitment.Model.Vecancy;
import com.example.zar.campusrecruitment.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Zar on 2/12/2017.
 */

public class CompanyList extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View rootView=inflater.inflate(R.layout.company_list_fragment,container,false);
        ListView listView= (ListView) rootView.findViewById(R.id.listview_company);

        DatabaseReference database=FirebaseDatabase.getInstance().getReferenceFromUrl("https://shoppingfirebase-99540.firebaseio.com/companies");
        CompanyListAdapter companyListAdapter=new CompanyListAdapter(getActivity(), Vecancy.class,R.layout.comany_list,database);
        listView.setAdapter(companyListAdapter);
        return rootView;
    }
}
