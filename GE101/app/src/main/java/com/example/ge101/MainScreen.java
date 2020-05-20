package com.example.ge101;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ge101.busSchedule.BusScheduleTab;
import com.example.ge101.eatingplaces.EatingPlaces;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

/**
 * This is the main screen of the app, it allows the user to view the map, eating places, and bus schedules
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */

public class MainScreen extends AppCompatActivity {

    // properties
    private static final String TAG = "MainScreen";
    private static final int ERROR_DIALOG_REQUEST = 9901;
    private ImageView startButton;
    private ImageView settingsButton;
    private ImageView busButton;
    private ImageView foodButton;
    private long mLastClickTime = 0;

    // methods

    /**
     * Creates the main screen and shows it to the user
     * @param savedInstanceState is the Bundle for this class
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        // this is the map button, sends the user to the map screen
        startButton = (ImageView) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openMainActivity();
            }
        });

        // this is the settings button, sends the user to the settings screen
        settingsButton = (ImageView) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openSettings();
            }
        });

        // this is the bus button, sends the user to the bus schedules tabs
        busButton = (ImageView) findViewById(R.id.busButton);
        busButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openBusSchedule();
            }
        });

        // this is the food button, sends the user to the food places tabs
        foodButton = (ImageView) findViewById(R.id.foodButton);
        foodButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openEatingPlaces();
            }
        });
    }

    /**
     * Opens the main activity, which is the map
     */
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Opens the settings menu
     */
    public void openSettings() {
        Intent intent = new Intent(this, SettingsScreen.class);
        startActivity(intent);
    }

    /**
     * Opens the bus schedules tabs
     */
    public void openBusSchedule() {
        Intent intent = new Intent(this, BusScheduleTab.class);
        startActivity(intent);
    }

    /**
     * Opens the eating places tabs
     */
    public void openEatingPlaces(){
        Intent intent = new Intent(this, EatingPlaces.class);
        startActivity(intent);
    }

    /**
     * Checks if the user can use google services
     * @return true or false depending on if the user can use google services
     */
    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainScreen.this);

        if (available == ConnectionResult.SUCCESS) {
            // everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services are working");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError((available))) {
            // an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainScreen.this, available, ERROR_DIALOG_REQUEST);
        } else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
