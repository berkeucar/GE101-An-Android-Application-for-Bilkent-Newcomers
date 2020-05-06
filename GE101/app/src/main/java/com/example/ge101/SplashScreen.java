package com.example.ge101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * This is the splash screen that shows up when the user opens the app initially
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class SplashScreen extends AppCompatActivity {

    // methods
    /**
     * Creates and shows the splash screen for the app
     * @param savedInstanceState is the Bundle of this class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent( SplashScreen.this, MainScreen.class));
                finish();
            }
        }, 1000);
    }
}
