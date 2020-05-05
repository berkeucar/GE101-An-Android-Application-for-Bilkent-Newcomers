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
 */
public class MainCampusEatings extends Fragment {

    // properties
    private Button schoolCafeteria;
    private long mLastClickTime = 0;

    // constructor
    public MainCampusEatings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_campus_eating_places, container, false);

        schoolCafeteria = (Button) v.findViewById(R.id.school_cafeteria);
        schoolCafeteria.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000)
                {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                Intent intent = new Intent(getActivity(), schoolCafeteria.class);
                startActivity(intent);
            }
        });
        return v;
    }
}

