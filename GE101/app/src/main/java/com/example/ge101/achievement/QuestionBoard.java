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

/**
 * This is the QuestionBoard class to show the user question. Right now it is a demo for showing the
 * question. How I planned this code to work was to get the question from QrScanActivity and then
 *
 */
public class QuestionBoard extends AppCompatActivity {

    Question q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextView questionText = new TextView( this);
        final TextView buildingName = new TextView( this);
        final TextView informUser = new TextView( this);

        ArrayList<Answer> answers;
        LinearLayout layout = new LinearLayout( this);
        layout.setOrientation( LinearLayout.VERTICAL);

        // if QrScanActivity code is built for just delete this part and initialise the q with passed question
        Places p = new Places();
        Achievable a = p.findByName( "Starbucks Coffee");
        ArrayList l = a.getQuestions();
        //***********************
        q = (Question) l.get( 0);
        answers = q.getAnswers();



        informUser.setGravity(Gravity.CENTER_HORIZONTAL);
        questionText.setText( q.getQuestion() );
        questionText.setGravity(Gravity.CENTER_HORIZONTAL);
        buildingName.setText( q.getName() );
        buildingName.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView( buildingName);
        layout.addView( questionText);

        // Creating the buttons according to how much answers there are
        for( int i = 0; i < answers.size(); i++ )
        {
            final Button button = new Button( this);
            button.setId( i);
            button.setText( answers.get( i).getAnswer() );
            layout.addView( button);
            // adding the button so that  it changes the status of the question by answering and inform user
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( q.getQuestionStatus() == Question.NOT_ANSWERED) {
                        Boolean isCorrect = q.answerQuestion(q.getAnswers().get(button.getId()));
                        if (isCorrect) {
                            informUser.setText("Great Job You found it!!!");
                        } else
                            informUser.setText("Well that was wrong...");
                    }
                }
            });


        }
        layout.addView( informUser);
        setContentView( layout);

    }
}
