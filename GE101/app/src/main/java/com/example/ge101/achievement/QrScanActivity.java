package com.example.ge101.achievement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ge101.R;

/**
 * This was suppose to be the QrScanner activity to scan
 * the question name to get the question that we wanted
 * @version 20/5/2020
 */
public class QrScanActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);
        ImageView qrDemoButton;
        qrDemoButton = (ImageView) findViewById(R.id.qrDemoView );
        qrDemoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openActivityQuestionBoard();
            }
        });
        TextView qrDemoText;
        String textForDemo;
        textForDemo = "This is the demo activity!" +
                " This was suppose to open a cam and scan the qrCode to scan and pass the " +
                "question to the next activity. Click the button to see the question. \n" +
                "If you are a coder that wants to change this Activity to a QrScanner you need to change" +
                " QrScanActivity. Check README.java for further information";
        qrDemoText = (TextView) findViewById( R.id.demoText);
        qrDemoText.setGravity( Gravity.CENTER_HORIZONTAL);
        qrDemoText.setText( textForDemo);
    }
    private void openActivityQuestionBoard()
    {
        Intent i;
        i = new Intent( this, QuestionBoard.class);
        startActivity( i);
    }
}
