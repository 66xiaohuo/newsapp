package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private final String[] titles = new String[]{"left","home","right"};
    private final int[] pics = new int[]{R.drawable.subtitle_left_roll_h,R.drawable.subtitle_middle_roll_h,R.drawable.subtitle_right_roll_h};
    private TabLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.vp2);
        viewPager2.setAdapter(new FragmentAdapter(this));
        TabLayoutMediator tab = new TabLayoutMediator(tl, viewPager2, (tab1, position) -> {
            switch (position){
                case 0:
                    tab1.setIcon(getIcon(position));
                    //tab1.setText("photo");
                    break;
                case 1:
                    tab1.setIcon(getIcon(position));
                    //tab1.setText("home");
                    break;
                case 2:
                    tab1.setIcon(getIcon(position));
                   // tab1.setText("voice");
                    break;
            }
        });
        tab.attach();
    }

    private int getIcon(int position) {
        switch (position){
            case 0:
                return R.drawable.subtitle_left_roll_h;
            case 1:
                return R.drawable.subtitle_middle_roll_h;
            case 2:
                return R.drawable.subtitle_right_roll_h;
        }
        return position;
    }

    }
