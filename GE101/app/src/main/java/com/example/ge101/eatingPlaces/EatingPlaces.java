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

/**
 * the class that contains the eating places main screen's display {@link AppCompatActivity}
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */

public class EatingPlaces extends AppCompatActivity {

    // properties
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem mainCamp, eastCamp;
    public PageAdapterEatings pagerAdapter;

    // constructors

    // methods
    /**
     *the method that creates and opens the general tabbed eating places menu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating_places);

        // initializes tab layout and its items
        tabLayout = (TabLayout) findViewById(R.id.eatingsTab);
        mainCamp = (TabItem) findViewById(R.id.mainCampusTabEatings);
        eastCamp = (TabItem) findViewById(R.id.eastCampusTabEatings);

        // initializes the ViewPager
        viewPager = findViewById(R.id.eatingsViewPager);

        // initializes the Page Adapter that we wrote on separate class and sets it to ViewPager
        pagerAdapter = new PageAdapterEatings(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        // adds tab listener to the tab layout
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                // tab position 1 - main campus
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                // tab position 2 - east campus
                else if (tab.getPosition() == 1) {
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

        // adds the page change listener to tabs and page
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



    }
}
