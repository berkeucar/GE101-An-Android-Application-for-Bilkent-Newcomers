package com.example.ge101;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;

import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import android.os.SystemClock;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Settings screen class
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class SettingsScreen extends AppCompatActivity
{
    // properties
    private ImageView theme;
    private boolean toggle;
    private SharedPreferences sharedPreferences;
    private long mLastClickTime = 0;

    public SettingsScreen()
    {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);

        theme = (ImageView) findViewById(R.id.theme);

        toggle = false;


        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();

                toggle = !toggle;

            }
        });
    }

    public boolean getToggle()
    {
        return toggle;
    }





}
