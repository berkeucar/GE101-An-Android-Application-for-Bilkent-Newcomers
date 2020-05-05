package com.example.ge101.eatingPlaces;

import android.content.Intent;
import android.os.Bundle;

import com.example.ge101.MainActivity;
import com.example.ge101.R;
import com.example.ge101.busSchedule.PageAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class EatingPlaces extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem mainCamp, eastCamp;
    public PageAdapterEatings pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating_places);

        tabLayout = (TabLayout) findViewById(R.id.eatingsTab);
        mainCamp = (TabItem) findViewById(R.id.mainCampusTabEatings);
        eastCamp = (TabItem) findViewById(R.id.eastCampusTabEatings);
        viewPager = findViewById(R.id.eatingsViewPager);

        pagerAdapter = new PageAdapterEatings(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                } else if (tab.getPosition() == 1) {
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

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
