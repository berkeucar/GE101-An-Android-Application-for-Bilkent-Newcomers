package com.example.ge101.achievement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ge101.R;
import com.example.ge101.locations.Places;

import java.util.ArrayList;

/**
 * An activity show achievements current status in terms of accomplishment
 * @author Efe Beydoğan, Arda Önal, Berke Uçar, Mert Barkın Er, Mehmet Alper Çetin
 * @version 12/5/2020
 */
public class AchievementBoard extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        TextView achievementText;
        super.onCreate( savedInstanceState);

        setContentView(R.layout.activity_achievement_board);

        // initializing the text from main activity's main activity so that accomplished achievements are displayed
        achievementText = (TextView) findViewById( R.id.achievement_strings);

        // getting the String of Achievements from main activity
        achievementText.setText( getIntent().getStringExtra( "ACHIEVEMENTS") );
    }
}
