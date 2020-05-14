package com.example.ge101.eatingPlaces;

import android.content.Intent;
import android.os.Bundle;

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
public class MainCampusEatings extends Fragment {

    // properties
    private Button schoolCafeteria;
    private Button coffeeBreakMain;
    private Button mozartCafe;
    private long mLastClickTime = 0;

    // constructors
    public MainCampusEatings() {
        // Required empty public constructor
    }

    // methods

    /**
     * the method that provides the button actions and opens the main campus fragment
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View v
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_campus_eating_places, container, false);

        // Button for school cafeteria
        schoolCafeteria = (Button) v.findViewById(R.id.school_cafeteria);
        schoolCafeteria.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(getActivity(), SchoolCafeteria.class);
                startActivity(intent);
            }
        });

        // Button for school cafeteria
        schoolCafeteria = (Button) v.findViewById(R.id.school_cafeteria);
        schoolCafeteria.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(getActivity(), SchoolCafeteria.class);
                startActivity(intent);
            }
        });

        // Button for coffee break
        coffeeBreakMain = (Button) v.findViewById(R.id.coffee_break);
        coffeeBreakMain.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(getActivity(), CoffeeBreakMain.class);
                startActivity(intent);
            }
        });


        // Button for Mozart Cafe
        mozartCafe =(Button) v.findViewById(R.id.mozart_cafe);
        mozartCafe.setOnClickListener(new View.OnClickListener()
        {
            /**
             * the method that makes button to open the school cafeteria's menu when clicked
             * @param v
             */
            @Override
            public void onClick (View v)
            {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                // creates intent (action) and opens it (for this condition school cafeteria's menu)
                Intent intent = new Intent(getActivity(), MozartCafe.class);
                startActivity(intent);
            }
        });



        // after all buttons it returns v
        return v;
    }
}

