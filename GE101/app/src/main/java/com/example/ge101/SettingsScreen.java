package com.example.ge101;

import android.app.Activity;
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
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Settings screen class
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 06.05.2020
 */
public class SettingsScreen extends AppCompatActivity
{
    // properties
    private Switch themeSwitch;
    private static boolean themeSwitchChecked;

    // constructors
    public SettingsScreen()
    {

    }

    // methods

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_screen);
        themeSwitch = (Switch) findViewById( R.id.themeSwitch);

        SharedPreferences sharedPreferences = getSharedPreferences( "save", MODE_PRIVATE);
        themeSwitch.setChecked( sharedPreferences.getBoolean( "value", true));

        // Add a listener to the switch button so the state of the button is saved after the activity is exited
        themeSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( themeSwitch.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences( "save", MODE_PRIVATE).edit();
                    editor.putBoolean( "value", true);
                    editor.apply();
                    themeSwitch.setChecked( true);
                    themeSwitchChecked = themeSwitch.isChecked();
                }
                else {
                    SharedPreferences.Editor editor = getSharedPreferences( "save", MODE_PRIVATE).edit();
                    editor.putBoolean( "value", false);
                    editor.apply();
                    themeSwitch.setChecked( false);
                    themeSwitchChecked = themeSwitch.isChecked();
                }
            }
        });




    }

    /**
     * A method that gives the state of the theme switch button
     * @return the state of the switch button
     */
    public static boolean getThemeSwitchChecked() {
        return themeSwitchChecked;
    }






}
