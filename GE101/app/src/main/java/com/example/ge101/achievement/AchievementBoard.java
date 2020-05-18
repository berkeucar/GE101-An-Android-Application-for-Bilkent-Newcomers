package com.example.ge101.achievement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ge101.R;
import com.example.ge101.locations.Places;

import java.util.ArrayList;

public class AchievementBoard extends AppCompatActivity {
    // properties



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_achievement_board);

        ArrayList<String> l;
        String total;
        TextView achievementText;

        l = Places.makePaneString( new Places());
        total = "";
        achievementText = (TextView) findViewById( R.id.achievement_strings);
        // Creates the String for to play it on the board
        for( String s : l )
            total = total + s + "\n";

        achievementText.setText( total );
    }
}