package com.example.ge101;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BusSchedule extends AppCompatActivity {

    private WebView webView;
    final int ZOOM_LEVEL = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_schedule);
        webView = (WebView) findViewById( R.id.webView);
        webView.setWebViewClient( new WebViewClient());
        webView.setInitialScale( ZOOM_LEVEL);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://www.bilkent.edu.tr/bilkent/admin-unit/transport/merkez_cizelge.htm");
    }
}
