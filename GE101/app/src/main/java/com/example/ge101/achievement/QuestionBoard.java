package com.example.ge101.achievement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ge101.R;
import com.example.ge101.locations.Places;

import java.util.ArrayList;

public class QuestionBoard extends AppCompatActivity {

    Question q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Answer> answers;
        LinearLayout layout = new LinearLayout( this);
        layout.setOrientation( LinearLayout.VERTICAL);
        boolean answered;

        Places p = new Places();
        Achievable a = p.findByName( "Starbucks Coffee");
        ArrayList l = a.getQuestions();
        q = (Question) l.get( 0);
        answers = q.getAnswers();

        TextView questionText, buildingName;
        questionText = new TextView( this);
        buildingName = new TextView( this);
        questionText.setText( q.getQuestion() );
        questionText.setGravity(Gravity.CENTER_HORIZONTAL);
        buildingName.setText( q.getName() );
        buildingName.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView( buildingName);
        layout.addView( questionText);

        for( int i = 0; i < answers.size(); i++ )
        {
            final Button button = new Button( this);
            button.setId( i);
            button.setText( answers.get( i).getAnswer() );
            layout.addView( button);
        }

        // getting the text from main activity so that accomplished achievements are displayed
        //setContentView(R.layout.activity_question_board);
        setContentView( layout);

    }
}
