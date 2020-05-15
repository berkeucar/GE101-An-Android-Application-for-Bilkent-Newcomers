package com.example.ge101.eatingPlaces;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ge101.R;

public class CoffeeBreakEast extends AppCompatActivity {
    // properties
    private ImageView menu;
    private long mLastClickTime = 0;

    // constructors

    // methods
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee_break_menu);


        menu =(ImageView) findViewById(R.id.cbmenubutton);
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
        Intent intent = new Intent(this, CoffeeBreakMenu.class);
        startActivity(intent);
    }
}
