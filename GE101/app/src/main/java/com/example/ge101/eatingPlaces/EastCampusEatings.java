package com.example.ge101.eatingPlaces;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.ge101.R;

/**
 * A simple {@link Fragment} subclass.
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class EastCampusEatings extends Fragment {

    // properties
    private Button schoolCafeteria;
    private Button coffeeBreakEast;
    private long mLastClickTime = 0;

    // constructor
    public EastCampusEatings() {
        // Required empty public constructor
    }

    //methods
    /**
     * the method that opens the east campus tab
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_east_campus_eating_places, container, false);

        // Button for school cafeteria
        schoolCafeteria = (Button) v.findViewById(R.id.school_cafeteria_east);
        schoolCafeteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                // creates intent (action) and opens it (for this condition school cafeteria's menu)
                Intent intent = new Intent(getActivity(), SchoolCafeteria.class);
                startActivity(intent);
            }
        });

        // Button for coffee break
        coffeeBreakEast = (Button) v.findViewById(R.id.coffee_break_east);
        coffeeBreakEast.setOnClickListener(new View.OnClickListener() {
            /**
             * the method that makes button to open the school cafeteria's menu when clicked
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                // creates intent (action) and opens it (for this condition school cafeteria's menu)
                Intent intent = new Intent(getActivity(), CoffeeBreakEast.class);
                startActivity(intent);
            }
        });

        return v;
    }
}