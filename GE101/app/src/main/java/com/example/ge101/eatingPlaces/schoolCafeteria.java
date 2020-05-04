package com.example.ge101.eatingPlaces;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ge101.R;

public class schoolCafeteria extends AppCompatActivity {
    // constants
    final int ZOOM_LEVEL = 150;

    // variables

    //methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_cafeteria_menu);

        WebView webView = (WebView) findViewById(R.id.school_cafeteria_menu_View);
        webView.getSettings().setJavaScriptEnabled( true);
        webView.setWebViewClient( new WebViewClient());
        webView.setInitialScale( ZOOM_LEVEL);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://kafemud.bilkent.edu.tr/monu_tr.html");
    }
}
