package com.busanit.ex_viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class OfficeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_office,container,false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerOffice);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        //선긋기
        DividerItemDecoration divider = new DividerItemDecoration(getContext(),1);
        divider.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(divider);

        ArrayList<Office> officeList = new ArrayList<Office>();
        officeList.add(new Office("지방교육행정사무관","고 0 0"));
        officeList.add(new Office("지방교육행정주사","김 0 0"));
        officeList.add(new Office("지방교육행정주사보","김 0 0"));
        officeList.add(new Office("지방시설관리주사보","강 0 0"));
        officeList.add(new Office("지방교육행정서기","차 0 0"));
        officeList.add(new Office("교육공무직원","이 0 0"));
        officeList.add(new Office("교육공무직원","조 0 0"));
        officeList.add(new Office("교육공무직원","문 0 0"));
        officeList.add(new Office("전문상담사","김 0 0"));

        OfficeAdapter adapter = new OfficeAdapter();
        adapter.setItems(officeList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}