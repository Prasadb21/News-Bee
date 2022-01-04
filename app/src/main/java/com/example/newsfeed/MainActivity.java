package com.example.newsfeed;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    String API_KEY = "d37e88d125a740c7837af6b3a51dd14a";

    TabLayout tablayout;
    TabItem mHome , mSports , mHealth , mScience , mEntertainment , mTech;
    PagerAdapter pagerAdapter;
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        mHome = findViewById(R.id.home);
        mScience = findViewById(R.id.science);
        mHealth = findViewById(R.id.health);
        mSports = findViewById(R.id.sports);
        mTech = findViewById(R.id.technology);
        mEntertainment = findViewById(R.id.entertainment);
        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tablayout = findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager() , 6);
        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 ||tab.getPosition() == 1 ||tab.getPosition() == 2 ||tab.getPosition() == 3 ||tab.getPosition() == 4 ||tab.getPosition() == 5)
                {
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

    }



}