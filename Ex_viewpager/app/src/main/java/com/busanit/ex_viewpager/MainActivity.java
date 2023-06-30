package com.busanit.ex_viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager2 pager;
    private List<String> tabElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // themes.xml   NoActionBar 설정해야 함

        TabLayout tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager);
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        Fragment schoolFragment = new SchoolFragment();
        Fragment teacherFragment = new TeacherFragment();
        Fragment officeFragment = new OfficeFragment();
        fragments.add(schoolFragment);
        fragments.add(teacherFragment);
        fragments.add(officeFragment);

        //        내부 클래스 객체 생성
        MyPagerAdapter adapter = new MyPagerAdapter(this, fragments);
        pager.setAdapter(adapter);

        tabElement = Arrays.asList("학교 소개", "교무실", "행정실");

//        TabLayoutMediator 탭과 뷰페이저 연결
        new TabLayoutMediator(tabs, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(tabElement.get(position));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.CENTER;
                textView.setLayoutParams(params);
                textView.setTextColor(Color.DKGRAY);
                textView.setPaintFlags(textView.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG); // 한글 볼드 효과
                tab.setCustomView(textView);
            }
        }).attach();

    }

    //  액션바의 옵션 메뉴 설정
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //    1. 옵션 메뉴 선택 시...
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_map){
            Intent intent = new Intent(this, RoadActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //    내부 클래스 상속받는 클래스 교재랑 다름
    class MyPagerAdapter extends FragmentStateAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> items) {
            super(fragmentActivity);
            this.items = items;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return items.get(position);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}