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
 * A simple {@link Fragment} subclass.
 */
public class mainCamp extends Fragment {
    final int ZOOM_LEVEL = 150;
    public mainCamp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main_camp, container, false);
        WebView webView = (WebView) v.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled( true);
        webView.setWebViewClient( new WebViewClient());
        webView.setInitialScale( ZOOM_LEVEL);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://www.bilkent.edu.tr/bilkent/admin-unit/transport/merkez_cizelge.htm");
        return v;
    }
}
