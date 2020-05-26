package com.example.ge101.busschedule;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * the adapter class for bus schedule main menu's tab {@link FragmentPagerAdapter}
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class PageAdapter extends FragmentPagerAdapter {

    // properties
    private int numberOfTabs;

    // constructors
    public PageAdapter( FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    // methods
    /**
     * basic method that returns the fragment that we want to provide in the tab
     * @param position
     * @return Fragment
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch ( position) {
            case 0:
                return new MainCamp(); // opens the bus schedule menu for main campus (main campus tab)
            case 1:
                return new com.example.ge101.busschedule.EastCamp(); // opens the bus schedule menu for east campus (east campus tab)
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
