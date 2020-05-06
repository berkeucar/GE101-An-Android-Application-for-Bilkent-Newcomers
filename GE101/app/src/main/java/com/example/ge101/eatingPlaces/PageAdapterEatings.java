package com.example.ge101.eatingPlaces;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * the adapter class for eating places main menu's tab {@link FragmentPagerAdapter}
 */
public class PageAdapterEatings extends FragmentPagerAdapter {
    //properties
    private int numberOfTabs;

    // constructors
    public PageAdapterEatings( FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    // methods
    /**
     * basic method that returns the fragment that we want to provide in the tab
     * @return Fragment MainCampusEatings or EastCampusEatings
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch ( position) {
            case 0:
                return new MainCampusEatings(); // opens the eating places menu for main campus (main campus tab)
            case 1:
                return new EastCampusEatings(); // opens the eating places menu for east campus (east campus tab)
            default:
                return null;
        }
    }

    /**
     * basic method that returns the number of tabs in the page
     * @return int numberOfTabs
     */
    @Override
    public int getCount() {
        return numberOfTabs;
    }

    /**
     * the method that returns tab's position
     * @return int POSITION_NONE
     */
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}