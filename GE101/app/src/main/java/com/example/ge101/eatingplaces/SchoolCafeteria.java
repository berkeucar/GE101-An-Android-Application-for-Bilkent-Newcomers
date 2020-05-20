package com.example.ge101.eatingplaces;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ge101.R;

/**
 * the class that contains the school cafeteria's menu's display {@link AppCompatActivity}
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class SchoolCafeteria extends AppCompatActivity {

    // constants
    final int ZOOM_LEVEL = 150;

    // variables

    //methods
    /**
     * basic method that opens the school cafeteria's menu from  the internet link
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_cafeteria_menu);

        // creates the webView that opens the school cafeteria's internet page
        WebView webView = (WebView) findViewById(R.id.school_cafeteria_menu_View);
        webView.getSettings().setJavaScriptEnabled( true);
        webView.setWebViewClient( new WebViewClient());

        // arranges the zoom level and set its settings
        webView.setInitialScale( ZOOM_LEVEL);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://kafemud.bilkent.edu.tr/monu_tr.html");
    }
}
