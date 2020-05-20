package com.example.ge101.busschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ge101.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

/**
 * BusScheduleTab allows the user to go between the main campus bus schedule and east campus
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class BusScheduleTab extends AppCompatActivity {

    // properties
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem mainCamp, eastCamp;
    public PageAdapter pagerAdapter;


    // methods

    /**
     * creates two tabs to go between
     * @param savedInstanceState is the Bundle for this class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule_tab);

        tabLayout = (TabLayout) findViewById(R.id.busTab);
        mainCamp = (TabItem) findViewById(R.id.mainCampusTab);
        eastCamp = (TabItem) findViewById(R.id.eastCampusTab);
        viewPager = findViewById(R.id.busViewPager);

        pagerAdapter = new PageAdapter( getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter( pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition());
                if ( tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                else if ( tab.getPosition() == 1) {
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

        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout));
    }
}
