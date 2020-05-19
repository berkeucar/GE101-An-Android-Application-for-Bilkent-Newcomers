package com.example.ge101.eatingplaces;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ge101.R;

/**
 * This is the map class
 * @author Efe Beydoğan, Arda Önal, Mert Barkın Er, Berke Uçar, Mehmet Alper Çetin
 * @version 14.05.2020
 */
public class CoffeeBreakMenu extends AppCompatActivity {
    // properties
    private String menu;
    private TextView menuView;

    // methods
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cb_menu);

        //intializing menu
        menu = "TEA - 3TL \n" +
                "CHEESECAKE - 10TL \n" +
                "PASTA WITH TOMATO SAUCE \n";

        // finds the text view about menu ingredients and sets it to the menu
        menuView = findViewById(R.id.menu_cb);
        menuView.setText(menu);
    }
}
