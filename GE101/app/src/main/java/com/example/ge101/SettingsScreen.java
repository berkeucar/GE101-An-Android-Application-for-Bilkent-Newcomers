package com.example.ge101;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


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
    private SharedPreferences sharedPreferences;
    public static final String ex = "Switch";

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

        sharedPreferences = getSharedPreferences( "Switch", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        themeSwitch.setChecked( sharedPreferences.getBoolean( ex, false));
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if ( isChecked) {
                    editor.putBoolean( ex, true);
                    themeSwitchChecked = true;
                    Toast.makeText(SettingsScreen.this, "DARK THEME ON", Toast.LENGTH_SHORT).show();
                }
                else {
                    editor.putBoolean( ex, false);
                    themeSwitchChecked = false;
                    Toast.makeText(SettingsScreen.this, "LIGHT THEME ON", Toast.LENGTH_SHORT).show();
                }
                editor.commit();
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
