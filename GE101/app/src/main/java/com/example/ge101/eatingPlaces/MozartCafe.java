package com.example.ge101.eatingPlaces;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ge101.R;

public class MozartCafe extends AppCompatActivity {

    // properties
    private ImageView menu;
    private long mLastClickTime = 0;

    // constructors

    // methods
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mozart_cafe_screen);

        // Button for Mozart Cafe
        menu =(ImageView) findViewById(R.id.mozart_menu_button);
        menu.setOnClickListener(new View.OnClickListener()
        {
            /**
             * the method that makes button to open the school cafeteria's menu when clicked
             * @param v
             */
            @Override
            public void onClick (View v)
            {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openMenu();
            }
        });

        menu =(ImageView) findViewById(R.id.mozart_menu_button);
        menu.setOnClickListener(new View.OnClickListener()
        {
            /**
             * the method that makes button to open the school cafeteria's menu when clicked
             * @param v
             */
            @Override
            public void onClick (View v)
            {
                // Preventing multiple clicks, using threshold of 1 second
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                openMenu();
            }
        });
    }

    private void openMenu() {
        // creates intent (action) and opens it (for this condition school cafeteria's menu)
        Intent intent = new Intent(this, MozartCafeMenu.class);
        startActivity(intent);
    }

}
