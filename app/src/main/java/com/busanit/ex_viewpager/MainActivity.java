package com.busanit.ex_viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
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

    private OfficeFragment officeFragment;
    private SchoolFragment schoolFragment;
    private TeacherFragment teacherFragment;

    RecyclerView recyclerView;
    TeacherAdapter teacherAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_map){
            Intent intent =new Intent(this, MapActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager);
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        Fragment schoolFragment = new SchoolFragment();
        Fragment teacherFragment = new TeacherFragment();
        Fragment officeFragment = new OfficeFragment();
        fragments.add(schoolFragment);
        fragments.add(teacherFragment);
        fragments.add(officeFragment);

        MyPagerAdapter adapter = new MyPagerAdapter(this, fragments);
        pager.setAdapter(adapter);

        List<String> tabElement = Arrays.asList("학교 소개","교무실","행정실");
        new TabLayoutMediator(tabs, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(MainActivity.this);
                textView.setText(tabElement.get(position));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.gravity = Gravity.CENTER;
                textView.setLayoutParams(params);
                textView.setTextColor(Color.DKGRAY);
                textView.setPaintFlags(textView.getPaintFlags()| Paint.FAKE_BOLD_TEXT_FLAG);
                tab.setCustomView(textView);
            }
        }).attach();

    }

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