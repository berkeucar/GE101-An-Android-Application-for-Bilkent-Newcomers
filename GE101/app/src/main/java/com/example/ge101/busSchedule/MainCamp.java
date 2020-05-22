package com.example.ge101.busschedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ge101.R;

/**
 * MainCamp contains the bus schedule for the main campus and shows it to the user
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */

public class MainCamp extends Fragment {

    // properties
    final int ZOOM_LEVEL = 150;

    // constructors
    public MainCamp() {
        // Required empty public constructor
    }

    // methods

    /**
     * Creates and shows the main campus bus schedule to the user in the app itself instead of
     * a remote browser
     * @param inflater is the LayoutInflater for this class
     * @param container is the ViewGroup for this class
     * @param savedInstanceState  is the Bundle for this class
     * @return view v
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_camp, container, false);
        WebView webView = (WebView) v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled( true);
        webView.setWebViewClient( new WebViewClient()); // this opens the browser inside the app
        webView.setInitialScale( ZOOM_LEVEL);  // makes it so that it is zoomed out initially
        webView.getSettings().setDisplayZoomControls(false); // disables zoom in/out buttons
        webView.getSettings().setBuiltInZoomControls(true); // allows zooming in and out
        webView.loadUrl("http://www.bilkent.edu.tr/bilkent/admin-unit/transport/merkez_cizelge.htm");
        return v;
    }
}
