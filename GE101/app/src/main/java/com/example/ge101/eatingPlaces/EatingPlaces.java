package com.example.ge101.eatingPlaces;

import android.content.Intent;
import android.os.Bundle;

import com.example.ge101.MainActivity;
import com.example.ge101.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class EatingPlaces extends AppCompatActivity {
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eating_places);

        Button schoolCafeteria = findViewById(R.id.school_cafeteria);
        schoolCafeteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openSchoolCafeteriaMenu();
            }
        });
    }

    public void openSchoolCafeteriaMenu() {
        Intent intent = new Intent(this, schoolCafeteria.class);
        startActivity(intent);
    }
}
