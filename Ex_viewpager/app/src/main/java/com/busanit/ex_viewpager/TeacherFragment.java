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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);// false 정순, true 역순
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(new Teacher("교무기획부", "박 O O", "수학", "3-3"));
        teacherList.add(new Teacher("교무기획부", "장 O O", "국어", "3-7"));
        teacherList.add(new Teacher("교무기획부", "조 O O", "윤리", "1-3"));
        teacherList.add(new Teacher("교육연구부", "신 O O", "수학", "2-3"));
        teacherList.add(new Teacher("교육연구부", "전 O O", "일반사회", "3-4"));
        teacherList.add(new Teacher("교육연구부", "심 O O", "수학", "1-6"));
        teacherList.add(new Teacher("학생안전부", "김 O O", "일반사회", "1-7"));
        teacherList.add(new Teacher("학생안전부", "정 O O", "생명과학", "3-5"));
        teacherList.add(new Teacher("학생안전부", "권 O O", "수학", "2-2"));
        teacherList.add(new Teacher("인문교육부", "조 O O", "지리", "2-1"));

        TeacherAdapter adapter = new TeacherAdapter();
        adapter.setItems(teacherList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}