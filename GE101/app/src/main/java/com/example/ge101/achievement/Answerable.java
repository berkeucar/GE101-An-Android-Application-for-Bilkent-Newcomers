package com.example.ge101.achievement;

import java.util.ArrayList;

/**
 * an interface to show that object is answerable
 */
public interface Answerable
{
    public boolean answerQuestion( Answer answer);
    public ArrayList<Answer> getAnswers();
    public void setRightAnswer( Answer rightAnswer );
    public void addAnswer( Answer answer);
    public Answer getRightAnswer();
    public int getQuestionStatus();
}
