package com.example.ge101;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainScreen extends AppCompatActivity {

    private static final String TAG = "MainScreen";

    private static final int ERROR_DIALOG_REQUEST = 9901;


    private ImageView startButton;
    private ImageView settingsButton;
    private ImageView busButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        startButton = (ImageView) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        settingsButton = (ImageView) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        busButton = (ImageView) findViewById(R.id.busButton);
        busButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBusSchedule();
            }
        });

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openSettings() {
        Intent intent = new Intent(this, settings_screen.class);
        startActivity(intent);
    }

    public void openBusSchedule() {
        Intent intent = new Intent(this, BusSchedule.class);
        startActivity(intent);
    }


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
