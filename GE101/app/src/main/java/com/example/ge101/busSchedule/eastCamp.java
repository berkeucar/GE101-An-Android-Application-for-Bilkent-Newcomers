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
public class eastCamp extends Fragment {
    final int ZOOM_LEVEL = 150;
    public eastCamp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_east_camp, container, false);
        WebView webView = (WebView) v.findViewById(R.id.eastWebView);
        webView.getSettings().setJavaScriptEnabled( true);
        webView.setWebViewClient( new WebViewClient());
        webView.setInitialScale( ZOOM_LEVEL);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://www.bilkent.edu.tr/bilkent/admin-unit/transport/dogu_cizelge.htm");
        return v;
    }
}
