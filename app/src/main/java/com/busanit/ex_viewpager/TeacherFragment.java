package com.busanit.ex_viewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TeacherFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_teacher, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerTeacher);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("부장","김 0 0","수학"," "));
        teachers.add(new Teacher("기획1","이 0 0","중국어"," "));
        teachers.add(new Teacher("기획2","이 0 0","수학"," "));
        teachers.add(new Teacher("일과1","박 0 0","수학","3-3"));
        teachers.add(new Teacher("일과2","최 0 0","수학"," "));
        teachers.add(new Teacher("교육과정1","윤 0 0","수학"," "));
        teachers.add(new Teacher("교육과정2","이 0 0","역사"," "));
        teachers.add(new Teacher("생기부","장 0 0","국어","3-7"));
        teachers.add(new Teacher("출결,시상","조 0 0","윤리","1-3"));
        teachers.add(new Teacher("교육실무원","조 0 0"," "," "));

        TeacherAdapter adapter = new TeacherAdapter();
        adapter.setItems(teachers);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}