package com.example.ge101.busSchedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ge101.R;

/**
 * EastCamp contains the bus schedule for the east campus and shows it to the user
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class eastCamp extends Fragment {
    final int ZOOM_LEVEL = 150;
    public eastCamp() {
        // Required empty public constructor
    }


    /**
     * Creates and shows the east campus bus schedule to the user in the app itself instead of
     * a remote browser
     * @param inflater is the LayoutInflater for this class
     * @param container is the ViewGroup for this class
     * @param savedInstanceState  is the Bundle for this class
     * @return view v
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_east_camp, container, false);
        WebView webView = (WebView) v.findViewById(R.id.eastWebView);
        webView.getSettings().setJavaScriptEnabled( true);
        webView.setWebViewClient( new WebViewClient());  // this opens the browser inside the app
        webView.setInitialScale( ZOOM_LEVEL);  // makes it so that it is zoomed out initially
        webView.getSettings().setDisplayZoomControls(false);  // disables zoom in/out buttons
        webView.getSettings().setBuiltInZoomControls(true);  // allows zooming in and out
        webView.loadUrl("http://www.bilkent.edu.tr/bilkent/admin-unit/transport/dogu_cizelge.htm");
        return v;
    }
}
