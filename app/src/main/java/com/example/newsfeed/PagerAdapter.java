package com.example.newsfeed;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabCount;


    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new home_fragments();
            case 1:
                return new sports_fragments();
            case 2:
                return new health_fragments();
            case 3:
                return new science_fragments();
            case 4:
                return new entertainment_fragments();
            case 5:
                return new tech_fragments();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
